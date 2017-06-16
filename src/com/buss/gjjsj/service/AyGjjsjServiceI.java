package com.buss.gjjsj.service;
import com.buss.gjjsj.entity.AyGjjsjEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyGjjsjServiceI extends CommonService{
	
 	public void delete(AyGjjsjEntity entity) throws Exception;
 	
 	public Serializable save(AyGjjsjEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyGjjsjEntity entity) throws Exception;
 	
}
