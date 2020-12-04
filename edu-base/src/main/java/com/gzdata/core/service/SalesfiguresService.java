package com.gzdata.core.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.ConverterUtils;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.controller.online.ExcelListener;
import com.gzdata.core.controller.online.ExcelListenerActive;
import com.gzdata.core.controller.online.ExcelListenerHouse;
import com.gzdata.core.controller.online.ExcelListenerIndiviual;
import com.gzdata.core.controller.online.ExcelListenerSales;
import com.gzdata.core.dto.ActiveVendorDataDto;
import com.gzdata.core.dto.HouseMarketActivationDto;
import com.gzdata.core.dto.IndividualMarketActivationDto;
import com.gzdata.core.dto.ManufacturersActiveDto;
import com.gzdata.core.dto.ManufacturersSalesDto;
import com.gzdata.core.dto.Orsv2Download;
import com.gzdata.core.dto.SalesfiguresDto;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * 
 * 说明：处理对的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2020年05月11日
 */
@Service
public class SalesfiguresService {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesfiguresService.class);

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private GridFsTemplate gridFsTemplate;
	@Autowired
	private Environment env;
	
	@Transactional
	public void importData(MultipartFile file, int modelType) {
		try {
			if (modelType == 0) {//销量数据
				 EasyExcel.read(file.getInputStream(),SalesfiguresDto.class,new ExcelListenerSales(){
					 
					 	/**
	                     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	                     */
	                    private static final int BATCH_COUNT = 1000;
	                    
						// 可以通过实例获取该值
						private List<Object> datas = new ArrayList<Object>();
						int tempCount=0;
						public void invoke(Object object, AnalysisContext context) {
							datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
							tempCount+=1;
							
							if(tempCount==1){
								Query query=new Query();
								SalesfiguresDto dto=(SalesfiguresDto)object;
								logger.info("导入数据的月份：{}",dto.getMonth());
								query.addCriteria(Criteria.where("month").is(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT)));
								
								mongoTemplate.remove(query, SalesfiguresDto.class, "salesfigures");
							}
							
							// 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
	                        if (datas.size() >= BATCH_COUNT) {
	                            saveData();
	                            // 存储完成清理 list
	                            datas.clear();
	                        }
						}
						public void doAfterAllAnalysed(AnalysisContext context) {
							logger.info("SalesfiguresDto import data size：{}",datas.size());
							
							for (Object object : datas) {
								SalesfiguresDto dto=(SalesfiguresDto)object;
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								mongoTemplate.insert(dto,"salesfigures");
							}
							 datas.clear();//解析结束销毁不用的资源
						}

						public void saveData(){
							for (Object object : datas) {
								SalesfiguresDto dto=(SalesfiguresDto)object;
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								mongoTemplate.insert(dto,"salesfigures");
							}
						}
						public List<Object> getDatas() {
							return datas;
						}

						public void setDatas(List<Object> datas) {
							this.datas = datas;
						}
				 }).headRowNumber(1).sheet().doRead();
				 
			} else if (modelType == 1) {//厂商活跃数据
				 EasyExcel.read(file.getInputStream(),ActiveVendorDataDto.class,new ExcelListenerActive(){
					 	/**
	                     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	                     */
	                    private static final int BATCH_COUNT = 1000;
	                	int tempCount=0;
					 	// 可以通过实例获取该值
						private List<Object> datas = new ArrayList<Object>();

						public void invoke(Object object, AnalysisContext context) {
							tempCount+=1;
							datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
							
							if(tempCount==1){
								Query query=new Query();
								ActiveVendorDataDto dto=(ActiveVendorDataDto)object;
								query.addCriteria(Criteria.where("month").is(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT)));
								mongoTemplate.remove(query, ActiveVendorDataDto.class, "active_vendor_data");
							}
							
						  if (datas.size() >= BATCH_COUNT) {
	                            saveData();
	                            // 存储完成清理 list
	                            datas.clear();
	                        }
						}
						public void doAfterAllAnalysed(AnalysisContext context) {
							logger.info("active_vendor_data import data size：{}",datas.size());
							
							for (Object object : datas) {
								ActiveVendorDataDto dto=(ActiveVendorDataDto)object;
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								mongoTemplate.insert(dto,"active_vendor_data");
							}
							 datas.clear();//解析结束销毁不用的资源
						}

						public void saveData(){
							for (Object object : datas) {
								ActiveVendorDataDto dto=(ActiveVendorDataDto)object;
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								mongoTemplate.insert(dto,"active_vendor_data");
							}
						}
						public List<Object> getDatas() {
							return datas;
						}

						public void setDatas(List<Object> datas) {
							this.datas = datas;
						}
				 }).headRowNumber(1).sheet().doRead();
				 
			} else if (modelType == 2) {
				
				// 读取部分sheet
		        ExcelReader excelReader = null;
		        try {
		            excelReader = EasyExcel.read(file.getInputStream()).build();

		            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
		            ReadSheet readSheet1 =
		                EasyExcel.readSheet(0).head(HouseMarketActivationDto.class).registerReadListener(new ExcelListenerHouse(){
		                	/**
		                     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
		                     */
		                    private static final int BATCH_COUNT = 1000;
		                    
		                	// 自定义用于暂时存储data。
		                	// 可以通过实例获取该值
		                	private List<Object> datas = new ArrayList<Object>();
		                	int tempCount=0;
		                	
		                	public void invoke(Object object, AnalysisContext context) {
		                		datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
		                		tempCount+=1;
								if(tempCount==1){
									Query query=new Query();
									HouseMarketActivationDto dto=(HouseMarketActivationDto)object;
									query.addCriteria(Criteria.where("month").is(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT)));
									mongoTemplate.remove(query, HouseMarketActivationDto.class, "house_market_activation");
								}
								
		                		// 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
		                        if (datas.size() >= BATCH_COUNT) {
		                            saveData();
		                            // 存储完成清理 list
		                            datas.clear();
		                        }
		                		
		                	}

		                	public void doAfterAllAnalysed(AnalysisContext context) {
		                		logger.info("house_market_activation import data size：{}",datas.size());
		                		
		                		for (Object object : datas) {
		                			HouseMarketActivationDto dto=(HouseMarketActivationDto)object;
		                			dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
		                			mongoTemplate.insert(dto,"house_market_activation");
		                		}
		                		 datas.clear();//解析结束销毁不用的资源
		                	}
		                	
		                	/**
		                     * 加上存储数据库
		                     */
		                    private void saveData() {
		                        logger.info("{}条数据，开始存储数据库！", datas.size());
		                        for (Object object : datas) {
		                			HouseMarketActivationDto dto=(HouseMarketActivationDto)object;
		                			dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
		                			mongoTemplate.insert(dto,"house_market_activation");
		                		}
		                        logger.info("存储数据库成功！");
		                    }
		                    

		                	public List<Object> getDatas() {
		                		return datas;
		                	}

		                	public void setDatas(List<Object> datas) {
		                		this.datas = datas;
		                	}
		                	
		                }).headRowNumber(1).build();
		            ReadSheet readSheet2 =
		                EasyExcel.readSheet(1).head(IndividualMarketActivationDto.class).registerReadListener(new ExcelListenerIndiviual(){
		                	/**
		                     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
		                     */
		                    private static final int BATCH_COUNT = 1000;
		                    int tempCount=0;
		                    // 可以通过实例获取该值
		                	private List<Object> datas = new ArrayList<Object>();

		                	public void invoke(Object object, AnalysisContext context) {
		                		datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
		                		tempCount+=1;
		                		
		                		if(tempCount==1){
									Query query=new Query();
									IndividualMarketActivationDto dto=(IndividualMarketActivationDto)object;
									query.addCriteria(Criteria.where("month").is(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT)));
									mongoTemplate.remove(query, IndividualMarketActivationDto.class, "individual_market_activation");
								}
		                		
		                		// 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
		                        if (datas.size() >= BATCH_COUNT) {
		                            saveData();
		                            // 存储完成清理 list
		                            datas.clear();
		                        }
		                		
		                	}

		                	public void doAfterAllAnalysed(AnalysisContext context) {
		                		logger.info("individual_market_activation import data size：{}",datas.size());
		                		
		                		for (Object object : datas) {
		                			IndividualMarketActivationDto dto=(IndividualMarketActivationDto)object;
		                			dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
		                			mongoTemplate.insert(dto,"individual_market_activation");
		                		}
		                		 datas.clear();//解析结束销毁不用的资源
		                	}
		                	
		                	 /**
		                     * 加上存储数据库
		                     */
		                    private void saveData() {
		                        logger.info("{}条数据，开始存储数据库！", datas.size());
		                        for (Object object : datas) {
		                			IndividualMarketActivationDto dto=(IndividualMarketActivationDto)object;
		                			dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
		                			mongoTemplate.insert(dto,"individual_market_activation");
		                		}
		                        logger.info("存储数据库成功！");
		                    }

		                	public List<Object> getDatas() {
		                		return datas;
		                	}

		                	public void setDatas(List<Object> datas) {
		                		this.datas = datas;
		                	}
		                }).headRowNumber(1).build();
		            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
		            excelReader.read(readSheet1, readSheet2);
		            
		        } finally {
		            if (excelReader != null) {
		                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
		                excelReader.finish();
		            }
		        }
		        
		        
			    
			}
		} catch (Exception e) {
			logger.error("导入数据出现异常：",e);
		}
		
	}
	
	@Transactional
	public void importDataLocal(MultipartFile file, int modelType) {
		try {
			if (modelType == 0) {//销量数据
				 EasyExcel.read(file.getInputStream(),ManufacturersSalesDto.class,new ExcelListenerSales(){
					 
					 	/**
	                     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	                     */
	                    private static final int BATCH_COUNT = 1000;
	                    
						// 可以通过实例获取该值
	                    int tempCount=0;
						private List<Object> datas = new ArrayList<Object>();
						
						public void invoke(Object object, AnalysisContext context) {
							logger.info("内容：{}",(ManufacturersSalesDto)object);
							datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
							
							// 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
	                        if (datas.size() >= BATCH_COUNT) {
	                            saveData();
	                            // 存储完成清理 list
	                            datas.clear();
	                        }
						}
						public void doAfterAllAnalysed(AnalysisContext context) {
							
//							logger.info("厂商销量 import data size：{}",datas.size());
							
							for (Object object : datas) {
								ManufacturersSalesDto dto=(ManufacturersSalesDto)object;
								dto.setBrand(dto.getBrand());
								dto.setType(dto.getType());
								dto.setProvince(dto.getProvince());
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								dto.setNewSales(Double.parseDouble(String.format("%.2f", dto.getNewSales())));
								dto.setCumulativeSales(Double.parseDouble(String.format("%.2f", dto.getCumulativeSales())));
								mongoTemplate.insert(dto,"manufacturers_sales");
								
							}
							 datas.clear();//解析结束销毁不用的资源
						}

						public void saveData(){
							for (Object object : datas) {
								ManufacturersSalesDto dto=(ManufacturersSalesDto)object;
								dto.setBrand(dto.getBrand());
								dto.setType(dto.getType());
								dto.setProvince(dto.getProvince());
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								dto.setNewSales(Double.parseDouble(String.format("%.2f", dto.getNewSales())));
								dto.setCumulativeSales(Double.parseDouble(String.format("%.2f", dto.getCumulativeSales())));
								
								mongoTemplate.insert(dto,"manufacturers_sales");
							}
						}
						public List<Object> getDatas() {
							return datas;
						}

						public void setDatas(List<Object> datas) {
							this.datas = datas;
						}
				 }).headRowNumber(1).sheet().doRead();
				 
			} else if (modelType == 1) {//厂商活跃数据
				 EasyExcel.read(file.getInputStream(),ManufacturersActiveDto.class,new ExcelListenerActive(){
					 	/**
	                     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	                     */
	                    private static final int BATCH_COUNT = 1000;
	                	int tempCount=0;
					 	// 可以通过实例获取该值
						private List<Object> datas = new ArrayList<Object>();

						public void invoke(Object object, AnalysisContext context) {
							datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
							
						  if (datas.size() >= BATCH_COUNT) {
	                            saveData();
	                            // 存储完成清理 list
	                            datas.clear();
	                        }
						}
						public void doAfterAllAnalysed(AnalysisContext context) {
							logger.info("active_vendor_data import data size：{}",datas.size());
							
							for (Object object : datas) {
								
								ManufacturersActiveDto dto=(ManufacturersActiveDto)object;
								logger.info("month:{}",dto.getMonth());
								
								dto.setDailyBootScale(Double.parseDouble(String.format("%.2f", dto.getDailyBootScale())));
								dto.setMonthlyBootScale(Double.parseDouble(String.format("%.2f", dto.getMonthlyBootScale())));
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								dto.setActivation(Double.parseDouble(String.format("%.2f", dto.getActivation())));
								mongoTemplate.insert(dto,"manufacturers_active");
							}
							 datas.clear();//解析结束销毁不用的资源
						}

						public void saveData(){
							for (Object object : datas) {
								ManufacturersActiveDto dto=(ManufacturersActiveDto)object;
								logger.info("month:{}",dto.getMonth());
								
								dto.setDailyBootScale(Double.parseDouble(String.format("%.2f", dto.getDailyBootScale())));
								dto.setMonthlyBootScale(Double.parseDouble(String.format("%.2f", dto.getMonthlyBootScale())));
								dto.setMonth(DateUtil.getDateTime(DateUtil.parseDate(dto.getMonth()), DateUtil.DEFAULT_YEARMONTH_FORMAT));//月份做处理
								dto.setActivation(Double.parseDouble(String.format("%.2f", dto.getActivation())));
								mongoTemplate.insert(dto,"manufacturers_active");
							}
						}
						public List<Object> getDatas() {
							return datas;
						}

						public void setDatas(List<Object> datas) {
							this.datas = datas;
						}
				 }).headRowNumber(1).sheet().doRead();
				 
			}
		} catch (Exception e) {
			logger.error("导入数据出现异常：",e);
		}
		
	}

	/**
	 * 
	 * 功能描述：控制是否显示
	 *
	 * @param modelType
	 * @param familyType
	 * @param isShow
	 * 
	 * @author 张兵帅
	 *
	 * @since 2020年9月14日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Transactional
	public void controlFrontIsShow(Integer modelType, Integer isShow) {
		Query query = new Query();
		if(modelType==0){//销量数据
			query.addCriteria(Criteria.where("model_type").is(modelType));
		}else if(modelType==1){
			query.addCriteria(Criteria.where("model_type").is(modelType));
		}else if(modelType==2){//ORS市场数据
			query.addCriteria(Criteria.where("model_type").is(modelType));
		}
		
		Update update = new Update();
		update.set("is_show", isShow);
		
		mongoTemplate.updateFirst(query, update, "model_control");
	}
	
	
	public void saveFileToMongo(String taskName,String userName,int modelType,String month){
		/**
		 * 添加下载-中心任务记录
		 */
		Orsv2Download orsEntity=new Orsv2Download();
		orsEntity.setTaskName(taskName);
		orsEntity.setUserName(userName);
		orsEntity.setStatus("完成");//状态
		orsEntity.setStartTime(DateUtil.getDateTime());//开始时间
		
		orsEntity.setModule1(String.valueOf(modelType));
		orsEntity.setModule2(month);
		orsEntity.setDownloadType(0);//0.后台下载 1.其它下载
		
		String reqUrl=String.format("http://cloud.huan.tv/ors-admin/api/anon/v2_1/market/front/export/excel?modelType=%d&month=%s&taskName=%s",modelType,month,taskName);
		orsEntity.setIp(reqUrl);//后台下载
		mongoTemplate.insert(orsEntity,"ors_v2_download");
		
	}

	public void addDownRecord(String taskName,String userName,
//			List<String> regionList,List<String> brandTypeList,String quarter){
			String regionListStr,String brandTypeListStr,String quarter){
		/**
		 * 添加下载-中心任务记录
		 */
		Orsv2Download orsEntity=new Orsv2Download();
		orsEntity.setTaskName(taskName);
		orsEntity.setUserName(userName);
		orsEntity.setStatus("完成");//状态
		orsEntity.setStartTime(DateUtil.getDateTime());//开始时间
		
		orsEntity.setRegional(regionListStr);
		orsEntity.setBrandTypeList(brandTypeListStr);
		orsEntity.setModule1("市场规模");
		String quarterStr="";
		
		if(quarter.split("_")[1].equals("1")){
			quarterStr=String.valueOf(quarter.split("_")[1])+"年第一季度";
		}else if(quarter.split("_")[1].equals("2")){
			quarterStr=String.valueOf(quarter.split("_")[1])+"年第二季度";
		}else if(quarter.split("_")[1].equals("3")){
			quarterStr=String.valueOf(quarter.split("_")[1])+"年第三季度";
		}else if(quarter.split("_")[1].equals("4")){
			quarterStr=String.valueOf(quarter.split("_")[1])+"年第四季度";
		}
		
		orsEntity.setModule2(quarterStr);
		orsEntity.setDownloadType(0);//0.后台下载 1.其它下载
		
		String reqUrl=String.format("http://cloud.huan.tv/ors-admin/api/anon/v2_1/export/quarter/data?regionList=%s&brandTypeList=%s&quarter=%s&taskName=%s",regionListStr,brandTypeListStr,quarter,taskName);
		logger.info("请求url：{}",reqUrl);
		
		orsEntity.setIp(reqUrl);//后台下载
		mongoTemplate.insert(orsEntity,"ors_v2_download");
		
	}
	
	
	/**
	 * @MethodName	: getMongo
	 * @Description	: 获取数据连接
	 * @return 返回mongon
	 */
	private Mongo getMongo(){
		Mongo mongo=null;
		try {
			mongo = new Mongo(env.getProperty("spring.data.mongodb.host"),27017);
			logger.info("mongo 地址：{}",env.getProperty("spring.data.mongodb.host"));
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取数据库连接异常：",e);
		}
		return mongo;
	}
}