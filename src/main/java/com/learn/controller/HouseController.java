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

import com.learn.entity.HouseEntity;
import com.learn.service.HouseService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 房屋信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:43:35
 */
@RestController
@RequestMapping("house")
public class HouseController extends AbstractController {
	@Autowired
	private HouseService houseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

																																																																			

		//查询列表数据
        Query query = new Query(params);

		List<HouseEntity> houseList = houseService.queryList(query);
		int total = houseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(houseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<HouseEntity> houseList = houseService.queryList(query);
		return R.ok().put("list", houseList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		HouseEntity house = houseService.queryObject(id);
		
		return R.ok().put("house", house);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody HouseEntity house){

																																																																			

        houseService.save(house);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody HouseEntity house){
		houseService.update(house);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		houseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
