package com.merphy.web;

import com.alibaba.fastjson.JSON;
import com.merphy.dao.NewsDao;
import com.merphy.dao.model.News;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yibaowei on 9/15/18.
 */
public class AppMain {


    public static void main(String[] args) {
        NewsDao newsDao = (NewsDao) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("newsDao");

        Long total = newsDao.getTotal();
        News news = newsDao.getNewsById(1);

        System.out.println(total);
        System.out.println(JSON.toJSONString(news));
    }

}
