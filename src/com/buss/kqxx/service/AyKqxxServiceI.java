package com.buss.kqxx.service;
import com.buss.kqxx.entity.AyKqxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyKqxxServiceI extends CommonService{
	
 	public void delete(AyKqxxEntity entity) throws Exception;
 	
 	public Serializable save(AyKqxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyKqxxEntity entity) throws Exception;
 	
}
