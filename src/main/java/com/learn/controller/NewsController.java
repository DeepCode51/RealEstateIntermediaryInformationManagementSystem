package com.learn.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.NewsEntity;
import com.learn.service.NewsService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 通知公告
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:41:54
 */
@RestController
@RequestMapping("news")
public class NewsController extends AbstractController {
	@Autowired
	private NewsService newsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

																						

		//查询列表数据
        Query query = new Query(params);

		List<NewsEntity> newsList = newsService.queryList(query);
		int total = newsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(newsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<NewsEntity> newsList = newsService.queryList(query);
		return R.ok().put("list", newsList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		NewsEntity news = newsService.queryObject(id);
		
		return R.ok().put("news", news);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody NewsEntity news){

																						

        newsService.save(news);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody NewsEntity news){
		newsService.update(news);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		newsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
