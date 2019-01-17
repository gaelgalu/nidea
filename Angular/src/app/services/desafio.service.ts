import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import Desafio from "../models/desafio.model";

@Injectable({
  providedIn: 'root'
})
export default class DesafioService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
  	return this.http.get('//localhost:8090/desafios');
  }

  searchByTag(tag:string): Observable<any>{
  	return this.http.post<string>('localhost:8090/desafios/filter', {params: {tag:tag}});
  }

  searchByTitle(title: string): Observable<any>{
    return this.http.post<string>('localhost:8090/desafios/search', {params: {title:title}});
  }

  addDesafio(desafio: Desafio): Observable<any>{
    return this.http.post<Desafio>('http://localhost:8090/desafios/create', desafio);
  }
}
