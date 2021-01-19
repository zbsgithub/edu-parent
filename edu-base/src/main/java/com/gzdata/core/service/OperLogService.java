                                                
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.OperLogDao;
import com.gzdata.core.model.OperLog;

/**
 * 
 * 说明：处理对操作日志表的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class OperLogService extends AbstractBaseService<OperLog> {

	@Autowired
	private OperLogDao operLogDao;
	
	 
	@Override
	protected BaseDAOInterface<OperLog> getDAO() {
		return operLogDao;
	}

}