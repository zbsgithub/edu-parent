                                                                                                                            
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.FileEnquiryDao;
import com.gzdata.core.model.FileEnquiry;

/**
 * 
 * 说明：处理对档案查询的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class FileEnquiryService extends AbstractBaseService<FileEnquiry> {

	@Autowired
	private FileEnquiryDao fileEnquiryDao;
	
	 
	@Override
	protected BaseDAOInterface<FileEnquiry> getDAO() {
		return fileEnquiryDao;
	}

}