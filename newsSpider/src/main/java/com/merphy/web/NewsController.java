package com.merphy.web;

import com.merphy.common.ApiResponseUtil;
import com.merphy.dao.NewsDao;
import com.merphy.dao.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
        News newsById = newsDao.getNewsById(id);
        if(newsById != null) {
            return ApiResponseUtil.genDataResponse(newsById);
        }else {
            return ApiResponseUtil.genErrResponse("查询不到新闻信息",-1);
        }
    }
}
