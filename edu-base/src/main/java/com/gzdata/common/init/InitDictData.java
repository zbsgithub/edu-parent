package com.gzdata.common.init;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InitDictData {

	
	private static final Logger logger=LoggerFactory.getLogger(InitDictData.class);
	//dict
	public static Map<String, Object> codeMap = new HashMap<String, Object>();
	
	@PostConstruct
	public void initData(){
		/*logger.info("启动加载初始化数据：begin------------");
		List<SysUsers> sysUserList = userService.findAll();
		for (SysUsers sysUsers : sysUserList) {
			logger.info("用户名：{}",sysUsers.getUsername());
		}
		logger.info("启动加载初始化数据：end------------");*/
	}
	
	@PreDestroy
    public void destroy(){
        logger.info("系统运行结束");
    }
}
