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
  	this.getIdeas();
  }
  getIdeas() {
	this.ideaService.getAll().subscribe(ideas => {
		this.ideas = ideas
	});
  }

  save() {
    this.idea.author = "1";
  	this.ideaService.addIdea(this.idea).subscribe((result) => {
  		if (result._id) {
  			this.getIdeas();
  			alert("Creado con exito");
  		} else {
  			alert("Error");
  		}
  	});
  }

  searchBy(search) {
    if(search.selector == "tag"){
      this.ideaService.searchByTag(search.search).subscribe(ideas => {
        this.ideas = ideas;
        alert("Se han encontrado " + this.ideas.length + " ideas.");
      });
    }
    else {
      this.ideaService.searchByTitle(search.search).subscribe(ideas => {
        this.ideas = ideas;
        alert("Se han encontrado " + this.ideas.length + " ideas.");
      });
    }
  }

  ngAfterViewInit() {
  	
  }
}
