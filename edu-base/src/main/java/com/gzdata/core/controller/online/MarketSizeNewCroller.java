package com.gzdata.core.controller.online;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gzdata.common.exception.GenericException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation.GroupOperationBuilder;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.gzdata.common.util.ChineseFirstLetterUtil;
import com.gzdata.common.util.DateUtil;
import com.gzdata.common.util.SpellComparator;
import com.gzdata.core.dto.ActiveVendorDataDto;
import com.gzdata.core.dto.HouseMarketActivationDto;
import com.gzdata.core.dto.IndividualMarketActivationDto;
import com.gzdata.core.dto.ManufacturersActiveDto;
import com.gzdata.core.dto.ManufacturersSalesDto;
import com.gzdata.core.dto.ModelControllerDto;
import com.gzdata.core.dto.Quarter;
import com.gzdata.core.dto.SalesTempDto;
import com.gzdata.core.dto.SalesfiguresDto;
import com.gzdata.core.model.ActiveVendorEntity;
import com.gzdata.core.service.SalesfiguresService;

/**
 * 市场规模-前台模块
 */
@CrossOrigin
@Api(description="新版",tags="新版-市场规模")
@RestController
@RequestMapping("/api/anon/")
public class MarketSizeNewCroller {
	private static final Logger logger = LoggerFactory.getLogger(MarketSizeNewCroller.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private SalesfiguresService salesfiguresService;
	   
	/**
     * 
     * 功能描述：导入数据-mongodb
     *
     * @param file 选中文件
     * @param modelType 0.销量数据 1.活跃数据
     * @return
     * @throws IOException
     * 
     * @author 张兵帅
     *
     * @since 2020年11月19日
     *
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
	@ApiOperation("导入数据-mongodb")
    @PostMapping("/v2_1/local/market/data/import")
	@ResponseBody
	public Result uploadMarketDataTemplate(@ApiParam("导入的文件") MultipartFile file,
			@ApiParam(name="modelType",value="对象类型",required=true) @RequestParam(name="modelType",value="modelType",required=true) int modelType)
					throws IOException {
		
		salesfiguresService.importDataLocal(file,modelType);
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}
    /**
     * 
     * 功能描述：得到初始化查询条件
     *
     * @param modelType
     * @return
     * @throws IOException
     * 
     * @author 张兵帅
     *
     * @since 2020年11月19日
     *
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
	@ApiOperation("得到初始化查询条件")
    @SuppressWarnings("unchecked")
	@GetMapping("/v2_1/init/query/condition")
	@ResponseBody
	public Result getInitQueryCondition() {
    	Map<String, Object> resultMap=new HashMap<String, Object>();
    	
    	//1.省份、品牌类型、品牌 区域、城市级别、城市、
		Query query = new Query();
        
		//地域
		List<String> regionList=mongoTemplate.findDistinct(query, "province", "manufacturers_sales", String.class);
		Collections.sort(regionList, new SpellComparator());
		
		//组装首字母数据
		List<String> firstList=new ArrayList<>();
		List<String> twoList=new ArrayList<>();
		List<String> threeList=new ArrayList<>();
		List<String> fourList=new ArrayList<>();
		
		regionList.remove("全国");
		
    	for (String string : regionList) {
    		int index=Arrays.asList(ChineseFirstLetterUtil.lc_FirstLetter).indexOf(ChineseFirstLetterUtil.getFirstLetter(string));
        	
        	if( index >=0 && index <=6){
        		firstList.add(string);
        	}else if( index >=7 && index <=12){
        		twoList.add(string);
        	}else if( index >=13 && index <=18){
        		threeList.add(string);
        	}else if( index >=19 && index <=22){
        		fourList.add(string);
        	}
        	
		}
    	
    	Map<String,List<String>> MAP_ORDER_T = new LinkedHashMap<String, List<String>>(){
    		{
    			put("A-G", firstList);//索引0~6
    			put("H-N", twoList);//索引7~12
    			put("O-U", threeList);//索引13~18
    			put("V-Z", fourList);//索引19~22
    			
    		}};
    		
		resultMap.put("regionList", MAP_ORDER_T);
		
		//品牌类型-list
		List<String> brandTypeList=mongoTemplate.findDistinct(query, "type", "manufacturers_sales", String.class);
		logger.info("品牌类型数据：{}",brandTypeList.toString());
		
		resultMap.put("brandTypeList", BRANDTYPE_RELATION_BRAND_MAP);
		
		List<String> monthList=mongoTemplate.findDistinct(query, "month", "manufacturers_sales", String.class);
		logger.info("月份数组：{}",monthList.toString());
		
		Set<Quarter> quarterSet=new HashSet<Quarter>();
		
		for (String dateStr : monthList) {
			String [] yearAndmonthArrays=dateStr.split("-");
			String yearStr=yearAndmonthArrays[0];
			String monthStr=yearAndmonthArrays[1];
			Quarter quarter=null;
			
			if(Integer.parseInt(monthStr) <= 3){
				 quarter=new Quarter(yearStr+"年第一季度",yearStr+"_01",yearStr,"第一季度");
			}if(Integer.parseInt(monthStr) > 3 && Integer.parseInt(monthStr) <= 6){
				 quarter=new Quarter(yearStr+"年第二季度",yearStr+"_02",yearStr,"第二季度");					
			}if(Integer.parseInt(monthStr) >6 && Integer.parseInt(monthStr) <=9 ){
				 quarter=new Quarter(yearStr+"年第三季度",yearStr+"_03",yearStr,"第三季度");
			}if(Integer.parseInt(monthStr) >9 && Integer.parseInt(monthStr) <=12){
				 quarter=new Quarter(yearStr+"年第四季度",yearStr+"_04",yearStr,"第四季度");
			}

			quarterSet.add(quarter);
			
		}
		List<Quarter> quarList=new ArrayList<>();
		Set<String> yearSet=new HashSet<>();
		
		for (Quarter quarter : quarterSet) {
			quarList.add(quarter);
			yearSet.add(quarter.getYear());
		}
		
		quarList.sort(Comparator.comparing(Quarter::getValue).reversed());
		
		List<Map<String, Object>> mapResultList=new ArrayList<>();
		
		for (String currentYear : yearSet) {//遍历年份
			Map<String, Object> tempMap=new HashMap<>();
			tempMap.put("value", currentYear);
			tempMap.put("label", currentYear);
			
			List<Map<String, Object>> mapCentList=new ArrayList<>();
			
			for (Quarter quarter : quarList) {//结果数据
				if(currentYear.equals(quarter.getYear())){
					Map<String, Object> tempMapHandle=new HashMap<>();
					tempMapHandle.put("value", quarter.getValue());
					tempMapHandle.put("label", quarter.getRemark());
					
					mapCentList.add(tempMapHandle);
				}
			}
			tempMap.put("children", mapCentList);
			
			mapResultList.add(tempMap);
		}
		
		resultMap.put("chooseDateList", mapResultList);
		
		return Result.valueOf(Result.SUCCESS, "操作成功",resultMap);
	}
    
    /**
     * 
     * 功能描述：查询-整体数据概览
     *
     * @param regionList 地域数组
     * @param brandTypeList 品牌类型
     * @param quarter 季度 格式：年份—对应季度 例如：2020_01
     * @return
     * 
     * @author 张兵帅
     *
     * @since 2020年11月20日
     *
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
	@ApiOperation("查询-整体数据概览")
    @GetMapping("/v2_1/query/overallDataOverview/data")
	@ResponseBody
	public Result queryOerallDataOverviewInfo(@ApiParam(name="regionList",value="地域数组",required=false) @RequestParam(required=false) List<String> regionList,
			@ApiParam(name="brandTypeList",value="品牌类型数组",required=false) @RequestParam(required=false) List<String> brandTypeList,
			@ApiParam(name="quarter",value="季度",required=false) @RequestParam(required=false) String quarter,
			@ApiParam(name="token",value="token",required=true) @RequestParam String token) {
    	logger.info(token);
    	Criteria criteria =new Criteria();
		//1.是否包含全国
		if(regionList.contains("全国")){//包含
			criteria.and("province").in("全国");//过滤条件
		}else{
			criteria.and("province").in(regionList);//过滤条件
		}

		//2.是否是全部类型
		if(brandTypeList.contains("全部厂商类型")){//包含
			criteria.and("type").in("全部厂商类型");//过滤条件
		}else {
			criteria.and("type").in(brandTypeList);//过滤条件
		}
		
		//全部品牌
		criteria.and("brand").in("全部品牌");//过滤条件
		
		//3.季度对应的月份
		List<String> monthList=getQuarterForMonths(quarter);
		criteria.and("month").in(monthList.get(monthList.size()-1));//过滤条件==当季度最后一个月的数据
		
		//条件筛选操作
        AggregationOperation matchOperation = Aggregation.match(criteria);
        Aggregation aggregation = Aggregation.newAggregation(matchOperation);
        AggregationResults<ManufacturersSalesDto> aggregationResults =null;
		
		aggregationResults = mongoTemplate.aggregate(aggregation, ManufacturersSalesDto.class, ManufacturersSalesDto.class);
		
		//累计销量
		Double sumCumDouble=0.00;
		List<ManufacturersSalesDto> cumObjectList=aggregationResults.getMappedResults();
		
		for (ManufacturersSalesDto object : cumObjectList) {
			sumCumDouble+=object.getCumulativeSales();
		}
		
		Map<String, Object> resultMap = getMonthAndDailyAverageArrivalScale(regionList, brandTypeList, quarter);
		resultMap.put("sumCumulativeSales",sumCumDouble);

		int token_code = filterToken(token);
		if(0 ==  token_code){
			return Result.valueOf(Result.SUCCESS, "操作成功",new HashMap<>());
		}
		else if(200 == token_code){
			return Result.valueOf(Result.SUCCESS, "操作成功",resultMap);
		}
		else{
            throw new GenericException("token不存在或过期");
		}

	}
    
    
    /**
     * 
     * 功能描述：查询厂商销量-分页数据
     *
     * @return
     * 
     * @author 张兵帅
     *
     * @since 2020年11月19日
     *
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
	@ApiOperation("查询厂商销量-分页数据")
	@GetMapping("/v2_1/query/sales/data")
	@ResponseBody
	public Result getManufacturersSalesPageList(
		@ApiParam(name="page",value="页码") @RequestParam(name="page",value="page",required=false,defaultValue="1") int page,
		@ApiParam(name="pageSize",value="每页条数") @RequestParam(name="pageSize",value="pageSize",required=false,defaultValue="10") int pageSize,
		@ApiParam(name="regionList",value="地域数组") @RequestParam List<String> regionList,//地域数组
		@ApiParam(name="brandTypeList",value="品牌类型数组") @RequestParam List<String> brandTypeList,//品牌类型
		@ApiParam(name="quarter",value="季度") @RequestParam String quarter,//季度 格式：年份_对应季度 例如：2020_01
		@ApiParam(name="sortField",value="排序字段") @RequestParam(name="sortField",value="sortField",required=false,defaultValue="default") String sortField,//排序字段
		@ApiParam(name="orderName",value="排序：1.升序 2.降序") @RequestParam(name="orderName",value="orderName",required=false,defaultValue="1") int orderName,//1.升序 2.降序
		@ApiParam(name="brandList",value="品牌集合")	@RequestParam(name="brandList",required=false) List<String> brandList,
		@ApiParam(name="token",value="token",required=true) @RequestParam String token) {
		
    	Criteria criteria =new Criteria();
    	
		//1.是否包含全国
    	criteria.and("province").in(regionList);//过滤条件
    	
		//2.是否是全部类型
		criteria.and("type").in(brandTypeList);//过滤条件

		if(brandList!=null && !brandList.isEmpty()){
			criteria.and("brand").in(brandList);//过滤条件
		}
		
		//3.季度对应的月份
		criteria.and("month").in(getQuarterForMonths(quarter));//过滤条件
		
		int sumCount=0;//总记录数
		
		 //条件筛选操作
        AggregationOperation matchOperation = Aggregation.match(criteria);
        
        
		//排序操作
        AggregationOperation sortOperation=null;
        
        if(sortField.equals("default")){//默认排序
        	 sortOperation = Aggregation.sort(orderName == 1 ? Sort.Direction.DESC : Sort.Direction.ASC,"cumulativeSales");//排序字段为结果集中的字段，不是对象里的
        }else{
        	sortOperation = Aggregation.sort(orderName == 1 ? Sort.Direction.ASC : Sort.Direction.DESC,sortField);//排序字段为结果集中的字段，不是对象里的
        }
        //跳过条数
        @SuppressWarnings("deprecation")
		AggregationOperation skigOperation = Aggregation.skip((page-1)*pageSize);//跳过的条数：(页码-1)*每页大小
        //选择条数
        AggregationOperation limitOperation =Aggregation.limit(pageSize);//取的记录数
        Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOperation,skigOperation,limitOperation);
		
        AggregationResults<Object> aggregationResults =null;
		
		aggregationResults = mongoTemplate.aggregate(aggregation, ManufacturersSalesDto.class, Object.class);
		sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), ManufacturersSalesDto.class, ManufacturersSalesDto.class).getMappedResults().size();//总记录数

		int token_code = filterToken(token);
		if(0 ==  token_code){
			return Result.valueOf(Result.SUCCESS, "操作成功" , new ArrayList());

		}
		else if(200 == token_code){
			return Result.valueOf(Result.SUCCESS, "操作成功",sumCount,aggregationResults!=null ? aggregationResults.getMappedResults() : new ArrayList());

		}
		else{
			//return Result.valueOf(Result.VALAID, "操作成功",sumCount,aggregationResults!=null ? aggregationResults.getMappedResults() : new ArrayList());
            throw new GenericException("token不存在或过期");
		}


	}
	    
	/**
	 * 
	 * 功能描述：厂商活跃-分页数据
	 *
	 * @param page
	 * @param pageSize
	 * @param filedName
	 * @param filedValue
	 * @param sortField
	 * @param orderName
	 * @param month
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年11月19日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("厂商活跃-分页数据")
	@GetMapping("/v2_1/query/active/data")
	@ResponseBody
	public Result getManufacturersActivePageList(
		@ApiParam(name="page",value="页码")	@RequestParam(name="page",value="page",required=false,defaultValue="1") int page,
		@ApiParam(name="pageSize",value="每页大小")	@RequestParam(name="pageSize",value="pageSize",required=false,defaultValue="10") int pageSize,
		@ApiParam(name="regionList",value="地域数组")	@RequestParam List<String> regionList,//地域数组
		@ApiParam(name="brandTypeList",value="品牌类型数组")	@RequestParam List<String> brandTypeList,//品牌类型
		@ApiParam(name="quarter",value="季度")	@RequestParam String quarter,//季度 格式：年份_对应季度 例如：2020_01
		@ApiParam(name="sortField",value="排序字段")	@RequestParam(name="sortField",value="sortField",required=false,defaultValue="default") String sortField,//排序字段
		@ApiParam(name="orderName",value="排序字段：1.升序 2.降序")	@RequestParam(name="orderName",value="orderName",required=false,defaultValue="1") int orderName,
		@ApiParam(name="monthStr",value="月份")	@RequestParam List<String> monthStr,
		@ApiParam(name="token",value="token",required=true) @RequestParam String token) {//1.升序 2.降序
		
    	Criteria criteria =new Criteria();
    	
		//1.是否包含全国
    	criteria.and("province").in(regionList);//过滤条件
    	
		//2.是否是全部类型
		criteria.and("type").in(brandTypeList);
		
		//3.季度对应的月份
		if(monthStr!=null && !monthStr.isEmpty()){//月份集合非空
			criteria.and("month").in(monthStr);//过滤条件
		}else{
			criteria.and("month").in(getQuarterForMonths(quarter));//过滤条件
		}
		
		int sumCount=0;//总记录数
		
		 //条件筛选操作
        AggregationOperation matchOperation = Aggregation.match(criteria);
		
		//排序操作
        AggregationOperation sortOperation = null;
        if(sortField.equals("default")){
        	sortOperation = Aggregation.sort(orderName == 1 ? Sort.Direction.ASC : Sort.Direction.DESC,"month").and(Sort.Direction.DESC, "monthlyBootScale");
        }else{
        	sortOperation = Aggregation.sort(orderName == 1 ? Sort.Direction.ASC : Sort.Direction.DESC,sortField);
        }
        //跳过条数
        @SuppressWarnings("deprecation")
		AggregationOperation skigOperation = Aggregation.skip((page-1)*pageSize);//跳过的条数：(页码-1)*每页大小
        //选择条数
        AggregationOperation limitOperation =Aggregation.limit(pageSize);//取的记录数
        Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOperation,skigOperation,limitOperation);
		
        AggregationResults<Object> aggregationResults =null;
		
		aggregationResults = mongoTemplate.aggregate(aggregation, ManufacturersActiveDto.class, Object.class);
		sumCount = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), ManufacturersActiveDto.class, Object.class).getMappedResults().size();//总记录数

		int token_code = filterToken(token);
		if(0 ==  token_code){
			return Result.valueOf(Result.SUCCESS, "操作成功" , new ArrayList());

		}
		else if(200 == token_code){
			return Result.valueOf(Result.SUCCESS, "操作成功",sumCount,aggregationResults!=null ? aggregationResults.getMappedResults() : new ArrayList());

		}
		else{
            throw new GenericException("token不存在或过期");
		}

	}
	
	/**
	 * 
	 * 功能描述：下载文件
	 *
	 * @param response
	 * @param modelType
	 * @param regionList 地域数组
	 * @param brandTypeList 品牌类型
	 * @param quarter 季度 格式：年份_对应季度 例如：2020_01
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年11月25日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("导出季度数据")
	@GetMapping("/v2_1/export/quarter/data")
	public void exportQuarterData(HttpServletResponse response,
			@ApiParam(name="regionList",value="地域集合")	@RequestParam String regionList,
			@ApiParam(name="brandTypeList",value="品牌类型集合") @RequestParam String brandTypeList,
			@ApiParam(name="quarter",value="季度") @RequestParam String quarter,
			@ApiParam(name="taskName",value="任务名称") @RequestParam String taskName,
			@ApiParam(name="token",value="token",required=true) @RequestParam String token) throws IOException {

		int token_code = filterToken(token);

		if(200 == token_code){
			exportAllData(response,Arrays.asList(regionList.split(",")),Arrays.asList(brandTypeList.split(",")),quarter,taskName);
		}

	}
	
	//添加下载记录-走下载中心
	@ApiOperation("添加下载记录")
	@GetMapping("/v2_1/market/export/quarter/down/recard")
	@ResponseBody
	public Result downMarketDataInfo(HttpServletResponse response,
			@ApiParam(name="regionList",value="地域集合")	@RequestParam String regionList,
			@ApiParam(name="brandTypeList",value="品牌类型集合") @RequestParam String brandTypeList,
			@ApiParam(name="quarter",value="季度") @RequestParam String quarter,
			@ApiParam(name="taskName",value="任务名称") @RequestParam String taskName,
			@ApiParam(name="userName",value="用户") @RequestParam String userName,
			@ApiParam(name="token",value="token",required=true) @RequestParam String token) throws IOException {

		int token_code = filterToken(token);
		if(0 ==  token_code){
			return null;
		}
		else if(200 == token_code){
			//保存文件
			salesfiguresService.addDownRecord(taskName, userName, regionList,brandTypeList,quarter);

			return Result.valueOf(Result.SUCCESS,"下载任务添加完成，请到下载中心进行查看！");
		}
		else{

            throw new GenericException("token不存在或过期");
		}

	}
	
	/**
	 * 
	 * 功能描述：获取季度对应的所有月份
	 *
	 * @param quarter
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年11月21日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	private List<String> getQuarterForMonths(String quarter){
		Map<String, String []> resultMap=new HashMap<>();
		resultMap.put("01",new String [] {"01","02","03"});//第一季度
		resultMap.put("02",new String [] {"04","05","06"});//第二季度
		resultMap.put("03",new String [] {"07","08","09"});//第三季度
		resultMap.put("04",new String [] {"10","11","12"});//第四季度
		
		String quarterKey=quarter.split("_")[1];
		List<String> monthList=new ArrayList<String>();
		
		for (String month : resultMap.get(quarterKey)) {//季度对应的所有月份
			logger.info("月份：{}",quarter.split("_")[0]+month);
			
			monthList.add(quarter.split("_")[0]+"-"+month);
		}
		
		return monthList;
	}
	/**
	 * 
	 * 功能描述：得到日均和月均到达规模、到达率
	 *
	 * @param regionList 地域数组
	 * @param brandTypeList 品牌类型
	 * @param quarter
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年11月21日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	private Map<String, Object> getMonthAndDailyAverageArrivalScale(List<String> regionList,List<String> brandTypeList,String quarter){
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		
		Criteria criteria =new Criteria();
		//1.是否包含全国
		if(regionList.contains("全国")){//包含
			criteria.and("province").in("全国");//过滤条件
		}else{
			criteria.and("province").in(regionList);//过滤条件
		}

		//2.是否是全部类型
		if(brandTypeList.contains("全部厂商类型")){//包含
			 criteria.and("type").in("全部厂商类型");//过滤条件
		}else {
			criteria.and("type").in(brandTypeList);//过滤条件
		}
		
		//3.季度对应的月份
		criteria.and("month").in(getQuarterForMonths(quarter));//过滤条件==当季度三个月的数据
		
		//条件筛选操作
        AggregationOperation matchOperation = Aggregation.match(criteria);
        GroupOperation groupOperation = Aggregation.group("month","province","type")
        		.sum("monthlyBootScale").as("monthlyBootScaleSum")
        .sum("dailyBootScale").as("dailyBootScaleSum")
	        .sum("activation").as("activationScaleSum");//激活量
        
        Aggregation aggregation = Aggregation.newAggregation(matchOperation,groupOperation);
        
        AggregationResults<Object> aggregationResults =null;
		aggregationResults = mongoTemplate.aggregate(aggregation, ManufacturersActiveDto.class, Object.class);

		Double sumMonthDouble=0.00;
		Double sumDailyDouble=0.00;
		Double sumActiveDouble=0.00;//激活总数
		List<Object> cumObjectList=aggregationResults.getMappedResults();
		
		for (Object object : cumObjectList) {
			Map<String, Object> tempMap=(Map<String, Object>)object;
			sumMonthDouble+=Double.parseDouble(String.valueOf(tempMap.get("monthlyBootScaleSum")));
			sumDailyDouble+=Double.parseDouble(String.valueOf(tempMap.get("dailyBootScaleSum")));
			sumActiveDouble+=Double.parseDouble(String.valueOf(tempMap.get("activationScaleSum")));
		}
		
		resultMap.put("monthAvgArrivalScale", new BigDecimal(sumMonthDouble/3).setScale(2, RoundingMode.UP));//月均到达规模
		resultMap.put("dailyAvgArrivalScale", new BigDecimal(sumDailyDouble/3).setScale(2, RoundingMode.UP));//日均到达规模
		logger.info("sumMonthDouble:{}",sumMonthDouble);
		logger.info("sumActiveDouble:{}",sumActiveDouble);
		
		resultMap.put("monthAvgArrivalRate", new BigDecimal(sumMonthDouble/sumActiveDouble).setScale(4, RoundingMode.HALF_UP));//月均到达率
		resultMap.put("dailyAvgArrivelRate", new BigDecimal(sumDailyDouble/sumActiveDouble).setScale(4, RoundingMode.HALF_UP));//日均到达率
		
		logger.info("结果：{}",resultMap.toString());
		
		return resultMap;
	}

	//验证token
	private int filterToken(String request_token){

		if (request_token != null) {

			//令牌没有过期，能解密出来
			//eyJUeXBlIjoiSnd0IiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJwYXNzd29yZCI6InR6eTEyMzQ1Iiwicm9sZV9pZCI6IjEiLCJleHAiOjE2MDY4OTY4MTMsInVzZXJuYW1lIjoidGlhbnpoaXl1In0.CpaaJhh5U9tE_49B29Va-SsS64_1F3SqI8xVbJckRzg
			Algorithm algorithm = Algorithm.HMAC256("privateKey");
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(request_token);


			String role_id = jwt.getClaim("role_id").asString();

			if(null == role_id){
				return 401;
			}
			else if("1".equals(role_id)){
				return 200;
			}


		}
		//无权限
		return 0;
	}


	 public void  exportAllData(HttpServletResponse response,List<String> regionList, List<String> brandTypeList, String quarter,String taskName) throws IOException{
		 	Map<String,Object> mapObject =  dataForOverView(regionList, brandTypeList, quarter); // 概览数据
	        List<ManufacturersSalesDto> salesList =  dataForSales(regionList, brandTypeList, quarter); //销量数据
	        List<ManufacturersActiveDto> activeList =  dataForActive(regionList, brandTypeList, quarter); //活跃数据

	        //excel row header for overView
	        Map<String, String> overViewMap = new LinkedHashMap<String, String>(); // 概览数据列信息
	     	overViewMap.put("sumCumulativeSales", "累计销量");
	     	overViewMap.put("monthAvgArrivalScale", "月均到达规模");
	     	overViewMap.put("monthAvgArrivalRate", "月均到达率");
	     	
	     	overViewMap.put("dailyAvgArrivalScale", "日均到达规模");
	     	overViewMap.put("dailyAvgArrivelRate", "日均到达率");
	     	
	     	//excel row header sales
	     	Map<String, String> salesMap = new LinkedHashMap<String, String>(); // 销量数据列信息
	     	salesMap.put("province", "地域");//地域
	     	salesMap.put("type", "品牌类型");//品牌类型
	     	salesMap.put("brand", "品牌");//品牌
	     	salesMap.put("newSalesSum", "累计销量");//累计销量
	     	salesMap.put("cumulativeSalesSum", "新增销量");//新增销量

	     	//excel row header active
	     	Map<String, String> activeMap = new LinkedHashMap<String, String>(); // 活跃数据列信息
	     	activeMap.put("month", "日期");//日期
	     	activeMap.put("province", "地域");//地域
	     	activeMap.put("type", "品牌类型");//品牌类型
	     	activeMap.put("monthlyBootScale", "月均开机规模");//月均开机规模
	     	
	     	activeMap.put("monthlyBootRate", "月均开机率");//月均开机率
	     	activeMap.put("dailyBootScale", "日均开机规模");//日均开机规模
	     	activeMap.put("dailyBootRate", "日均开机率");//日均开机率
	     	
	        XSSFWorkbook workbook = new XSSFWorkbook(); // 新建工作簿对象
	        XSSFSheet overViewSheet = workbook.createSheet("概览数据");// 创建sheet
	        XSSFSheet salesSheet = workbook.createSheet("销量数据");// 创建sheet
	        XSSFSheet activeSheet = workbook.createSheet("活跃数据");// 创建sheet
	        
	        //-----------------------数据概览 ----------begin------
	        Row rowZero =  overViewSheet.createRow(0);// 创建第一行对象,设置表标题
	        rowZero.createCell(0).setCellValue("【数据来源： 勾正OTT Ratings System (ORS)】");

	        Row rowThree =  overViewSheet.createRow(2);// 创建第一行对象,设置表标题
	        rowThree.createCell(0).setCellValue("【查询条件】");
	        
	        Row rowFour =  overViewSheet.createRow(3);// 创建第一行对象,设置地域
	        rowFour.createCell(0).setCellValue("地域");
	        int cellNumFour = 1;
	        Cell cellFour;
	        for (String region:regionList){
	        	cellFour = rowFour.createCell(cellNumFour);
	        	cellFour.setCellValue(region);
	        	cellNumFour++;
	        }
	        
	        Row rowFive =  overViewSheet.createRow(4);// 创建第一行对象,设置地域
	        rowFive.createCell(0).setCellValue("品牌类型");
	        int cellNumFive = 1;
	        Cell cellFive;
	        for (String region:brandTypeList){
	        	cellFive = rowFive.createCell(cellNumFive);
	        	cellFive.setCellValue(region);
	        	cellNumFive++;
	        }

	        
	        Row rowSix =  overViewSheet.createRow(5);// 创建第5行对象,设置季度标题
	        rowSix.createCell(0).setCellValue("季度");
	        String textJoinStr="";
	        if(quarter.split("_")[1].equals("01")){
	        	textJoinStr=quarter.split("_")[0]+"年第一季度";
	        }else if(quarter.split("_")[1].equals("02")){
	        	textJoinStr=quarter.split("_")[0]+"年第二季度";
	        }else if(quarter.split("_")[1].equals("03")){
	        	textJoinStr=quarter.split("_")[0]+"年第三季度";
	        }else if(quarter.split("_")[1].equals("04")){
	        	textJoinStr=quarter.split("_")[0]+"年第四季度";
	        }
	        rowSix.createCell(1).setCellValue(textJoinStr);
	        
	        Row rowEight =  overViewSheet.createRow(7);// 创建第一行对象,设置表标题
	        rowEight.createCell(0).setCellValue("【下载数据】");
	        
	        int rowNumOverView = 8;
	        Row row =  overViewSheet.createRow(rowNumOverView);// 创建第7行对象,设置表标题
	        Cell cell;
	        int cellNum = 0;
	        for (String name:overViewMap.values()){
	            cell = row.createCell(cellNum);
	            cell.setCellValue(name);
	            cellNum++;
	        }
	        
	        int rows = 9;
	        row = overViewSheet.createRow(rows);
            int col = 0;
            
            BigDecimal sumCumulativeSalesBig=new BigDecimal(String.valueOf(mapObject.get("sumCumulativeSales")));
            row.createCell(col).setCellValue(sumCumulativeSalesBig.doubleValue()); // 累计销量
            
            BigDecimal mongthAvgArriveRateBig=new BigDecimal(String.valueOf(mapObject.get("monthAvgArrivalScale")));
            row.createCell(col+1).setCellValue(mongthAvgArriveRateBig.doubleValue()); //月均到达规模
            
            BigDecimal monthAvgArrivalRateBig=new BigDecimal(String.valueOf(mapObject.get("monthAvgArrivalRate")));
            row.createCell(col+2).setCellValue(monthAvgArrivalRateBig.doubleValue()); // 月均到达率
            
            BigDecimal dailyAvgArrivalScaleBig =new BigDecimal(String.valueOf(mapObject.get("dailyAvgArrivalScale")));
            row.createCell(col+3).setCellValue(dailyAvgArrivalScaleBig.doubleValue()); // 月均到达规模

            BigDecimal dailyAvgArrivelRateBig=new BigDecimal(String.valueOf(mapObject.get("dailyAvgArrivelRate")));
            row.createCell(col+4).setCellValue(dailyAvgArrivelRateBig.doubleValue()); // 日均到达规模
            
	        //-----------------------数据概览 ----------end------
	         
	         
	         
	         //以下为新的sheet页-------销量---------begin
	         int rowNumSales = 0;
	         Row rowSales =  salesSheet.createRow(rowNumSales);// 创建第一行对象,设置表标题
		     Cell cellPerson;
	         int cellNumPerson = 0;
	         
	        for (String name:salesMap.values()){
	        	cellPerson = rowSales.createCell(cellNumPerson);
	        	cellPerson.setCellValue(name);
	        	cellNumPerson++;
	        }
	        int rowsPerson = 1;
	         for (ManufacturersSalesDto user: salesList){//遍历数据插入excel中
	        	 rowSales = salesSheet.createRow(rowsPerson);
	            int colSale = 0;
	            
	            rowSales.createCell(colSale).setCellValue(user.getProvince()); // 地域
	            rowSales.createCell(colSale+1).setCellValue(user.getType()); // 品牌类型
	            rowSales.createCell(colSale+2).setCellValue(user.getBrand()); // 品牌
	            rowSales.createCell(colSale+3).setCellValue(user.getCumulativeSales()); //累计销量
	            rowSales.createCell(colSale+4).setCellValue(user.getNewSales()); //新增销量
	            rowsPerson++;
	        }
	         
	         //以下为新的sheet页----销量------------end
		        
	         
	         
	         //以下为新的sheet页-------活跃---------begin
	         int rowNumActive = 0;
	         Row rowActive =  activeSheet.createRow(rowNumActive);// 创建第一行对象,设置表标题
		     Cell cellActive;
	         int cellNumActive = 0;
	         
	        for (String name:activeMap.values()){
	        	cellActive = rowActive.createCell(cellNumActive);
	        	cellActive.setCellValue(name);
	        	cellNumActive++;
	        }
	        int rowsActive = 1;
	         for (ManufacturersActiveDto user: activeList){//遍历数据插入excel中
	        	 rowActive = activeSheet.createRow(rowsActive);
	            int colActive = 0;
	            
	            rowActive.createCell(colActive).setCellValue(user.getMonth()); // month
	            rowActive.createCell(colActive+1).setCellValue(user.getProvince()); // 品牌
	            rowActive.createCell(colActive+2).setCellValue(user.getType()); // 品牌类型
	            rowActive.createCell(colActive+3).setCellValue(user.getMonthlyBootScale()); // 省份
	            rowActive.createCell(colActive+4).setCellValue(user.getMonthlyBootRate()); //
	            rowActive.createCell(colActive+5).setCellValue(user.getDailyBootScale()); //
	            rowActive.createCell(colActive+6).setCellValue(user.getDailyBootRate()); //
	            rowsActive++;
	        }
	         
	         //以下为新的sheet页----活跃------------end
		        
	        String fileName = URLEncoder.encode(taskName + DateUtil.getDate(), "UTF-8");
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
		
	 
	 private Map<String, Object> dataForOverView(List<String> regionList,List<String> brandTypeList,String quarter){
		 
		 Criteria criteria =new Criteria();
			//1.是否包含全国
			if(regionList.contains("全国")){//包含
				criteria.and("province").in("全国");//过滤条件
			}else{
				criteria.and("province").in(regionList);//过滤条件
			}

			//2.是否是全部类型
			if(brandTypeList.contains("全部厂商类型")){//包含
				criteria.and("type").in("全部厂商类型");//过滤条件
			}else {
				criteria.and("type").in(brandTypeList);//过滤条件
			}
			
			//3.季度对应的月份
			List<String> monthList=getQuarterForMonths(quarter);
			criteria.and("month").in(monthList.get(monthList.size()-1));//过滤条件==当季度最后一个月的数据
			
			//条件筛选操作
	        AggregationOperation matchOperation = Aggregation.match(criteria);
	        GroupOperation groupOperation = Aggregation.group("province","type")
	        		.sum("cumulativeSales").as("cumulativeSalesSum");
	        
	        Aggregation aggregation = Aggregation.newAggregation(matchOperation,groupOperation);
	        AggregationResults<Object> aggregationResults =null;
			
			aggregationResults = mongoTemplate.aggregate(aggregation, ManufacturersSalesDto.class, Object.class);
			
			//累计销量
			Double sumCumDouble=0.00;
			List<Object> cumObjectList=aggregationResults.getMappedResults();
			for (Object object : cumObjectList) {
				Map<String, Object> tempMap=(Map<String, Object>)object;
				sumCumDouble+=Double.parseDouble(String.valueOf(tempMap.get("cumulativeSalesSum")));
			}
			
			Map<String, Object> resultMap = getMonthAndDailyAverageArrivalScale(regionList, brandTypeList, quarter);
			resultMap.put("sumCumulativeSales", sumCumDouble);//累计销量
			
			return resultMap;
	 }
	 
	 private List<ManufacturersSalesDto> dataForSales(List<String> regionList,List<String> brandTypeList,String quarter){
		 
		 Criteria criteria =new Criteria();
	    	
			//1.是否包含全国
			criteria.and("province").in(regionList);//过滤条件

			//2.是否是全部类型
			criteria.and("type").in(brandTypeList);//过滤条件
			
			//3.季度对应的月份
			criteria.and("month").in(getQuarterForMonths(quarter));//过滤条件
			
			 //条件筛选操作
	        AggregationOperation matchOperation = Aggregation.match(criteria);
	        
	        
			//排序操作
	        AggregationOperation sortOperation=null;
	        
	        sortOperation = Aggregation.sort(Sort.Direction.DESC,"cumulativeSales");//排序字段为结果集中的字段，不是对象里的
	        
	        Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOperation);
			
	        AggregationResults<ManufacturersSalesDto> aggregationResults =null;
			
			aggregationResults = mongoTemplate.aggregate(aggregation, ManufacturersSalesDto.class, ManufacturersSalesDto.class);
	    	
			return (aggregationResults!=null ? aggregationResults.getMappedResults() : new ArrayList());
	 }
	 
	 
	 private List<ManufacturersActiveDto> dataForActive(List<String> regionList,List<String> brandTypeList,String quarter){
		 
		 Criteria criteria =new Criteria();
	    	
			//1.是否包含全国
			criteria.and("province").in(regionList);//过滤条件

			//2.是否是全部类型
			criteria.and("type").in(brandTypeList);//过滤条件
			
			//3.季度对应的月份
			criteria.and("month").in(getQuarterForMonths(quarter));//过滤条件
			
			 //条件筛选操作
	        AggregationOperation matchOperation = Aggregation.match(criteria);
			
			//排序操作
	        AggregationOperation sortOperation = null;
	        sortOperation = Aggregation.sort(Sort.Direction.ASC,"month").and(Sort.Direction.DESC, "monthlyBootScale");
	      
	        Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOperation);
			
	        AggregationResults<ManufacturersActiveDto> aggregationResults =null;
			
			aggregationResults = mongoTemplate.aggregate(aggregation, ManufacturersActiveDto.class, ManufacturersActiveDto.class);
			
			return (aggregationResults!=null ? aggregationResults.getMappedResults() : new ArrayList());
		 
	 }
	 
	 
	 public  final  static Map<String,ArrayList<String>> BRANDTYPE_RELATION_BRAND_MAP = new LinkedHashMap<String, ArrayList<String>>(){
			{
				put("全部厂商类型",new ArrayList<>(Arrays.asList("全部品牌")));
				put("传统5大厂商",new ArrayList<>(Arrays.asList("全部品牌","TCL","创维","海信","康佳","长虹")));
				put("外资品牌",new ArrayList<>(Arrays.asList("全部品牌","东芝","飞利浦","其他","三星","三洋","索尼","夏普")));
				put("互联网电视",new ArrayList<>(Arrays.asList("全部品牌","KKTV","PPTV","暴风","风行","酷开","乐视","微鲸","小米","其他")));
				put("其他品牌",new ArrayList<>(Arrays.asList("全部品牌","海尔","先锋","其他")));
				
			}};
}
