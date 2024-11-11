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

import com.learn.entity.BuyerEntity;
import com.learn.service.BuyerService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 买家信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:40:27
 */
@RestController
@RequestMapping("buyer")
public class BuyerController extends AbstractController {
	@Autowired
	private BuyerService buyerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

																																										

		//查询列表数据
        Query query = new Query(params);

		List<BuyerEntity> buyerList = buyerService.queryList(query);
		int total = buyerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(buyerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<BuyerEntity> buyerList = buyerService.queryList(query);
		return R.ok().put("list", buyerList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		BuyerEntity buyer = buyerService.queryObject(id);
		
		return R.ok().put("buyer", buyer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody BuyerEntity buyer){

																																										

        buyerService.save(buyer);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody BuyerEntity buyer){
		buyerService.update(buyer);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		buyerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
