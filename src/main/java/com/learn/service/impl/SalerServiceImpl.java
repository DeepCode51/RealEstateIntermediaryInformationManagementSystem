package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

								

import com.learn.dao.SalerDao;
import com.learn.entity.SalerEntity;
import com.learn.service.SalerService;
import com.learn.service.*;



@Service("salerService")
public class SalerServiceImpl implements SalerService {
	@Autowired
	private SalerDao salerDao;

			

			

			

			

			

			

			

			

	

	
	@Override
	public SalerEntity queryObject(Long id){
			SalerEntity entity = salerDao.queryObject(id);

																									
		return entity;
	}
	
	@Override
	public List<SalerEntity> queryList(Map<String, Object> map){
        List<SalerEntity> list = salerDao.queryList(map);
        for(SalerEntity entity : list){
																																																													}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return salerDao.queryTotal(map);
	}
	
	@Override
	public void save(SalerEntity saler){
		salerDao.save(saler);
	}
	
	@Override
	public void update(SalerEntity saler){
		salerDao.update(saler);
	}
	
	@Override
	public void delete(Long id){
		salerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		salerDao.deleteBatch(ids);
	}
	
}
