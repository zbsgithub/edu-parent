package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.SouvenirMallDao;
import com.gzdata.core.model.SouvenirMall;

/**
 * 
 * 说明：处理对积分商城 的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class SouvenirMallService extends AbstractBaseService<SouvenirMall> {

	@Autowired
	private SouvenirMallDao souvenirMallDao;

	@Override
	protected BaseDAOInterface<SouvenirMall> getDAO() {
		return souvenirMallDao;
	}

}