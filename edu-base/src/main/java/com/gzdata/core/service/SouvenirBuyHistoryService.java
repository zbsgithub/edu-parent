                                                                            
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.SouvenirBuyHistoryDao;
import com.gzdata.core.model.SouvenirBuyHistory;

/**
 * 
 * 说明：处理对纪念品-购买历史的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class SouvenirBuyHistoryService extends AbstractBaseService<SouvenirBuyHistory> {

	@Autowired
	private SouvenirBuyHistoryDao souvenirBuyHistoryDao;
	
	 
	@Override
	protected BaseDAOInterface<SouvenirBuyHistory> getDAO() {
		return souvenirBuyHistoryDao;
	}

}