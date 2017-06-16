package com.buss.sjpz.service;
import com.buss.sjpz.entity.AySjpzEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AySjpzServiceI extends CommonService{
	
 	public void delete(AySjpzEntity entity) throws Exception;
 	
 	public Serializable save(AySjpzEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AySjpzEntity entity) throws Exception;
 	
}
