package com.rdbf.demo.apiauth.domain;
import java.util.Date;

public class Article {
    private Integer articleId;
    private String title;
    private Date createdDate;
    private String tag;
    private String body;
    private String owner;

    public Article(Integer articleId, String title, Date createdDate, String tag, String body, String owner) {
        this.articleId = articleId;
        this.title = title;
        this.createdDate = createdDate;
        this.tag = tag;
        this.body = body;
        this.owner = owner;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

