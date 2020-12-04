package com.gzdata.core.controller.online;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.dto.IndividualMarketActivationDto;

/* 解析监听器，
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
 *
 * 下面只是我写的一个样例而已，可以根据自己的逻辑修改该类。
 * @author jipengfei
 * @date 2017/03/14
 */
@Component
public class ExcelListenerIndiviual extends AnalysisEventListener {

	private static final Logger logger = LoggerFactory.getLogger(ExcelListenerIndiviual.class);
	

	/**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;
    
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// 自定义用于暂时存储data。
	// 可以通过实例获取该值
	private List<Object> datas = new ArrayList<Object>();

	public void invoke(Object object, AnalysisContext context) {
		datas.add(object);// 数据存储到list，供批量处理，或后续自己业务逻辑处理。
		
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
}
