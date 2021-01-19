                                                                                        
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.BaseGraduateDao;
import com.gzdata.core.model.BaseGraduate;

/**
 * 
 * 说明：处理对基础-研究生的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class BaseGraduateService extends AbstractBaseService<BaseGraduate> {

	@Autowired
	private BaseGraduateDao baseGraduateDao;
	
	 
	@Override
	protected BaseDAOInterface<BaseGraduate> getDAO() {
		return baseGraduateDao;
	}

}