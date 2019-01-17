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
    return this.http.get('//localhost:8090/ideas');
  }

  searchIdea(id: string): Observable<any>{
    return this.http.get('http://localhost:8090/ideas/'+id);
  }

  searchByTag(tag: string): Observable<any>{
    return this.http.get('localhost:8090/ideas/filter',{params: {tag:tag}});
  }

  searchByTitle(title: string): Observable<any>{
    return this.http.get('localhost:8090/ideas/search',{params: {title:title}});
  }

  public addIdea(idea: Idea): Observable<any>{
    return this.http.post<Idea>('http://localhost:8090/ideas/create', idea);
  }

  addComment(comment: Comment){
    this.http.post<Comment>('localhost:8090/ideas/comment',comment);
  }
}
