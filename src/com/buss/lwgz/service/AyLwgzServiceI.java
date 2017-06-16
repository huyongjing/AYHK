package com.buss.lwgz.service;
import com.buss.lwgz.entity.AyLwgzEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyLwgzServiceI extends CommonService{
	
 	public void delete(AyLwgzEntity entity) throws Exception;
 	
 	public Serializable save(AyLwgzEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyLwgzEntity entity) throws Exception;
 	
}
