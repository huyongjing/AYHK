package com.buss.kqsj.service;
import com.buss.kqsj.entity.AyKqsjEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyKqsjServiceI extends CommonService{
	
 	public void delete(AyKqsjEntity entity) throws Exception;
 	
 	public Serializable save(AyKqsjEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyKqsjEntity entity) throws Exception;
 	
}
