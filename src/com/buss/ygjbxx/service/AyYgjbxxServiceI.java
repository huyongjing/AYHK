package com.buss.ygjbxx.service;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyYgjbxxServiceI extends CommonService{
	
 	public void delete(AyYgjbxxEntity entity) throws Exception;
 	
 	public Serializable save(AyYgjbxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyYgjbxxEntity entity) throws Exception;
 	
}
