package com.buss.tbxs.service;
import com.buss.tbxs.entity.AyTbxsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AyTbxsServiceI extends CommonService{
	
 	public void delete(AyTbxsEntity entity) throws Exception;
 	
 	public Serializable save(AyTbxsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AyTbxsEntity entity) throws Exception;
 	
}
