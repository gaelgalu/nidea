package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Idea{
	@Id	
	private String _id;
	private String content;

	@DBRef
	private String author;


	public Idea(String content, String author){
		this.content = content;
		this.author = author;
	}

	public String getId(){
		return this._id;
	}

	public void setId(String _id){
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

}