package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;


public class Collaborator implements Model {
  @Id
  public String _id;
  
  private String name;
  private String lastname;
  // private Date bornDate;
  // private Date registerDate;
  private String email;

  private String password;
  // private String phone;
  // private String adress;
  // private int approvedIdeas;
  // private int likes;
  // private int state;
  @DBRef
  public ArrayList<Idea> publishedIdeas;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors
  public Collaborator(String _id, String name, String lastname, String email, String password, ArrayList<Idea> publishedIdeas) {
    this._id = _id;
    this.name = name;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
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