import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import Collaborator from "../models/collaborator.model";

@Injectable({
  providedIn: 'root'
})
export class CollaboratorService {

  constructor(private http: HttpClient ) { }

  getAll(): Observable<any> {
    return this.http.get('/api/collaborators');
  }

  getById(id: string): Observable<Collaborator>{
    return this.http.get<Collaborator>('/api/collaborators/'+id);
  }

}
