import {AfterViewInit, Component, OnInit} from '@angular/core';
import { NgbPanelChangeEvent } from '@ng-bootstrap/ng-bootstrap';
import IdeaService from '../services/idea.service';
import Idea from '../models/idea.model';
import {ActivatedRoute} from "@angular/router";
import {Comment} from "../models/comment.model";
import {CollaboratorService} from "../services/collaborator.service";
import Collaborator from "../models/collaborator.model";
@Component({
  templateUrl: 'idea.component.html'
})

export class IdeaComponent implements AfterViewInit{
  idea: Idea;
  _id: string;
  collaborator: Collaborator;
  comment: Comment;
  ngOnInit(){
  }
  constructor(private route: ActivatedRoute, private ideaService: IdeaService, private collaboratorService: CollaboratorService){
    this.obtenerIdea(this.route.snapshot.paramMap.get('id'));
    this.comment = new Comment();
  }
  getComment(){/*
    while(ca<this.idea2.publishedComment.length)
    this.comment = this.idea2.publishedComment;*/
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

  save() {
    this.comment.idea = this.idea._id;
    this.comment.author = "1";
    this.ideaService.addComment(this.comment).subscribe((result) => {
      if (result) {
        alert("Creado con exito");
        location.reload();
      } else {
        alert("Error");
      }
    });
  }

  like(){
    this.ideaService.like(this.idea._id, "1");
    location.reload();
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
