package com.learn.service;

import com.learn.entity.NewsEntity;

import java.util.List;
import java.util.Map;

/**
 * 通知公告
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:41:54
 */
public interface NewsService {
    /**
    * 查询
	* @return
	*/
	NewsEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<NewsEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(NewsEntity news);

    /**
    * 修改
    * @return
    */
	void update(NewsEntity news);

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
