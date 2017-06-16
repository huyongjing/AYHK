package com.buss.gz.service;
import com.buss.gz.entity.AyGzEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyGzServiceI extends CommonService{
	
 	public void delete(AyGzEntity entity) throws Exception;
 	
 	public Serializable save(AyGzEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyGzEntity entity) throws Exception;
 	
}
