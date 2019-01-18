package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;

public class DesafioRequest {
    private String title;
    private String content;
    private String tags;
    private String author;
    private String creationDate;
    private String endDate;
    @Id
    private String _id;
    public DesafioRequest(String title, String content, String tags, String author, String creationDate, String endDate) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.author = author;
        this.creationDate = creationDate;
        this.endDate = endDate;
    }

    public String get_id() {
        return _id;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle(){
        return this.title;
    }

    public String getCreationDate(){
        return this.creationDate;
    }

    public void setCreationDate(String creationDate){
        this.creationDate = creationDate;
    }

    public String getEndDate(){
        return this.endDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
}
