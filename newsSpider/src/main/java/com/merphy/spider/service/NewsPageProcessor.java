package com.merphy.spider.service;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author yibaowei on 9/21/18.
 */
public class NewsPageProcessor implements PageProcessor{

    private Site site = Site.me().setCharset("utf-8").setRetryTimes(10).setRetrySleepTime(1000);

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }
}
