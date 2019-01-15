package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;

public class DesafioRequest {
    private String title;
    private String content;
    private String tags;
    private String author;
    @Id
    private String _id;
    public DesafioRequest(String title, String content, String tags, String author) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.author = author;
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
}
