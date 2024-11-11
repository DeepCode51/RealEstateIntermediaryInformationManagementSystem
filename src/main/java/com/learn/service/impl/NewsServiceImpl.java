package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

				

import com.learn.dao.NewsDao;
import com.learn.entity.NewsEntity;
import com.learn.service.NewsService;
import com.learn.service.*;



@Service("newsService")
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao newsDao;

			

			

			

			

	

	
	@Override
	public NewsEntity queryObject(Long id){
			NewsEntity entity = newsDao.queryObject(id);

													
		return entity;
	}
	
	@Override
	public List<NewsEntity> queryList(Map<String, Object> map){
        List<NewsEntity> list = newsDao.queryList(map);
        for(NewsEntity entity : list){
																																	}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return newsDao.queryTotal(map);
	}
	
	@Override
	public void save(NewsEntity news){
		newsDao.save(news);
	}
	
	@Override
	public void update(NewsEntity news){
		newsDao.update(news);
	}
	
	@Override
	public void delete(Long id){
		newsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		newsDao.deleteBatch(ids);
	}
	
}
