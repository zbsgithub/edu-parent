                                                                
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.BannerManageDao;
import com.gzdata.core.model.BannerManage;

/**
 * 
 * 说明：处理对的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class BannerManageService extends AbstractBaseService<BannerManage> {

	@Autowired
	private BannerManageDao bannerManageDao;
	
	 
	@Override
	protected BaseDAOInterface<BannerManage> getDAO() {
		return bannerManageDao;
	}

}