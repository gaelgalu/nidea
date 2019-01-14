package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;


public class CollaboratorRequest {
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
  // public ArrayList<Idea> publishedIdeas;


  
  // Constructors
  public CollaboratorRequest(String name, String lastname, String email) {
    this.name = name;
    this.lastname = lastname;
    this.email = email;
  }
  
  public String get_id() {
  	return _id; 
  }
  
  public String getName() { 
  	return this.name; 
  }
  
  public String getLastname() { 
  	return this.lastname; 
  }
  
  public String getEmail() { 
  	return this.email; 
  }
}