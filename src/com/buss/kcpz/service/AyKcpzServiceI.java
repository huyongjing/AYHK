package com.buss.kcpz.service;
import com.buss.kcpz.entity.AyKcpzEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyKcpzServiceI extends CommonService{
	
 	public void delete(AyKcpzEntity entity) throws Exception;
 	
 	public Serializable save(AyKcpzEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyKcpzEntity entity) throws Exception;
	/**
	 * 对数据进行缓存
	 */
	//public void initAllAyKcpzEntity();
 	
}
