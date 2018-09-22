package com.merphy.spider.service;

import com.merphy.spider.model.NewsDto;
import com.merphy.spider.model.OriginNewsInfo;
import java.util.List;

public interface HtmlProcessor {
    /**
     * 解析器解析原始数据信息
     * @param originNewsInfo 原始新闻网页信息
     * @return 解析后的数据
     */
    List<NewsDto> processor(OriginNewsInfo originNewsInfo);
}
