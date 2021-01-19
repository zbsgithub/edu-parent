                                                                                                
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.BackSchoolServiceDao;
import com.gzdata.core.model.BackSchoolService;

/**
 * 
 * 说明：处理对返校服务的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class BackSchoolServiceService extends AbstractBaseService<BackSchoolService> {

	@Autowired
	private BackSchoolServiceDao backSchoolServiceDao;
	
	 
	@Override
	protected BaseDAOInterface<BackSchoolService> getDAO() {
		return backSchoolServiceDao;
	}

}