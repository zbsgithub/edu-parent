                                                                                                                        
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.NamingInfoDao;
import com.gzdata.core.model.NamingInfo;

/**
 * 
 * 说明：处理对冠名信息的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class NamingInfoService extends AbstractBaseService<NamingInfo> {

	@Autowired
	private NamingInfoDao namingInfoDao;
	
	 
	@Override
	protected BaseDAOInterface<NamingInfo> getDAO() {
		return namingInfoDao;
	}

}