package com.buss.zxpz.service;
import com.buss.zxpz.entity.AyZxpzEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyZxpzServiceI extends CommonService{
	
 	public void delete(AyZxpzEntity entity) throws Exception;
 	
 	public Serializable save(AyZxpzEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyZxpzEntity entity) throws Exception;
 	
}
