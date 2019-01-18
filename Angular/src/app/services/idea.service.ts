import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaderResponse, HttpHeaders, HttpParams} from "@angular/common/http";
import Idea from "../models/idea.model";

@Injectable({
  providedIn: 'root'
})
export default class IdeaService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get('/api/ideas');
  }

  searchIdea(id: string): Observable<any> {
    return this.http.get('/api/ideas/' + id);
  }

  searchByTag(tag: string): Observable<any>{
    return this.http.post<string>('/api/ideas/filter',{params: {tag:tag}});
  }

  searchByTitle(title: string): Observable<any>{
    return this.http.post<string>('/api/ideas/search',{params: {title:title}});
  }

  addIdea(idea: Idea): Observable<any>{
    return this.http.post<Idea>('/api/ideas/create', idea);
  }

  addComment(comment: Comment){
    this.http.post<Comment>('/api/ideas/comment',comment);
  }
}
