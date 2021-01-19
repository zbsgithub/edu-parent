package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.CashDonationDao;
import com.gzdata.core.model.CashDonation;

/**
 * 
 * 说明：处理对现金捐赠的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class CashDonationService extends AbstractBaseService<CashDonation> {

	@Autowired
	private CashDonationDao cashDonationDao;

	@Override
	protected BaseDAOInterface<CashDonation> getDAO() {
		return cashDonationDao;
	}

}