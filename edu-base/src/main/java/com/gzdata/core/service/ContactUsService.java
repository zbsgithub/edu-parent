package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.ContactUsDao;
import com.gzdata.core.model.ContactUs;

/**
 * 
 * 说明：处理对联系我们的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class ContactUsService extends AbstractBaseService<ContactUs> {

	@Autowired
	private ContactUsDao contactUsDao;

	@Override
	protected BaseDAOInterface<ContactUs> getDAO() {
		return contactUsDao;
	}

}