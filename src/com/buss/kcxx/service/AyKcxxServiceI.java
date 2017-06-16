package com.buss.kcxx.service;
import com.buss.kcxx.entity.AyKcxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyKcxxServiceI extends CommonService{
	
 	public void delete(AyKcxxEntity entity) throws Exception;
 	
 	public Serializable save(AyKcxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyKcxxEntity entity) throws Exception;
 	
}
