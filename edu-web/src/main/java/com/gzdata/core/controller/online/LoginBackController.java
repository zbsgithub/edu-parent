package com.gzdata.core.controller.online;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.log.StaticLog;

import com.gzdata.common.compoent.SystemUtil;
import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.util.AESUtil;
import com.gzdata.core.service.SysPermissionService;
import com.gzdata.core.service.SysUserWebService;

@RestController
@Api("登录控制器")
@RequestMapping("api")
public class LoginBackController {


	private static final Logger logger = LoggerFactory.getLogger(LoginBackController.class);

	@Resource
	private SystemUtil systemUtil;
	@Autowired
	private SysPermissionService permissionsService;
	@Autowired
    private Environment env;
	@Resource
	private SysUserWebService sysUserWebService;
	

	/**
	 *
	 * 功能描述：默认登录
	 *
	 * @param username
	 * @param password
	 * @return
	 *
	 * @author 张兵帅
	 *
	 * @since 2020年5月11日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("账号密码登录")
	@PostMapping(value = "/login")
	public Result login(@RequestParam(name="account",value="account",required=true) String account,
			@RequestParam(name="password",value="password",required=true) String password) {
		
		logger.info("account decrypt: {}	password decrypt: {}",account,password);
		Map<String, Object> resultMap=new HashMap<String, Object>();
		
		logger.info("用户数：{}",sysUserWebService.findUserCount());

		
		return Result.valueOf(Result.SUCCESS,"登录成功", resultMap);
	}
	
}
