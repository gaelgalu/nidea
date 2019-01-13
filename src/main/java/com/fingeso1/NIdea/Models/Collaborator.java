package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;


public class Collaborator {
  @Id
  public String _id;
  
  public String name;
  public String lastname;
  // public Date bornDate;
  // public Date registerDate;
  public String email;
  // public String password;
  // public String phone;
  // public String adress;
  // public int approvedIdeas;
  // public int likes;
  // public int state;
  @DBRef
  public ArrayList<Idea> publishedIdeas;


  
  // Constructors
  public Collaborator(String name, String lastname, String email, ArrayList<Idea> publishedIdeas) {
    this.name = name;
    this.lastname = lastname;
    this.email = email;
    this.publishedIdeas = publishedIdeas;
  }
  
  public String get_id() {
  	return _id; 
  }

  public void set_id(String _id) { 
  	this._id = _id; 
  }
  
  public String getName() { 
  	return this.name; 
  }
  public void setName(String name) { 
  	this.name = name; 
  }
  
  public String getLastname() { 
  	return lastname; 
  }
  public void setLastname(String lastname) {
    this.lastname = lastname; 
 }
  
  public String getEmail() { 
  	return this.email; 
  }
  public void setEmail(String email) { 
  	this.email = email; 
  }

  public ArrayList<Idea> getPublishedIdeas(){
    return this.publishedIdeas;
  }

  public void setPublishedIdeas(ArrayList<Idea> ideas){
    this.publishedIdeas = publishedIdeas;
  }

  public void addIdea(Idea idea){
    this.publishedIdeas.add(idea);
  }
}