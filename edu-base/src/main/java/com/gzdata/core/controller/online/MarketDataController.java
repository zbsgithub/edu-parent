package com.gzdata.core.controller.online;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.ActiveVendorDataDto;
import com.gzdata.core.dto.HouseMarketActivationDto;
import com.gzdata.core.dto.IndividualMarketActivationDto;
import com.gzdata.core.dto.ModelControllerDto;
import com.gzdata.core.dto.SalesfiguresDto;
import com.gzdata.core.model.ActiveVendorEntity;
import com.gzdata.core.service.SalesfiguresService;

/**
 * 市场数据-后台模块
 */
@RequestMapping("/api/anon/")
@RestController
public class MarketDataController {

	private static final Logger logger = LoggerFactory
			.getLogger(MarketDataController.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private SalesfiguresService salesfiguresService;

	/**
	 * 
	 * 功能描述： 下载模板 
	 * 	模块类型：0.销量数据 1.厂商活跃数据 2.ORS市场数据 
	 *  家庭类型：0.家庭 1.个人
	 *
	 * @param response
	 * @param modelType
	 * @return
	 * @throws IOException
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年9月11日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("/v2_1/market/data/down")
	public void downMarketDataTemplate(HttpServletResponse response,@RequestParam(name="modelType",value="modelType",required=false,defaultValue="0") int modelType) throws IOException {

		if(modelType==0){//销量
			exportSalesfiguresData(response);
		}else if(modelType==1){//活跃
			exportActiveVendorData(response);
		}else if(modelType==2){//家庭和个人
			exportHouseAndPersonData(response);
		}
		
	}
	


	public List<SalesfiguresDto> dataForSales() {
		List<SalesfiguresDto> resultStrList = new ArrayList<SalesfiguresDto>();
		SalesfiguresDto dto = new SalesfiguresDto();
		dto.setMonth("2020-02");
		dto.setBrand("tcl");
		dto.setProvince("江苏");
		dto.setType("全部品牌");
		dto.setCumulativeSales(1230);//累计销量
		dto.setNewSales(670);//新增销量
		
		resultStrList.add(dto);

		return resultStrList;
	}

	public List<ActiveVendorDataDto> dataForActive() {
		List<ActiveVendorDataDto> resultStrList = new ArrayList<ActiveVendorDataDto>();
		ActiveVendorDataDto dto = new ActiveVendorDataDto();
		dto.setMonth("2020-10");
		dto.setProvince("山东");
		dto.setType("互联网电视");
		dto.setMonthlyBootScale(19033939.03);//月开机规模
		dto.setMonthlyBootRate("30.56%");//月开机率
		
		dto.setDailyBootFrequency(13.01);//日均开机频次
		dto.setDailyBootRate("30.56%");//日开机率
		dto.setDailyBootScale(122.03);//日均开机时长
		dto.setDailyBootTime(12.03);//日均开机时长
		
		resultStrList.add(dto);

		return resultStrList;
	}

	public List<HouseMarketActivationDto> dataForHouse() {
		List<HouseMarketActivationDto> resultStrList = new ArrayList<HouseMarketActivationDto>();
		HouseMarketActivationDto dto = new HouseMarketActivationDto();
		dto.setMonth("2020-10");
		dto.setProvince("安徽");
		dto.setRegion("华东");
		dto.setCity("合肥");
		dto.setTier("二线城市");
		
		dto.setFamilyInventory(10383);
		dto.setFamilyLifeStage("一口之家");
		resultStrList.add(dto);

		return resultStrList;
	}

	public List<IndividualMarketActivationDto> dataForIndiviual() {
		List<IndividualMarketActivationDto> resultStrList = new ArrayList<IndividualMarketActivationDto>();
		IndividualMarketActivationDto dto = new IndividualMarketActivationDto();
		dto.setMonth("2020-10");
		dto.setProvince("安徽");
		dto.setRegion("华东");
		dto.setCity("合肥");
		dto.setTier("二线城市");
		
		dto.setGender("男");
		dto.setAge("15-14岁");
		dto.setPersonInventory(1038373);
		resultStrList.add(dto);

		return resultStrList;
	}
	/**
	 * 
	 * 功能描述：导入数据文件
	 *
	 * @param file
	 * @param modelType
	 *            0.销量数据 1.厂商活跃数据 2.ORS市场数据
	 * @param isShow
	 *            0.展示 1.不显示
	 * @return
	 * @throws IOException
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年9月11日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@PostMapping("/v2_1/market/data/import")
	@ResponseBody
	public Result uploadMarketDataTemplate(MultipartFile file,@RequestParam(name="modelType",value="modelType",required=true) int modelType)
					throws IOException {
		
		salesfiguresService.importData(file,modelType);
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：控制前端-是否展示
	 *
	 * @param modelType
	 *            0.销量数据 1.厂商活跃数据 2.ORS市场数据
	 * @param isShow
	 *            0.展示 1.不显示
	 * @familyType
	 *            0.家庭 1.个人           
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年9月11日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("/v2_1/market/data/is_show")
	public Result controlFrontIsShow(@RequestParam(name="modelType",value="modelType",required=false,defaultValue="0") int modelType,
			@RequestParam(name="isShow",value="isShow",required=false,defaultValue="0") int isShow) {
		logger.info("modelType:{} {}",modelType,isShow);
		
		salesfiguresService.controlFrontIsShow(modelType,isShow);
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}
	
	/**
	 * ORS市场数据
	 *  模块类型：0.销量数据 1.厂商活跃数据 2.ORS市场数据 
	 *  家庭类型：0.家庭 1.个人
	 * 
	 * @return
	 */
	@GetMapping("/v2_1/backstage/default/init/data")
	@ResponseBody
	public Result getBackStageInitData(@RequestParam(name="modelType",value="modelType",required=false,defaultValue="0") int modelType) {
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		
		//1.省份、品牌类型、品牌 区域、城市级别、城市、
		Query query = new Query();
        
		if (modelType == 0) {//销量数据
			resultMap.put("typeList", mongoTemplate.findDistinct(query, "type", "salesfigures", SalesfiguresDto.class));
			resultMap.put("brandList", mongoTemplate.findDistinct(query, "brand", "salesfigures", SalesfiguresDto.class));
			resultMap.put("provinceList", mongoTemplate.findDistinct(query, "province", "salesfigures", String.class));
			
			resultMap.put("months", mongoTemplate.findDistinct(query, "month", "salesfigures", SalesfiguresDto.class));
		} else if (modelType == 1) {//厂商活跃数据
			resultMap.put("provinceList", mongoTemplate.findDistinct(query, "province", "active_vendor_data", ActiveVendorDataDto.class));
			resultMap.put("typeList", mongoTemplate.findDistinct(query, "type", "active_vendor_data", ActiveVendorDataDto.class));
			
			resultMap.put("months", mongoTemplate.findDistinct(query, "month", "active_vendor_data", ActiveVendorDataDto.class));
		} else if (modelType == 2) {
			
			//家庭数据
			Map<String, Object> familyMap=new HashMap<>();
			
			familyMap.put("regionList", mongoTemplate.findDistinct(query, "region", "house_market_activation", HouseMarketActivationDto.class));
			familyMap.put("provinceList", mongoTemplate.findDistinct(query, "province", "house_market_activation", HouseMarketActivationDto.class));
			familyMap.put("tierList", mongoTemplate.findDistinct(query, "tier", "house_market_activation", HouseMarketActivationDto.class));
			familyMap.put("cityList", mongoTemplate.findDistinct(query, "city", "house_market_activation", HouseMarketActivationDto.class));
			familyMap.put("familyLifeStageList", mongoTemplate.findDistinct(query, "family_life_stage", "house_market_activation", HouseMarketActivationDto.class));//家庭生命周期
			familyMap.put("months", mongoTemplate.findDistinct(query, "month", "family_life_stage", HouseMarketActivationDto.class));//月份
			
			//当前月份
			Query queryMonth = new Query();
			queryMonth.addCriteria(Criteria.where("model_type").is(modelType));
			ModelControllerDto dto=	mongoTemplate.findOne(queryMonth, ModelControllerDto.class);
			familyMap.put("month", dto.getCreateTime());
 		   
			resultMap.put("familyData",familyMap);
			
			//个人数据
			Map<String, Object> personMap=new HashMap<>();
			
			personMap.put("regionList", mongoTemplate.findDistinct(query, "province", "individual_market_activation", IndividualMarketActivationDto.class));//大区
			personMap.put("provinceList", mongoTemplate.findDistinct(query, "province", "individual_market_activation", IndividualMarketActivationDto.class));//省份
			personMap.put("tierList", mongoTemplate.findDistinct(query, "tier", "individual_market_activation", IndividualMarketActivationDto.class));//城市级别
			personMap.put("cityList", mongoTemplate.findDistinct(query, "city", "individual_market_activation", IndividualMarketActivationDto.class));//城市
			personMap.put("ageList", mongoTemplate.findDistinct(query, "age", "individual_market_activation", IndividualMarketActivationDto.class));//年龄
			personMap.put("months", mongoTemplate.findDistinct(query, "month", "individual_market_activation", IndividualMarketActivationDto.class));//月份
			//当前月份
			Query queryPerson = new Query();
			queryPerson.addCriteria(Criteria.where("model_type").is(modelType));
			ModelControllerDto dtoPerson=	mongoTemplate.findOne(queryMonth, ModelControllerDto.class);
			personMap.put("month", dtoPerson.getCreateTime());
			
			resultMap.put("personData",personMap);
			
		}

		return Result.valueOf(Result.SUCCESS,"操作成功",resultMap);
	}
	

	/**
	 * 
	 * 功能描述：分页列表数据
	 *
	 * @param modelType
	 *            0.销量数据 1.厂商活跃数据 2.ORS市场数据 
	 * @param familyType
	 *            0.家庭 1.个人
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年9月11日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("/v2_1/market/data/page/list")
	@ResponseBody
	public Result getModelPageListInfo(@RequestParam(name="modelType",value="modelType",required=false,defaultValue="0") int modelType,
			@RequestParam(name="familyType",value="familyType",required=false,defaultValue="0")  int familyType, 
			@RequestParam(name="page",value="page",required=false,defaultValue="1") int page,
			@RequestParam(name="pageSize",value="pageSize",required=false,defaultValue="10") int pageSize,
			@RequestParam(name="month",value="month",required=true) String month,
			@RequestParam String filedName,
			@RequestParam String filedValue,
			@RequestParam String sortField,@RequestParam int orderName) {
		
		logger.info("filedName:{} filedValue:{}",filedName,filedValue);
		logger.info("param str:{} {} {} {} {}",modelType,familyType,sortField,orderName,month);
		
		Map<String, Object> resultMap=new HashMap<>();
		
		Criteria criteria =new Criteria();
		criteria.and("month").is(month);//月份
		if(filedName!=null && filedName.length()>0){
			
			String [] filedNameArrays = filedName.split("\\,");
			for (int i = 0; i < filedNameArrays.length; i++) {
				criteria.and(filedNameArrays[i]).in(filedValue.split("\\_")[i].split(","));//过滤条件
			}
		}
		
		int sumCount=0;//总记录数
		
		 //条件筛选操作
        AggregationOperation matchOperation = Aggregation.match(criteria);
        
		//排序操作
        AggregationOperation sortOperation = Aggregation.sort(orderName == 1 ? Sort.Direction.ASC : Sort.Direction.DESC,sortField);
        //跳过条数
        AggregationOperation skigOperation = Aggregation.skip((page-1)*pageSize);
        //选择条数
        /*if(pageSize==0 || pageSize == 10){
        	pageSize=1000;
        }*/
        AggregationOperation limitOperation =Aggregation.limit(pageSize);
        //从左到右按顺序操作,注意顺序不一样结果会不一样
        //例如先排序后取条数，和先去条数后排序是完全不一样的意思
        Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOperation,skigOperation,limitOperation);
		
        AggregationResults<Object> aggregationResults =null;
        		
        
      //当前列表在前端是否展示：
  		Query query = new Query();
  		if(modelType==0){//销量数据
  			query.addCriteria(Criteria.where("model_type").is(modelType));
  		}else if(modelType==1){
  			query.addCriteria(Criteria.where("model_type").is(modelType));
  		}else if(modelType==2){//ORS市场数据
  			query.addCriteria(Criteria.where("model_type").is(modelType));
  		}
  		ModelControllerDto dto=mongoTemplate.findOne(query, ModelControllerDto.class);
  		
  		resultMap.put("isShow", dto.getIsShow());//是否展示
  		
  		
		if (modelType == 0) {//销量数据
	       aggregationResults = mongoTemplate.aggregate(aggregation, SalesfiguresDto.class, Object.class);
	       sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), SalesfiguresDto.class, Object.class).getMappedResults().size();//总记录数
	       
		} else if (modelType == 1) {//厂商活跃数据
	        aggregationResults = mongoTemplate.aggregate(aggregation, ActiveVendorDataDto.class, Object.class);
	        sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), ActiveVendorDataDto.class, Object.class).getMappedResults().size();//总记录数
	        
	        DecimalFormat df = new DecimalFormat("#.00");
			List<ActiveVendorEntity> entityList=new ArrayList<>();
			List<Object> dtoList=aggregationResults.getMappedResults();
			for (Object object : dtoList) {
				ActiveVendorDataDto dtoTemp=(ActiveVendorDataDto)object;
				ActiveVendorEntity entity=new ActiveVendorEntity();
				entity.setId(dtoTemp.getId());
				entity.setType(dtoTemp.getType());
				entity.setProvince(dtoTemp.getProvince());
				entity.setMonth(dtoTemp.getMonth());
				
				entity.setMonthlyBootScale(dtoTemp.getMonthlyBootScale().intValue());//月开机规模
				if(dtoTemp.getMonthlyBootRate().contains("%")){
					entity.setMonthlyBootRate(dtoTemp.getMonthlyBootRate());//月开机率
				}else{
					String monthBootRate=new BigDecimal(dtoTemp.getMonthlyBootRate()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()+"%";
					entity.setMonthlyBootRate(monthBootRate);//月开机率
				}
				entity.setDailyBootScale(dtoTemp.getDailyBootScale().intValue());//日开机规模
				
				if(dtoTemp.getDailyBootRate().contains("%")){
					entity.setDailyBootRate(dtoTemp.getDailyBootRate());//日开机率
				}else {
					String dailiyBootRate=new BigDecimal(dtoTemp.getDailyBootRate()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()+"%";
					entity.setDailyBootRate(dailiyBootRate);//日开机率
				}
				
				entity.setDailyBootTime(df.format(dtoTemp.getDailyBootTime()));//日均开机时长
				entity.setDailyBootFrequency(df.format(dtoTemp.getDailyBootFrequency()));//日均开机频次
				
				entityList.add(entity);
			}
			
			resultMap.put("dataList", entityList);
			return Result.valueOf(Result.SUCCESS, "操作成功",sumCount,resultMap);
			
		} else if (modelType == 2) {
			
			if (familyType == 0) {//家庭
		        aggregationResults = mongoTemplate.aggregate(aggregation, HouseMarketActivationDto.class, Object.class);
		        sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), HouseMarketActivationDto.class, Object.class).getMappedResults().size();//总记录数
		        
			} else if (familyType == 1) {//个人
		        aggregationResults = mongoTemplate.aggregate(aggregation, IndividualMarketActivationDto.class, Object.class);
		        sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), IndividualMarketActivationDto.class, Object.class).getMappedResults().size();//总记录数
			}
		}
		
		
		resultMap.put("dataList", aggregationResults !=null ? aggregationResults.getMappedResults() : new ArrayList<>());
		
		
		return Result.valueOf(Result.SUCCESS, "操作成功",sumCount,resultMap);
		
	}
	
	
	public void  exportSalesfiguresData(HttpServletResponse response) throws IOException{
        List<SalesfiguresDto> userList =  dataForSales(); // 获取用户数据
        Map<String, String> fieldMap = new LinkedHashMap<String, String>(); // 数据列信息
    	fieldMap.put("month", "月份");
     	fieldMap.put("brand", "品牌");
     	fieldMap.put("brandType", "品牌类型");
     	fieldMap.put("province", "省份");
     	fieldMap.put("newSales", "新增销量");
     	fieldMap.put("cumulativeSales", "累计销量");
        XSSFWorkbook workbook = new XSSFWorkbook(); // 新建工作簿对象
        XSSFSheet sheet = workbook.createSheet("销量数据");// 创建sheet
        int rowNum = 0;
        Row row =  sheet.createRow(rowNum);// 创建第一行对象,设置表标题
        Cell cell;
        int cellNum = 0;
        for (String name:fieldMap.values()){
            cell = row.createCell(cellNum);
            cell.setCellValue(name);
            cellNum++;
        }
        int rows = 1;
         for (SalesfiguresDto user: userList){//遍历数据插入excel中
            row = sheet.createRow(rows);
            int col = 0;
            row.createCell(col).setCellValue(user.getMonth()); // month
            row.createCell(col+1).setCellValue(user.getBrand()); // 品牌
            row.createCell(col+2).setCellValue(user.getType()); // 品牌类型
            row.createCell(col+3).setCellValue(user.getProvince()); // 省份
            row.createCell(col+4).setCellValue(user.getNewSales()); // 编码
            row.createCell(col+5).setCellValue(user.getCumulativeSales()); // 备注comment
            rows++;
        }
        String fileName = URLEncoder.encode("销量数据-模板", "UTF-8");
        OutputStream out =null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
            workbook.close();
        }
    }

    //厂商活跃数据
    public void  exportActiveVendorData(HttpServletResponse response) throws IOException{
        List<ActiveVendorDataDto> userList =  dataForActive(); // 获取用户数据
        Map<String, String> fieldMap = new LinkedHashMap<String, String>(); // 数据列信息
    	fieldMap.put("month", "月份");
     	fieldMap.put("type", "品牌类型");
     	fieldMap.put("province", "省份");
     	fieldMap.put("monthlyBootScale", "月开机规模");
     	
     	fieldMap.put("monthlyBootRate", "月开机率");
     	fieldMap.put("dailyBootScale", "日均开机规模");
     	fieldMap.put("dailyBootRate", "日均开机率");
     	fieldMap.put("dailyBootTime", "日均开机时长");
     	fieldMap.put("dailyBootFrequency", "日均开机频次");
     	
        XSSFWorkbook workbook = new XSSFWorkbook(); // 新建工作簿对象
        XSSFSheet sheet = workbook.createSheet("厂商活跃数据");// 创建sheet
        int rowNum = 0;
        Row row =  sheet.createRow(rowNum);// 创建第一行对象,设置表标题
        Cell cell;
        int cellNum = 0;
        for (String name:fieldMap.values()){
            cell = row.createCell(cellNum);
            cell.setCellValue(name);
            cellNum++;
        }
        int rows = 1;
         for (ActiveVendorDataDto user: userList){//遍历数据插入excel中
            row = sheet.createRow(rows);
            int col = 0;
            row.createCell(col).setCellValue(user.getMonth()); // month
            row.createCell(col+1).setCellValue(user.getType()); // 品牌
            row.createCell(col+2).setCellValue(user.getProvince()); // 品牌类型
            row.createCell(col+3).setCellValue(user.getMonthlyBootScale()); // 省份
            row.createCell(col+4).setCellValue(user.getMonthlyBootRate()); // 编码
            row.createCell(col+5).setCellValue(user.getDailyBootScale()); // 备注comment
            row.createCell(col+6).setCellValue(user.getDailyBootRate()); // 备注comment
            row.createCell(col+7).setCellValue(user.getDailyBootTime()); // 备注comment
            row.createCell(col+8).setCellValue(user.getDailyBootFrequency()); // 备注comment
            rows++;
        }
        String fileName = URLEncoder.encode("厂商活跃数据-模板", "UTF-8");
        OutputStream out =null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
            workbook.close();
        }
    }

    
    public void  exportHouseAndPersonData(HttpServletResponse response) throws IOException{
        List<HouseMarketActivationDto> houseList =  dataForHouse(); // 获取家庭数据
        List<IndividualMarketActivationDto> personList =  dataForIndiviual(); // 获取个人数据
        
        Map<String, String> fieldMapHouse = new LinkedHashMap<String, String>(); // 家庭数据列信息
    	fieldMapHouse.put("month", "月份");
    	fieldMapHouse.put("province", "省份");
     	fieldMapHouse.put("region", "区域");
     	fieldMapHouse.put("city", "城市");
     	
     	fieldMapHouse.put("tier", "城市级别");
     	fieldMapHouse.put("familyLifeStage", "家庭生命周期");
     	fieldMapHouse.put("familyInventory", "激活量");
     	
     	Map<String, String> fieldMapPerson = new LinkedHashMap<String, String>(); // 个人数据列信息
     	fieldMapPerson.put("month", "月份");
     	fieldMapPerson.put("province", "省份");
     	fieldMapPerson.put("region", "区域");
     	fieldMapPerson.put("city", "城市");
     	
     	fieldMapPerson.put("tier", "城市级别");
     	fieldMapPerson.put("gender", "性别");
     	fieldMapPerson.put("age", "年龄");
     	fieldMapPerson.put("personInventory", "激活量");
     	
        XSSFWorkbook workbook = new XSSFWorkbook(); // 新建工作簿对象
        XSSFSheet sheetHouse = workbook.createSheet("家庭分市场激活量");// 创建sheet
        XSSFSheet sheetPerson = workbook.createSheet("个人分市场激活量");// 创建sheet
        
        int rowNumHouse = 0;
        Row row =  sheetHouse.createRow(rowNumHouse);// 创建第一行对象,设置表标题
        Cell cell;
        int cellNum = 0;
        for (String name:fieldMapHouse.values()){
            cell = row.createCell(cellNum);
            cell.setCellValue(name);
            cellNum++;
        }
        
        int rows = 1;
         for (HouseMarketActivationDto user: houseList){//遍历数据插入excel中
            row = sheetHouse.createRow(rows);
            int col = 0;
            
            row.createCell(col).setCellValue(user.getMonth()); // month
            row.createCell(col+1).setCellValue(user.getProvince()); // 品牌
            row.createCell(col+2).setCellValue(user.getRegion()); // 品牌类型
            row.createCell(col+3).setCellValue(user.getCity()); // 省份
            row.createCell(col+4).setCellValue(user.getTier()); // 编码
            row.createCell(col+5).setCellValue(user.getFamilyLifeStage()); // 备注comment
            row.createCell(col+6).setCellValue(user.getFamilyInventory()); // 备注comment
            rows++;
        }
         //以下为新的sheet页----------------begin
         int rowNumPerson = 0;
         Row rowPerson =  sheetPerson.createRow(rowNumPerson);// 创建第一行对象,设置表标题
	     Cell cellPerson;
         int cellNumPerson = 0;
         
        for (String name:fieldMapPerson.values()){
        	cellPerson = rowPerson.createCell(cellNumPerson);
        	cellPerson.setCellValue(name);
        	cellNumPerson++;
        }
        int rowsPerson = 1;
         for (IndividualMarketActivationDto user: personList){//遍历数据插入excel中
        	 rowPerson = sheetPerson.createRow(rowsPerson);
            int col = 0;
            
            rowPerson.createCell(col).setCellValue(user.getMonth()); // month
            rowPerson.createCell(col+1).setCellValue(user.getProvince()); // 品牌
            rowPerson.createCell(col+2).setCellValue(user.getRegion()); // 品牌类型
            rowPerson.createCell(col+3).setCellValue(user.getCity()); // 省份
            rowPerson.createCell(col+4).setCellValue(user.getTier()); // 编码
            rowPerson.createCell(col+5).setCellValue(user.getGender()); // 备注comment
            rowPerson.createCell(col+6).setCellValue(user.getAge()); // 备注comment
            rowPerson.createCell(col+7).setCellValue(user.getPersonInventory()); // 备注comment
            rowsPerson++;
        }
         
         //以下为新的sheet页----------------end
	         
        String fileName = URLEncoder.encode("ORS市场数据-模板", "UTF-8");
        OutputStream out =null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
            workbook.close();
        }
    }
	

}
