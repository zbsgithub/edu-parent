package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.NamingRecordDao;
import com.gzdata.core.model.NamingRecord;

/**
 * 
 * 说明：处理对冠名记录的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class NamingRecordService extends AbstractBaseService<NamingRecord> {

	@Autowired
	private NamingRecordDao namingRecordDao;

	@Override
	protected BaseDAOInterface<NamingRecord> getDAO() {
		return namingRecordDao;
	}

}