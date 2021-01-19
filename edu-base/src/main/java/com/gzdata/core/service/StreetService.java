                                            
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.StreetDao;
import com.gzdata.core.model.Street;

/**
 * 
 * 说明：处理对街道详细数据的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class StreetService extends AbstractBaseService<Street> {

	@Autowired
	private StreetDao streetDao;
	
	 
	@Override
	protected BaseDAOInterface<Street> getDAO() {
		return streetDao;
	}

}