package com.buss.shgjj.service;
import com.buss.shgjj.entity.AyShgjjEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyShgjjServiceI extends CommonService{
	
 	public void delete(AyShgjjEntity entity) throws Exception;
 	
 	public Serializable save(AyShgjjEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyShgjjEntity entity) throws Exception;
 	
}
