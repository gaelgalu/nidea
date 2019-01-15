package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;

public class Commentary implements Model {
    @Id
    private String _id;

    private String body;
    private String idea;
    private String author;

    //Constructor
    public Commentary(String _id, String body, String idea, String author){
        this._id=_id;
        this.body=body;
        this.idea=idea;
        this.author=author;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
