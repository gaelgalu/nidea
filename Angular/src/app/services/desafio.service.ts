import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import Desafio from "../models/desafio.model";

@Injectable({
  providedIn: 'root'
})
export default class DesafioService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
  	return this.http.get('/api/desafios');
  }

  searchByTag(tag:string): Observable<any>{
  	return this.http.post('/api/desafios/filter', {params: {tag:tag}});
  }

  searchByTitle(title: string): Observable<any>{
    const body = new HttpParams()
    .set('title', title);

    return this.http.post<string>('http://localhost:8090/desafios/search', body.toString(),
      {
        headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
      });
  }

  addDesafio(desafio: Desafio): Observable<any>{
    return this.http.post<Desafio>('http://localhost:8090/desafios/create', desafio);
  }
}
