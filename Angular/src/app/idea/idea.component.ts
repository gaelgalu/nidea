import {AfterViewInit, Component, OnInit} from '@angular/core';
import { NgbPanelChangeEvent } from '@ng-bootstrap/ng-bootstrap';
import IdeaService from '../services/idea.service';
import Idea from '../models/idea.model';
import {ActivatedRoute} from "@angular/router";
import Comment from '../models/comment.model';
import {CollaboratorService} from "../services/collaborator.service";
import Collaborator from "../models/collaborator.model";
@Component({
  templateUrl: 'idea.component.html'
})

export class IdeaComponent implements AfterViewInit{
  idea2: Idea;
  _id: string;
  comment: Comment[];
  ca: number;
  ngOnInit(){
    this.obtenerIdea(this._id);
    this.getComment();
  }
  constructor(private route: ActivatedRoute, private ideaService: IdeaService, private collabService: CollaboratorService){
    this._id= this.route.snapshot.paramMap.get('id');
    this.idea2 = new Idea();
  }
  getComment(){/*
    while(ca<this.idea2.publishedComment.length)
    this.comment = this.idea2.publishedComment;*/
  }
  obtenerIdea(id: string){
    this.ideaService.searchIdea(id).subscribe(idea2=>{
      this.idea2 = idea2
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
