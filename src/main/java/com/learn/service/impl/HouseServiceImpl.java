package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

													

import com.learn.dao.HouseDao;
import com.learn.entity.HouseEntity;
import com.learn.service.HouseService;
import com.learn.service.*;



@Service("houseService")
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;

			

			

			

			

			

			

			

			

			

			            @Autowired
            private  SalerService  salerService;

		

			            @Autowired
            private  BuyerService  buyerService;

		

			

			

	

	
	@Override
	public HouseEntity queryObject(Long id){
			HouseEntity entity = houseDao.queryObject(id);

																														
            if ( entity.getSaler() != null &&  this.salerService.queryObject(entity.getSaler()) != null)
                entity.setSalerEntity(this.salerService.queryObject(entity.getSaler()));

					
            if ( entity.getBuyer() != null &&  this.buyerService.queryObject(entity.getBuyer()) != null)
                entity.setBuyerEntity(this.buyerService.queryObject(entity.getBuyer()));

									
		return entity;
	}
	
	@Override
	public List<HouseEntity> queryList(Map<String, Object> map){
        List<HouseEntity> list = houseDao.queryList(map);
        for(HouseEntity entity : list){
																																																																						
                    if ( entity.getSaler() != null &&  this.salerService.queryObject(entity.getSaler()) != null)
                        entity.setSalerEntity(this.salerService.queryObject(entity.getSaler()));

											
                    if ( entity.getBuyer() != null &&  this.buyerService.queryObject(entity.getBuyer()) != null)
                        entity.setBuyerEntity(this.buyerService.queryObject(entity.getBuyer()));

																							}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return houseDao.queryTotal(map);
	}
	
	@Override
	public void save(HouseEntity house){
		houseDao.save(house);
	}
	
	@Override
	public void update(HouseEntity house){
		houseDao.update(house);
	}
	
	@Override
	public void delete(Long id){
		houseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		houseDao.deleteBatch(ids);
	}
	
}
