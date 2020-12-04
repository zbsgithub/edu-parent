package com.gzdata.core.controller.online;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.util.DateUtil;
import com.gzdata.common.util.SpellComparator;
//import com.gzdata.core.clickDao.MarketDataOverviewDao;
import com.gzdata.core.dto.ActiveVendorDataDto;
import com.gzdata.core.dto.HouseMarketActivationDto;
import com.gzdata.core.dto.IndividualMarketActivationDto;
import com.gzdata.core.dto.ModelControllerDto;
import com.gzdata.core.dto.SalesfiguresDto;
import com.gzdata.core.model.ActiveVendorEntity;
import com.gzdata.core.service.SalesfiguresService;

/**
 * 市场规模-前台模块
 */
@RestController
@RequestMapping("/api/anon/")
public class MarketSizeCroller {
	private static final Logger logger = LoggerFactory.getLogger(MarketSizeCroller.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private SalesfiguresService salesfiguresService;
/*	@Autowired
	private MarketDataOverviewDao marketDataOverviewDao;*/

	/**
	 * 
	 * 功能描述：分页查询所有数据
	 *
	 * @param modelType
	 * @param familyType
	 * 
	 *  模块类型：0.销量数据 1.厂商活跃数据 2.ORS市场数据 
	 *  家庭类型：0.家庭 1.个人
	 *  
	 * @param page
	 * @param pageSize
	 * @param sortField
	 * @param orderName
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年9月14日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("/v2_1/market/size/page/list")
	@ResponseBody
	public Result getModelPageListInfo(@RequestParam(name="modelType",value="modelType",required=false,defaultValue="1") int modelType,
			@RequestParam(name="familyType",value="familyType",required=false,defaultValue="1") int familyType, 
			@RequestParam(name="page",value="page",required=false,defaultValue="1") int page,
			@RequestParam(name="pageSize",value="pageSize",required=false,defaultValue="10") int pageSize,
			@RequestParam String filedName,
			@RequestParam String filedValue,
			@RequestParam String sortField,
			@RequestParam(name="orderName",value="orderName",required=false,defaultValue="1") int orderName,
			@RequestParam String month) {
		
		logger.info("modelType:{} familyType:{} page:{} pageSize:{} filedName:{} filedValue:{} sortField:{} orderName:{} month:{} ",modelType,familyType,page,pageSize,filedName,filedValue,sortField,orderName,month);
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
        @SuppressWarnings("deprecation")
		AggregationOperation skigOperation = Aggregation.skip((page-1)*pageSize);//跳过的条数：(页码-1)*每页大小
        //选择条数
        AggregationOperation limitOperation =Aggregation.limit(pageSize);//取的记录数
        //从左到右按顺序操作,注意顺序不一样结果会不一样
        //例如先排序后取条数，和先去条数后排序是完全不一样的意思
        Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOperation,skigOperation,limitOperation);
		
        AggregationResults<Object> aggregationResults =null;
        
        Query query = new Query();
		if(modelType==0){//销量数据
			query.addCriteria(Criteria.where("model_type").is(modelType));
		}else if(modelType==1){
			query.addCriteria(Criteria.where("model_type").is(modelType));
		}else if(modelType==2){//ORS市场数据
			query.addCriteria(Criteria.where("model_type").is(modelType));
//			query.addCriteria(Criteria.where("family_type").is(familyType));
		}
		
		ModelControllerDto modelControllerDto=mongoTemplate.findOne(query, ModelControllerDto.class,"model_control");
		logger.info("模型控制对象数据：{}",modelControllerDto.toString());
		
		if (modelType == 0) {//销量数据
			if(modelControllerDto.getIsShow()==0){//0.展示 1.不显示
				aggregationResults = mongoTemplate.aggregate(aggregation, SalesfiguresDto.class, Object.class);
				sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), SalesfiguresDto.class, Object.class).getMappedResults().size();//总记录数
			}
	       
		} else if (modelType == 1) {//厂商活跃数据
			if(modelControllerDto.getIsShow()==0){//0.展示 1.不显示
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
					
					entity.setDailyBootTime(String.valueOf(df.format(dtoTemp.getDailyBootTime())));//日均开机时长
					entity.setDailyBootFrequency(String.valueOf(df.format(dtoTemp.getDailyBootFrequency())));//日均开机频次
					
					entityList.add(entity);
				}
				
				return Result.valueOf(Result.SUCCESS, "操作成功",sumCount,entityList);
			}
	        
		} else if (modelType == 2) {
			
			if (familyType == 0) {//家庭
				if(modelControllerDto.getIsShow()==0){//0.展示 1.不显示
					aggregationResults = mongoTemplate.aggregate(aggregation, HouseMarketActivationDto.class, Object.class);
					sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), HouseMarketActivationDto.class, Object.class).getMappedResults().size();//总记录数
				}
			} else if (familyType == 1) {//个人
				if(modelControllerDto.getIsShow()==0){//0.展示 1.不显示
					aggregationResults = mongoTemplate.aggregate(aggregation, IndividualMarketActivationDto.class, Object.class);
					sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), IndividualMarketActivationDto.class, Object.class).getMappedResults().size();//总记录数
				}
			}
			
		}
		
		return Result.valueOf(Result.SUCCESS, "操作成功",sumCount,aggregationResults!=null ? aggregationResults.getMappedResults() : new ArrayList());
		
	}

	/**
	 * ORS市场数据
	 *  模块类型：0.销量数据 1.厂商活跃数据 2.ORS市场数据 
	 *  家庭类型：0.家庭 1.个人
	 * 
	 * @return
	 */
	@GetMapping("/v2_1/default/market/ors/data")
	@ResponseBody
	public Result getDefaultDataInfo(@RequestParam(name="modelType",value="modelType",required=false,defaultValue="0") int modelType,
			@RequestParam(name="familyType",value="familyType",required=false,defaultValue="1") int familyType,
			@RequestParam(name="month",value="month",required=false) String month) {
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		
		//1.省份、品牌类型、品牌 区域、城市级别、城市、
		Query query = new Query();
        
		if (modelType == 0) {//销量数据
			List<String> strList=mongoTemplate.findDistinct(query, "province", "salesfigures", String.class);
			Collections.sort(strList, new SpellComparator());
			
			resultMap.put("provinceList",strList);
			resultMap.put("typeList",mongoTemplate.findDistinct(query, "type", "salesfigures", SalesfiguresDto.class) );
			resultMap.put("brandList", mongoTemplate.findDistinct(query, "brand", "salesfigures", SalesfiguresDto.class));
			resultMap.put("months", mongoTemplate.findDistinct(query, "month", "salesfigures", SalesfiguresDto.class));
			
		} else if (modelType == 1) {//厂商活跃数据
			List<String> strList=mongoTemplate.findDistinct(query, "province", "active_vendor_data", String.class);
			Collections.sort(strList, new SpellComparator());
			
			resultMap.put("provinceList",strList);
			resultMap.put("typeList", mongoTemplate.findDistinct(query, "type", "active_vendor_data", ActiveVendorDataDto.class));
			resultMap.put("months", mongoTemplate.findDistinct(query, "month", "active_vendor_data", ActiveVendorDataDto.class));
		} else if (modelType == 2) {
			
			if (familyType == 0) {//家庭
			   List<String> strList=mongoTemplate.findDistinct(query, "province", "house_market_activation", String.class);
			   Collections.sort(strList, new SpellComparator());
				
			   resultMap.put("provinceList",strList);
			   resultMap.put("regionList", mongoTemplate.findDistinct(query, "region", "house_market_activation", HouseMarketActivationDto.class));
    		   resultMap.put("tierList", mongoTemplate.findDistinct(query, "tier", "house_market_activation", HouseMarketActivationDto.class));
    		   resultMap.put("cityList", mongoTemplate.findDistinct(query, "city", "house_market_activation", HouseMarketActivationDto.class));
    		   resultMap.put("familyLifeStageList", mongoTemplate.findDistinct(query, "family_life_stage", "house_market_activation", HouseMarketActivationDto.class));//家庭生命周期
    		   resultMap.put("months", mongoTemplate.findDistinct(query, "month", "house_market_activation", HouseMarketActivationDto.class));
				
			} else if (familyType == 1) {//个人
		       List<String> strList= mongoTemplate.findDistinct(query, "province", "individual_market_activation", String.class);
			   Collections.sort(strList, new SpellComparator());
			   
			   resultMap.put("provinceList",strList);//省份
			   resultMap.put("regionList", mongoTemplate.findDistinct(query, "region", "individual_market_activation", IndividualMarketActivationDto.class));//大区
    		   resultMap.put("tierList", mongoTemplate.findDistinct(query, "tier", "individual_market_activation", IndividualMarketActivationDto.class));//城市级别
    		   resultMap.put("cityList", mongoTemplate.findDistinct(query, "city", "individual_market_activation", IndividualMarketActivationDto.class));//城市
    		   resultMap.put("ageList", mongoTemplate.findDistinct(query, "age", "individual_market_activation", IndividualMarketActivationDto.class));//年龄
    		   resultMap.put("months", mongoTemplate.findDistinct(query, "month", "individual_market_activation", IndividualMarketActivationDto.class));
			}
			
		   /**
		    * 市场规模
		    * 	1.家庭规模、环比
		    *   2.个人规模、环比
		    */
		   
		   
		   /**
		    * 上一个月
		    * DateUtil.getDate(DateUtil.addMonths(DateUtil.parse("2020-09", DateUtil.DEFAULT_YEARMONTH_FORMAT),-1),DateUtil.DEFAULT_YEARMONTH_FORMAT)
		    */
		   if(month!=null && month.length()>0){//用户指定月份
			   ScaleAndProportion(month, resultMap);
		   }else {//默认月份
			   List<String> monthList =(List<String>)resultMap.get("months");
			   
			   Collections.sort(monthList, new Comparator<String>() {
		            @Override
		            public int compare(String o1, String o2) {
		                return o2.compareTo(o1);
		            }
		        });
			   
			   if(monthList.size()==0){
				   logger.info("默认月份无数据");
			   }else{
				   ScaleAndProportion(monthList.get(0), resultMap);
			   }
		   }
		}

		return Result.valueOf(Result.SUCCESS,"操作成功",resultMap);
	}

	private void ScaleAndProportion(String month, Map<String, Object> resultMap) {
		logger.info("进入方法");
		//家庭
		   String preMonthStr=DateUtil.getDate(DateUtil.addMonths(DateUtil.parse(month, DateUtil.DEFAULT_YEARMONTH_FORMAT),-1),DateUtil.DEFAULT_YEARMONTH_FORMAT);
		   Integer currentMonth=computerHouseInventory(month);
		   Integer currentPreMonth=computerHouseInventory(preMonthStr);
//		   logger.info("家庭当月{}：{} 上月：{}",month,currentMonth,currentPreMonth);
		   logger.info("家庭月份{}  对应 数据：{} 上月数据：{}",month,currentMonth,currentPreMonth);
		   
		   if(currentPreMonth!=0){
			   BigDecimal familyPercent= new BigDecimal(currentMonth-currentPreMonth).divide(new BigDecimal(currentPreMonth), 4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
			   resultMap.put("familyComparison",familyPercent+"%");
			   resultMap.put("familyNumTrend",familyPercent.compareTo(new BigDecimal(0))==1 ? true : false);
		   }else{
			   resultMap.put("familyComparison","100%");
			   resultMap.put("familyNumTrend",true);
		   }
		   resultMap.put("householdSize", currentMonth);

		   //个人
		   //上个月
		   String preMonthStrPerson=DateUtil.getDate(DateUtil.addMonths(DateUtil.parse(month, DateUtil.DEFAULT_YEARMONTH_FORMAT),-1),DateUtil.DEFAULT_YEARMONTH_FORMAT);
		   Integer currentMonthPerson=computerPersonInventory(month);
		   Integer currentPreMonthPerson=computerPersonInventory(preMonthStrPerson);
		   logger.info("个人月份{}  对应 数据：{} 上月数据：{}",month,currentMonthPerson,currentPreMonthPerson);
		   
		   if(currentPreMonthPerson!=0){
			   BigDecimal familyPercent= new BigDecimal(currentMonthPerson-currentPreMonthPerson).divide(new BigDecimal(currentPreMonthPerson),4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
			   resultMap.put("personComparison",familyPercent+"%");
			   resultMap.put("personNumTrend",familyPercent.compareTo(new BigDecimal(0))==1 ? true : false);
		   }else{
			   resultMap.put("personComparison","100%");
			   resultMap.put("personNumTrend",true);
		   }
		   resultMap.put("personSize", currentMonthPerson);
	}
	
	//计算家庭-某月的市场规模数据
	private Integer computerHouseInventory(String month){
		Criteria criteria =new Criteria();
		criteria.and("month").is(month);//月份
		criteria.and("region").ne("全国");//除全国外的五大区
		AggregationOperation matchOperation = Aggregation.match(criteria);
		//排序操作
//        AggregationOperation sortOperation = Aggregation.sort(Sort.Direction.DESC,"month");
        //例如先排序后取条数，和先去条数后排序是完全不一样的意思
        Aggregation aggregation = Aggregation.newAggregation(matchOperation);
        
        AggregationResults<HouseMarketActivationDto> aggregationResults =mongoTemplate.aggregate(aggregation, HouseMarketActivationDto.class, HouseMarketActivationDto.class);;
        List<HouseMarketActivationDto> dtoHouseList=aggregationResults.getMappedResults();
        Integer sumInventory=0;
        if(dtoHouseList!=null && !dtoHouseList.isEmpty()){
        	for (HouseMarketActivationDto dto : dtoHouseList) {//family_inventory:10383
        		sumInventory+=dto.getFamilyInventory();
			}
        }
        
        return sumInventory;
	}
	
		//计算个人-某月的市场规模数据
		private Integer computerPersonInventory(String month){
			Criteria criteria =new Criteria();
			criteria.and("month").is(month);//月份
			criteria.and("region").ne("全国");//除全国外的五大区
			AggregationOperation matchOperation = Aggregation.match(criteria);
			//排序操作
//	        AggregationOperation sortOperation = Aggregation.sort(Sort.Direction.DESC,"month");
	        //例如先排序后取条数，和先去条数后排序是完全不一样的意思
	        Aggregation aggregation = Aggregation.newAggregation(matchOperation);
	        
	        AggregationResults<IndividualMarketActivationDto> aggregationResults =mongoTemplate.aggregate(aggregation, IndividualMarketActivationDto.class, IndividualMarketActivationDto.class);;
	        List<IndividualMarketActivationDto> dtoHouseList=aggregationResults.getMappedResults();
	        Integer sumInventory=0;
	        if(dtoHouseList!=null && !dtoHouseList.isEmpty()){
	        	for (IndividualMarketActivationDto dto : dtoHouseList) {
	        		sumInventory+=dto.getPersonInventory();
				}
	        }
	        
	        return sumInventory;
		}
		
		
		/**
		 * 
		 * 功能描述： 下载数据
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
		@GetMapping("/v2_1/market/front/down")
		@ResponseBody
		public Result downMarketDataTemplate(@RequestParam(name="modelType",value="modelType",required=false,defaultValue="0") int modelType,
				@RequestParam(name="month",value="month",required=true) String month,
				@RequestParam(name="taskName",value="taskName",required=true) String taskName,
				@RequestParam(name="userName",value="userName",required=true) String userName
				) throws IOException {
			
			//保存文件
			salesfiguresService.saveFileToMongo(taskName, userName, modelType,month);
			
			return Result.valueOf(Result.SUCCESS,"下载任务添加完成，请到下载中心进行查看！");
		}
		
		@GetMapping("/v2_1/market/front/export/excel")
		public void exportDownMarketDataTemplate(@RequestParam(name="modelType",value="modelType",required=false,defaultValue="0") int modelType,
				@RequestParam(name="month",value="month",required=true) String month,
				@RequestParam(name="taskName",value="taskName",required=true) String taskName,
				HttpServletResponse respone) throws IOException {
	        
			if (modelType == 0) {
				exportSalesfiguresData(respone, month,taskName);
			} else if (modelType == 1) {
				exportActiveVendorData(respone, month,taskName);
			} else if (modelType == 2) {
				exportHouseAndPersonData(respone, month,taskName);
			}
			
		}
		
		public List<SalesfiguresDto> dataForSales(String month) {
			
			Criteria criteria =new Criteria();
			criteria.and("month").is(month);//月份
			 //条件筛选操作
	        AggregationOperation matchOperation = Aggregation.match(criteria);
	        
			List<SalesfiguresDto> resultStrList = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), SalesfiguresDto.class, SalesfiguresDto.class).getMappedResults();//总记录数

			return resultStrList;
		}

		public List<ActiveVendorEntity> dataForActive(String month) {
			
			Criteria criteria =new Criteria();
			criteria.and("month").is(month);//月份
			 //条件筛选操作
	        AggregationOperation matchOperation = Aggregation.match(criteria);
	        
			List<ActiveVendorDataDto> resultStrList = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), ActiveVendorDataDto.class, ActiveVendorDataDto.class).getMappedResults();//总记录数
			
			DecimalFormat df = new DecimalFormat("#.00");
			List<ActiveVendorEntity> entityList=new ArrayList<>();
			for (ActiveVendorDataDto dtoTemp : resultStrList) {
				ActiveVendorEntity entity=new ActiveVendorEntity();
				entity.setId(dtoTemp.getId());
				entity.setType(dtoTemp.getType());
				entity.setProvince(dtoTemp.getProvince());
				entity.setMonth(dtoTemp.getMonth());
				
				entity.setMonthlyBootScale(dtoTemp.getMonthlyBootScale().intValue());//月开机规模
//				logger.info("临时对象：{}",dtoTemp.toString());
				if(dtoTemp.getMonthlyBootRate().indexOf("%")!=-1){
					entity.setMonthlyBootRate(dtoTemp.getMonthlyBootRate());//月开机率
				}else{
					String monthBootRate=new BigDecimal(dtoTemp.getMonthlyBootRate()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()+"%";
					entity.setMonthlyBootRate(monthBootRate);//月开机率
				}
				
				
				entity.setDailyBootScale(dtoTemp.getDailyBootScale().intValue());//日开机规模
				if(dtoTemp.getDailyBootRate().indexOf("%")!=-1){//找到百分号
					entity.setDailyBootRate(dtoTemp.getDailyBootRate());//日开机率
				}else{
					String dailiyBootRate=new BigDecimal(dtoTemp.getDailyBootRate()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()+"%";
					entity.setDailyBootRate(dailiyBootRate);//日开机率
				}
				
				entity.setDailyBootTime(String.valueOf(df.format(dtoTemp.getDailyBootTime())));//日均开机时长-整形
				entity.setDailyBootFrequency(String.valueOf(df.format(dtoTemp.getDailyBootFrequency())));//日均开机频次-整形
				
				entityList.add(entity);
			}

			return entityList;
			
		}

		public List<HouseMarketActivationDto> dataForHouse(String month) {
			Criteria criteria =new Criteria();
			criteria.and("month").is(month);//月份
			 //条件筛选操作
	        AggregationOperation matchOperation = Aggregation.match(criteria);
	        
			List<HouseMarketActivationDto> resultStrList = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), HouseMarketActivationDto.class, HouseMarketActivationDto.class).getMappedResults();//总记录数

			return resultStrList;
		}

		public List<IndividualMarketActivationDto> dataForIndiviual(String month) {
			Criteria criteria =new Criteria();
			criteria.and("month").is(month);//月份
			 //条件筛选操作
	        AggregationOperation matchOperation = Aggregation.match(criteria);
	        
			List<IndividualMarketActivationDto> resultStrList = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), IndividualMarketActivationDto.class, IndividualMarketActivationDto.class).getMappedResults();//总记录数

			return resultStrList;
		}
		
		
	    public void  exportSalesfiguresData(HttpServletResponse response,String month,String taskName) throws IOException{
	        List<SalesfiguresDto> userList =  dataForSales(month); // 获取用户数据
	        Map<String, String> fieldMap = new LinkedHashMap<String, String>(); // 数据列信息
	    	fieldMap.put("month", "月份");
	     	fieldMap.put("brand", "品牌");
	     	fieldMap.put("brandType", "品牌类型");
	     	fieldMap.put("province", "省份");
	     	fieldMap.put("newSales", "新增销量(台)");
	     	fieldMap.put("cumulativeSales", "累计销量(台)");
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
	        String fileName = URLEncoder.encode(taskName, "UTF-8");
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
	    public void  exportActiveVendorData(HttpServletResponse response,String month,String taskName) throws IOException{
	        List<ActiveVendorEntity> userList =  dataForActive(month); // 获取用户数据
	        Map<String, String> fieldMap = new LinkedHashMap<String, String>(); // 数据列信息
	    	fieldMap.put("month", "月份");
	     	fieldMap.put("type", "品牌类型");
	     	fieldMap.put("province", "省份");
	     	fieldMap.put("monthlyBootScale", "月开机规模(万台)");
	     	
	     	fieldMap.put("monthlyBootRate", "月开机率(%)");
	     	fieldMap.put("dailyBootScale", "日均开机规模(万台)");
	     	fieldMap.put("dailyBootRate", "日均开机率(%)");
	     	fieldMap.put("dailyBootTime", "日均开机时长(分钟)");
	     	fieldMap.put("dailyBootFrequency", "日均开机频次(次)");
	     	
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
	         for (ActiveVendorEntity user: userList){//遍历数据插入excel中
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
	        String fileName = URLEncoder.encode(taskName, "UTF-8");
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

	    
	    public void  exportHouseAndPersonData(HttpServletResponse response,String month,String taskName) throws IOException{
	        List<HouseMarketActivationDto> houseList =  dataForHouse(month); // 获取家庭数据
	        List<IndividualMarketActivationDto> personList =  dataForIndiviual(month); // 获取个人数据
	        
	        Map<String, String> fieldMapHouse = new LinkedHashMap<String, String>(); // 家庭数据列信息
	    	fieldMapHouse.put("month", "月份");
	    	fieldMapHouse.put("province", "省份");
	     	fieldMapHouse.put("region", "区域");
	     	fieldMapHouse.put("city", "城市");
	     	
	     	fieldMapHouse.put("tier", "城市级别");
	     	fieldMapHouse.put("familyLifeStage", "家庭生命周期");
	     	fieldMapHouse.put("familyInventory", "激活量(户)");
	     	
	     	Map<String, String> fieldMapPerson = new LinkedHashMap<String, String>(); // 个人数据列信息
	     	fieldMapPerson.put("month", "月份");
	     	fieldMapPerson.put("province", "省份");
	     	fieldMapPerson.put("region", "区域");
	     	fieldMapPerson.put("city", "城市");
	     	
	     	fieldMapPerson.put("tier", "城市级别");
	     	fieldMapPerson.put("gender", "性别");
	     	fieldMapPerson.put("age", "年龄");
	     	fieldMapPerson.put("personInventory", "激活量(人)");
	     	
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
		         
	        String fileName = URLEncoder.encode(taskName, "UTF-8");
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
