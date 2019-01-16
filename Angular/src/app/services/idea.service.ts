import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Idea} from "../models/idea.model";

@Injectable({
  providedIn: 'root'
})
export class IdeaService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get('//localhost:8090/ideas');
  }

  getById(id: string): Observable<any>{
    return this.http.get('localhost:8090/ideas/',{params: {id:id}});
  }

  searchByTag(tag: string): Observable<any>{
    return this.http.get('localhost:8090/ideas/filter',{params: {tag:tag}});
  }

  searchByTitle(title: string): Observable<any>{
    return this.http.get('localhost:8090/ideas/search',{params: {title:title}});
  }

  addIdea(idea: Idea){
  this.http.post<Idea>('localhost:8090/ideas/create', idea);
  }

  addComment(comment: Comment){
    this.http.post<Comment>('localhost:8090/ideas/comment',comment);
  }
}
