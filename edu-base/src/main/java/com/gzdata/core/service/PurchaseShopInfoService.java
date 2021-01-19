package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.PurchaseShopInfoDao;
import com.gzdata.core.model.PurchaseShopInfo;

/**
 * 
 * 说明：处理对已购代捐-商品信息的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class PurchaseShopInfoService extends
		AbstractBaseService<PurchaseShopInfo> {

	@Autowired
	private PurchaseShopInfoDao purchaseShopInfoDao;

	@Override
	protected BaseDAOInterface<PurchaseShopInfo> getDAO() {
		return purchaseShopInfoDao;
	}

}