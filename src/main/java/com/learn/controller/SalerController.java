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

import com.learn.entity.SalerEntity;
import com.learn.service.SalerService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 卖家信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:43:34
 */
@RestController
@RequestMapping("saler")
public class SalerController extends AbstractController {
	@Autowired
	private SalerService salerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

																																										

		//查询列表数据
        Query query = new Query(params);

		List<SalerEntity> salerList = salerService.queryList(query);
		int total = salerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(salerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<SalerEntity> salerList = salerService.queryList(query);
		return R.ok().put("list", salerList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		SalerEntity saler = salerService.queryObject(id);
		
		return R.ok().put("saler", saler);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SalerEntity saler){

																																										

        salerService.save(saler);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SalerEntity saler){
		salerService.update(saler);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		salerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
