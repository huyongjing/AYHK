package com.buss.gzsj.service;
import com.buss.gzsj.entity.AyGzsjEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyGzsjServiceI extends CommonService{
	
 	public void delete(AyGzsjEntity entity) throws Exception;
 	
 	public Serializable save(AyGzsjEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyGzsjEntity entity) throws Exception;
 	
}
