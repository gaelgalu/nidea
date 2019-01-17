package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;

public class Commentary implements Model {
    @Id
    private String _id;

    private String body;
    private String idea;
    private String author;
    private String commentDate;

    //Constructor
    public Commentary(String _id, String body, String idea, String author, String commentDate){
        this._id = _id;
        this.body = body;
        this.idea = idea;
        this.author = author;
        this.commentDate = commentDate;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCommentDate(){
        return this.commentDate;
    }

    public void setCommentDate(String commentDate){
        this.commentDate = commentDate;
    }
}
