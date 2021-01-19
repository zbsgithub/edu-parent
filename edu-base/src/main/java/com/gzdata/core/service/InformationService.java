package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.InformationDao;
import com.gzdata.core.model.Information;

/**
 * 
 * 说明：处理对资讯信息表的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class InformationService extends AbstractBaseService<Information> {

	@Autowired
	private InformationDao informationDao;

	@Override
	protected BaseDAOInterface<Information> getDAO() {
		return informationDao;
	}

}