import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaderResponse, HttpHeaders, HttpParams} from "@angular/common/http";
import Idea from "../models/idea.model";
import {Comment} from "../models/comment.model";
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
    const body = new HttpParams()
    .set('tag', tag);

    return this.http.post<string>('/api/ideas/filter', body.toString(),
      {
        headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
      });
    // return this.http.get('/api/ideas/filter' + tag);
  }

  searchByTitle(title: string): Observable<any>{
    const body = new HttpParams()
    .set('title', title);

    return this.http.post<string>('/api/ideas/search', body.toString(),
      {
        headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
      });
    // return this.http.get('/api/ideas/search' + title);
  }

  addIdea(idea: Idea): Observable<any>{
    return this.http.post<Idea>('/api/ideas/create', idea);
  }

  addComment(comment: Comment): Observable<any>{
    return this.http.post<Comment>('/api/ideas/comment',comment);
  }

  like(id: string, author: string): Observable<any>{
    return this.http.post<any>('/api/ideas/like/'+id+'/'+author,{});
  }
}
