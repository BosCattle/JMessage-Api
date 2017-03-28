package tech.jiangtao.backstage.model;

import java.util.Date;

public class ShortNews {
    private Long snid;

    private Date publishingTime;

    private String newsType;

    private String author;

    private String subject;

    private String body;

    public Long getSnid() {
        return snid;
    }

    public void setSnid(Long snid) {
        this.snid = snid;
    }

    public Date getPublishingTime() {
        return publishingTime;
    }

    public void setPublishingTime(Date publishingTime) {
        this.publishingTime = publishingTime;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType == null ? null : newsType.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }
}