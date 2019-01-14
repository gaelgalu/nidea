package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;
import java.text.*;

public class Idea{
	@Id	
	private String _id;

	private String title;
	private String content;
	private String author;
	private List<String> tags;

	public Idea(String _id, String title, String content, String author, List<String> tags){
		this._id = _id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.tags = tags;
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
}