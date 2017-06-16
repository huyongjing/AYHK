package com.buss.jx.service;
import com.buss.jx.entity.AyJxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyJxServiceI extends CommonService{
	
 	public void delete(AyJxEntity entity) throws Exception;
 	
 	public Serializable save(AyJxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyJxEntity entity) throws Exception;
 	
}
