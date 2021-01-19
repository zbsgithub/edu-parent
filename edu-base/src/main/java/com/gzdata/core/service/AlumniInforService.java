                                                                                                                
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.AlumniInforDao;
import com.gzdata.core.model.AlumniInfor;

/**
 * 
 * 说明：处理对校友信息的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class AlumniInforService extends AbstractBaseService<AlumniInfor> {

	@Autowired
	private AlumniInforDao alumniInforDao;
	
	 
	@Override
	protected BaseDAOInterface<AlumniInfor> getDAO() {
		return alumniInforDao;
	}

}