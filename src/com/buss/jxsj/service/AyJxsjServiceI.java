package com.buss.jxsj.service;
import com.buss.jxsj.entity.AyJxsjEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyJxsjServiceI extends CommonService{
	
 	public void delete(AyJxsjEntity entity) throws Exception;
 	
 	public Serializable save(AyJxsjEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyJxsjEntity entity) throws Exception;
 	
}
