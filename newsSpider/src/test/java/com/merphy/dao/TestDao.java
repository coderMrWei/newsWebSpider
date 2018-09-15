package com.merphy.dao;

import com.merphy.dao.model.News;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

/**
 * @author yibaowei on 9/15/18.
 */
public class TestDao {
    public static void main(String[] args) {
        ApplicationContext atc = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsDao dao = (NewsDao) atc.getBean("newsDao");

        Long total = dao.getTotal();
        System.out.println(total);
    }

}
