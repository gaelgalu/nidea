package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;
import java.text.*;

public class Idea implements Model{
	@Id	
	private String _id;

	private String title;
	private String content;
	private String author;
	private String creationDate;
	private int likes;
	private List<String> tags;
	private ArrayList<Commentary> publishedCommentaries;
	public Idea(String _id, String title, String content, String author, List<String> tags, int likes, ArrayList<Commentary> publishedCommentaries, String creationDate) {
		this._id = _id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.tags = tags;
		this.publishedCommentaries= publishedCommentaries;
		this.likes = likes;
		this.creationDate = creationDate;
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

	public ArrayList<Commentary> getPublishedCommentaries() {
		return publishedCommentaries;
	}

	public void setPublishedCommentaries(ArrayList<Commentary> commentaries) {
		this.publishedCommentaries = commentaries;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return this.likes;
	}

	public String getCreationDate(){
		return this.creationDate;
	}

	public void setCreationDate(String creationDate){
		this.creationDate = creationDate;
	}

}