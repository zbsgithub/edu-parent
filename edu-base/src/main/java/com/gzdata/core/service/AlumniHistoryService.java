package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.AlumniHistoryDao;
import com.gzdata.core.model.AlumniHistory;

/**
 * 
 * 说明：处理对校友历史的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class AlumniHistoryService extends AbstractBaseService<AlumniHistory> {

	@Autowired
	private AlumniHistoryDao alumniHistoryDao;

	@Override
	protected BaseDAOInterface<AlumniHistory> getDAO() {
		return alumniHistoryDao;
	}

}