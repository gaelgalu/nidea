package com.fingeso1.NIdea.Models;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Desafio implements Model {
    @Id
    private String _id;

    private String title;
    private String content;
    private String author;
    private String creationDate;
    private String endDate;
    private List<String> tags;

    public Desafio(String _id, String title, String content, String author, List<String> tags, String creationDate, String endDate){
        this._id = _id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.tags = tags;
        this.creationDate = creationDate;
        this.endDate = endDate;
    }

    public String get_id(){
        return this._id;
    }

    public void set_id(String _id){
        this._id = _id;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }

    public List<String> getTags(){
        return this.tags;
    }

    public void setTitle(String title){
        this.title = title;
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
