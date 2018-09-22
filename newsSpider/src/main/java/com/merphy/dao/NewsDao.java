package com.merphy.dao;

import com.merphy.dao.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yibaowei on 9/9/18.
 */
@Repository
public interface NewsDao {
    /**
     * 根据Id获取基本信息
     * @param id id
     * @return 新闻信息
     */
    News getNewsById(Integer id);

    /**
     * 查询新闻信息
     * @param queryParam 新闻信息
     * @return 新闻列表
     */
    List<News> queryNews(Map<String,Object> queryParam);

    /**
     * 获取新闻总数
     * @return 获取总数
     */
    Long getTotal();

    /**
     * 插入新闻
     * @param news 新闻
     * @return 插入新闻
     */
    Integer insert(News news);

    /**
     * 插入多条新闻信息
     * @param newsList 新闻列表
     * @return 插入成功个数
     */
    Integer batchInsert(List<News> newsList);

    /**
     * 删除新闻数据
     * @param id id
     * @return 删除新闻个数
     */
    Integer deleteNews(Integer id);
}
