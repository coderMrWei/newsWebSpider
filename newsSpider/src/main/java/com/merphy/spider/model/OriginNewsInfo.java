package com.merphy.spider.model;

import us.codecraft.webmagic.selector.Html;

public class OriginNewsInfo {
    private String pickDate;
    private Html originHtml;

    public String getPickDate() {
        return pickDate;
    }

    public void setPickDate(String pickDate) {
        this.pickDate = pickDate;
    }

    public Html getOriginHtml() {
        return originHtml;
    }

    public void setOriginHtml(Html originHtml) {
        this.originHtml = originHtml;
    }
}
