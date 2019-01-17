import {AfterViewInit, Component, OnInit} from '@angular/core';
import { NgbPanelChangeEvent } from '@ng-bootstrap/ng-bootstrap';
import IdeaService from '../services/idea.service';
import Idea from '../models/idea.model';
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
@Component({
  templateUrl: 'idea.component.html'
})

export class IdeaComponent implements AfterViewInit{
  idea: Idea;
  ideas : Idea[];
  idea2: Idea;
  _id: string;
  ngOnInit(){
    this.obtenerIdea(this._id);
  }
  constructor(private route: ActivatedRoute, private ideaService: IdeaService){
    this._id= this.route.snapshot.paramMap.get('id');
    this.idea2 = new Idea();
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
