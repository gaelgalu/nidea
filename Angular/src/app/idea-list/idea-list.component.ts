import { Component, OnInit } from '@angular/core';
import {IdeaService} from "../shared/idea/idea.service";

@Component({
  selector: 'app-idea-list',
  templateUrl: './idea-list.component.html',
  styleUrls: ['./idea-list.component.css']
})
export class IdeaListComponent implements OnInit {
  ideas: Array<any>;

  constructor(private ideaService: IdeaService) { }

  ngOnInit() {
    this.ideaService.getAll().subscribe( data => {
      this.ideas = data;
    });
  }

}
