package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

								

import com.learn.dao.BuyerDao;
import com.learn.entity.BuyerEntity;
import com.learn.service.BuyerService;
import com.learn.service.*;



@Service("buyerService")
public class BuyerServiceImpl implements BuyerService {
	@Autowired
	private BuyerDao buyerDao;

			

			

			

			

			

			

			

			

	

	
	@Override
	public BuyerEntity queryObject(Long id){
			BuyerEntity entity = buyerDao.queryObject(id);

																									
		return entity;
	}
	
	@Override
	public List<BuyerEntity> queryList(Map<String, Object> map){
        List<BuyerEntity> list = buyerDao.queryList(map);
        for(BuyerEntity entity : list){
																																																													}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return buyerDao.queryTotal(map);
	}
	
	@Override
	public void save(BuyerEntity buyer){
		buyerDao.save(buyer);
	}
	
	@Override
	public void update(BuyerEntity buyer){
		buyerDao.update(buyer);
	}
	
	@Override
	public void delete(Long id){
		buyerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		buyerDao.deleteBatch(ids);
	}
	
}
