package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;

public class CommentaryRequest {
    @Id
    private String _id;
    private String body;
    private String idea;
    private String author;
    //Constructor
    public CommentaryRequest(String body, String author){
        this.author=author;
        this.body=body;
    }

    public String get_id() { return _id; }

    public String getBody() {  return body; }

    public String getIdea() {  return idea; }

    public String getAuthor() { return author; }
}
