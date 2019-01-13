import { Component, OnInit } from '@angular/core';
import {Idea} from "../shared/idea/idea.model";
import {Router} from "@angular/router";
import {IdeaService} from "../shared/idea/idea.service";

@Component({
  selector: 'app-add-idea',
  templateUrl: './add-idea.component.html',
  styleUrls: ['./add-idea.component.css']
})
export class AddIdeaComponent implements OnInit {

  idea: Idea = new Idea();
  constructor(private router: Router, private ideaService: IdeaService) { }

  createIdea(): void {
    this.ideaService.createUser(this.idea)
      .subscribe(data => {
        alert("Idea created successfully.");
      });
  };

  ngOnInit(): void {
  }
}
