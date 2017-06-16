package com.buss.lwgzsj.service;
import com.buss.lwgzsj.entity.AyLwgzsjEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyLwgzsjServiceI extends CommonService{
	
 	public void delete(AyLwgzsjEntity entity) throws Exception;
 	
 	public Serializable save(AyLwgzsjEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyLwgzsjEntity entity) throws Exception;
 	
}
