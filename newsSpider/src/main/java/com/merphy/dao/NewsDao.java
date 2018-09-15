package com.merphy.dao;

import com.merphy.dao.model.News;
import java.util.List;
import java.util.Map;

/**
 * @author yibaowei on 9/9/18.
 */
public interface NewsDao {
    News getNewsById(Integer id);
    List<News> queryNews(Map<String,Object> queryParam);
    Long getTotal();
    Boolean insert(News news);
    //Boolean deleteNews(Long id);
}
