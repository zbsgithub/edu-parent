                                                                                                        
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.BaseUndergraduateDao;
import com.gzdata.core.model.BaseUndergraduate;

/**
 * 
 * 说明：处理对基础-普通专本科的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class BaseUndergraduateService extends AbstractBaseService<BaseUndergraduate> {

	@Autowired
	private BaseUndergraduateDao baseUndergraduateDao;
	
	 
	@Override
	protected BaseDAOInterface<BaseUndergraduate> getDAO() {
		return baseUndergraduateDao;
	}

}