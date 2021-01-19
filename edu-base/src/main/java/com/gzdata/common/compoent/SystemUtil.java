package com.gzdata.common.compoent;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gzdata.core.model.SysUser;
import com.gzdata.core.qo.SysUserQo;
import com.gzdata.core.service.SysPermissionService;
import com.gzdata.core.service.SysUserService;


/**
 * 系统工具类
 *
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2018年4月1日
 */
@Component
public class SystemUtil {

	private static final Logger logger=LoggerFactory.getLogger(SystemUtil.class);

	@Autowired
	private HttpSession session;
	@Resource
	private SysUserService sysUserService;
	@Autowired
	private SysPermissionService permissionsService;

	/**
	 *
	 * 功能描述：得到当前用户信息
	 *
	 * @return
	 *
	 * @author 张兵帅
	 *
	 * @since 2018年4月1日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public SysUser getCurrentUser(){
		SysUser entitySysUsers=null;
		String sessionId=String.valueOf(session.getAttribute("token"));
		Session session = getSessionById(sessionId);

		Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        //org.apache.shiro.subject.SimplePrincipalCollection cannot be cast to com.hncxhd.bywl.entity.manual.UserInfo
        SimplePrincipalCollection coll = (SimplePrincipalCollection) obj;

        SysUserQo qo=new SysUserQo();
        qo.setEmail((String)coll.getPrimaryPrincipal());
//        qo.setLocked(0);
        List<SysUser> userList = sysUserService.findList(qo);

        if(userList!=null && !userList.isEmpty()){
        	entitySysUsers = userList.get(0);
        	logger.info("user_name:"+entitySysUsers.getUserName());
        }

		logger.info("----------------session 中对应的token ==> sessionId:"+sessionId);
		return entitySysUsers;
	}


	/**
     * 通过sessionid获取Session
     * @param sessionId
     * @return Session
     */
    public static Session getSessionById(String sessionId){
        SessionKey sessionKey = new SessionKey() {
            @Override
            public Serializable getSessionId() {
                return sessionId;
            }
        };
        return SecurityUtils.getSecurityManager().getSession(sessionKey);
    }


	/**
	 *
	 * 功能描述：获得当前用户的userId
	 *
	 * @return
	 *
	 * @author 张兵帅
	 *
	 * @since 2019年9月4日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public Integer getCurrentUserId(){
		Integer userId = getCurrentUser().getId();
		logger.info("----------------session 中对应的userId 值："+userId);
		return userId;
	}


	/**
	 *
	 * 功能描述：获取当前用户权限列表信息
	 *
	 * @return
	 *
	 * @author 张兵帅
	 *
	 * @since 2020年5月12日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	/*public List<String> getCurrentPermission(){
		List<String> permiList = new ArrayList<String>();
		List<Integer> permissionIds = permissionsService.getCurrentUserPermiId(getCurrentRole());
		if(permissionIds!=null && !permissionIds.isEmpty()){//存在权限列表数据
			for (Integer id : permissionIds) {
				permiList.add(permissionsService.findById(id).getPermission());
			}
		}
		return permiList;
	}*/
}
