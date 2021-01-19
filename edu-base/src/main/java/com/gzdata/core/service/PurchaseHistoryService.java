package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.PurchaseHistoryDao;
import com.gzdata.core.model.PurchaseHistory;

/**
 * 
 * 说明：处理对已购代捐-购买历史的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class PurchaseHistoryService extends
		AbstractBaseService<PurchaseHistory> {

	@Autowired
	private PurchaseHistoryDao purchaseHistoryDao;

	@Override
	protected BaseDAOInterface<PurchaseHistory> getDAO() {
		return purchaseHistoryDao;
	}

}