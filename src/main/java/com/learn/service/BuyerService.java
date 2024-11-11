package com.learn.service;

import com.learn.entity.BuyerEntity;

import java.util.List;
import java.util.Map;

/**
 * 买家信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:40:27
 */
public interface BuyerService {
    /**
    * 查询
	* @return
	*/
	BuyerEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<BuyerEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(BuyerEntity buyer);

    /**
    * 修改
    * @return
    */
	void update(BuyerEntity buyer);

    /**
    * 删除
    * @return
    */
	void delete(Long id);

    /**
    * 批量删除
    * @return
    */
	void deleteBatch(Long[] ids);
}
