import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CollaboratorService {

  constructor(private http: HttpClient ) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8090/collaborators');
  }

  getById(id: string): Observable<any>{
    return this.http.get('localhost:8090/collaborators/',{params: {id:id}});
  }

}
