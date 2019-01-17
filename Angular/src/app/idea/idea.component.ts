import {AfterViewInit, Component, OnInit} from '@angular/core';
import { NgbPanelChangeEvent } from '@ng-bootstrap/ng-bootstrap';
import IdeaService from '../services/idea.service';
import Idea from '../models/idea.model';
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
import {CollaboratorService} from "../services/collaborator.service";
import Collaborator from "../models/collaborator.model";
@Component({
  templateUrl: 'idea.component.html'
})

export class IdeaComponent implements AfterViewInit{
  idea: Idea;
  _id: string;
  collaborator: Collaborator;
  ngOnInit(){
  }
  constructor(private route: ActivatedRoute, private ideaService: IdeaService, private collaboratorService: CollaboratorService){
    this.obtenerIdea(this.route.snapshot.paramMap.get('id'));
  }
  obtenerIdea(id: string){
    this.ideaService.searchIdea(id).subscribe(idea=>{
      this.idea = idea;
      this.getCollaborators();
    });
  }
  beforeChange($event: NgbPanelChangeEvent) {
    if ($event.panelId === 'preventchange-2') {
      $event.preventDefault();
    }

    if ($event.panelId === 'preventchange-3' && $event.nextState === false) {
      $event.preventDefault();
    }
  }

  getCollaborators() {
    this.collaboratorService.getById(this.idea.author).subscribe(collaborator => {
      this.collaborator = collaborator;
    });
  }

  ngAfterViewInit(){

  }
}




// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-idea',
//   templateUrl: './idea.component.html'
// })
// export class IdeaComponent implements OnInit {

//   constructor() { }

//   ngOnInit() {
//   }

// }
