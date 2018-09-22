package com.merphy.web;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.merphy.dao.NewsDao;
import com.merphy.dao.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
/**
 * @author yibaowei on 9/15/18.
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class TestDao {
    @Resource
    private NewsDao newsDao;

    @Test
    public void run() {

//        Long total = newsDao.getTotal();
//        System.out.println(total);
//
//
//        News news = newsDao.getNewsById(1);
//        System.out.println(JSON.toJSONString(news));

//        News newTwo = buildNews();
//        Integer id = newsDao.insert(newTwo);
//        System.out.println("插入新闻结果："+(id != null?"成功":"失败")+id);
//        Integer integer = newsDao.deleteNews(2);
//        System.out.println("删除新闻结果："+(integer != null?"成功":"失败")+" "+integer);

        List<News> newsList = Lists.newArrayList();
        newsList.add(buildNews());
        newsList.add(buildNews());
        Integer batchInsert = newsDao.batchInsert(newsList);
        System.out.println("批量插入成功：成功条数"+batchInsert);

    }

    private News buildNews(){
        News news = new News();
        news.setTitle("趣头条暴跌");
        news.setAbout("国际新闻");
        news.setCommentCount(10000);
        news.setContent("趣头条暴跌");
        news.setCreateTime(new Date(System.currentTimeMillis()));
        news.setUpdateTime(new Date(System.currentTimeMillis()));
        news.setSourceUrl("http://news.baidu.com/");
        news.setSourceWebSite("央视新闻");
        news.setSourceWebSiteUrl("http://news.baidu.com/");
        news.setVisitCount(100000L);
        news.setTitleImage("http://imgmini.eastday.com/push/20180918/930x620_1537250198506076.jpg");
        news.setTag("股市风云");
        return news;
    }

}
