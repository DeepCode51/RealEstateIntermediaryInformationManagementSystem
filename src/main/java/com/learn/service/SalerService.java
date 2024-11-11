package com.learn.service;

import com.learn.entity.SalerEntity;

import java.util.List;
import java.util.Map;

/**
 * 卖家信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:43:34
 */
public interface SalerService {
    /**
    * 查询
	* @return
	*/
	SalerEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<SalerEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(SalerEntity saler);

    /**
    * 修改
    * @return
    */
	void update(SalerEntity saler);

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
