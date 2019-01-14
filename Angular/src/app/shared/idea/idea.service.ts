import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


import {Idea} from "./idea.model";

@Injectable({
  providedIn: 'root'
})
export class IdeaService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get('//localhost:8090/ideas');
  }

  createUser(idea){
    return this.http.post<Idea>('//localhost:8090/ideas/create', idea);
  }
}
