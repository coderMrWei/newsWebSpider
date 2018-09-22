package com.merphy.web;

import com.google.common.collect.Maps;
import com.merphy.common.ApiResponseUtil;
import com.merphy.dao.NewsDao;
import com.merphy.dao.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author yibaowei on 9/15/18.
 */

@Controller
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsDao newsDao;

    @ResponseBody
    @RequestMapping("/shows.json")
    public Object queryNews(Integer id) {
        Map<String,Object> queryParam = Maps.newHashMap();
        queryParam.put("id",1);
        List<News> news = newsDao.queryNews(queryParam);
        //News newsById = newsDao.getNewsById(id);
        //Long newsById = newsDao.getTotal();
        if(news != null) {
            return ApiResponseUtil.genDataResponse(news);
        }else {
            return ApiResponseUtil.genErrResponse("查询不到新闻信息",-1);
        }
    }
}
