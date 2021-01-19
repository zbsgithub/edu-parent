                                                        
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.BindAccountDao;
import com.gzdata.core.model.BindAccount;

/**
 * 
 * 说明：处理对绑定账号的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class BindAccountService extends AbstractBaseService<BindAccount> {

	@Autowired
	private BindAccountDao bindAccountDao;
	
	 
	@Override
	protected BaseDAOInterface<BindAccount> getDAO() {
		return bindAccountDao;
	}

}