package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.core.dao.SysUserWebDao;

/**
 * 用户数据
 * 
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2021年1月19日
 */
@Service
public class SysUserWebService extends SysUserService {

	@Autowired
	private SysUserWebDao sysUserWebDao;
	
	public int findUserCount(){
		return sysUserWebDao.findUserCount();
	}
	
}
