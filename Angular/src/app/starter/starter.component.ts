import { Component, AfterViewInit } from '@angular/core';
import {Observable} from "rxjs";
import Idea from '../models/idea.model';
import IdeaService from '../services/idea.service';

@Component({
  templateUrl: './starter.component.html'
})
export class StarterComponent implements AfterViewInit {
  subtitle: string;

  ideas: Idea[];

  idea: Idea;
  
  constructor(private ideaService: IdeaService) {
    this.subtitle = 'This is some text within a card block.';
    this.idea = new Idea();
  }

  ngOnInit() {
  	this.ideaService.getAll().subscribe(ideas => {
  		this.ideas = ideas
  	});
  }

  ngAfterViewInit() {}

  save() {
  	this.ideaService.addIdea(this.idea).subscribe((result) => {
  		alert(result);
  	});
  }
}
