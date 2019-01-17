package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;

public class CommentaryRequest {
    @Id
    private String _id;
    private String body;
    private String idea;
    private String author;
    private String commentDate;
    //Constructor
    public CommentaryRequest(String body, String author, String idea, String commentDate){
        this.author = author;
        this.body = body;
        this.idea = idea;
        this.commentDate = commentDate;
    }

    public String get_id() { return this._id; }

    public String getBody() {  return this.body; }

    public String getIdea() {  return this.idea; }

    public String getAuthor() { return this.author; }

    public String getCommentDate() { return this.commentDate; }    
}
