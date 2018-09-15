package com.merphy.dao.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yibaowei on 9/9/18.
 */
@Component
public class News implements Serializable{
    private static final long serialVersionUID = -5548428266189700916L;

    private Integer id;
    private String title;//标题
    private String titleImage;//标题图片
    private String content;//内容
    private String tag;//新闻标签
    private String sourceWebSite;//新闻来源网址名称
    private String sourceWebSiteUrl;//新闻来源网站网址
    private String sourceUrl;//新闻网址
    private Long visitCount;//浏览次数
    private Integer commentCount;//点评次数
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String about;//备注


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSourceWebSite() {
        return sourceWebSite;
    }

    public void setSourceWebSite(String sourceWebSite) {
        this.sourceWebSite = sourceWebSite;
    }

    public String getSourceWebSiteUrl() {
        return sourceWebSiteUrl;
    }

    public void setSourceWebSiteUrl(String sourceWebSiteUrl) {
        this.sourceWebSiteUrl = sourceWebSiteUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
