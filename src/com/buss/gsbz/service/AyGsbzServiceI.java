package com.buss.gsbz.service;
import com.buss.gsbz.entity.AyGsbzEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyGsbzServiceI extends CommonService{
	
 	public void delete(AyGsbzEntity entity) throws Exception;
 	
 	public Serializable save(AyGsbzEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyGsbzEntity entity) throws Exception;
 	
}
