import { Component, OnInit } from '@angular/core';
import {CollaboratorService} from "../shared/collaborator/collaborator.service";

@Component({
  selector: 'app-collaborator-list',
  templateUrl: './collaborator-list.component.html',
  styleUrls: ['./collaborator-list.component.css']
})
export class CollaboratorListComponent implements OnInit {
  collaborators: Array<any>;

  constructor(private collaboratorService: CollaboratorService) { }

  ngOnInit() {
    this.collaboratorService.getAll().subscribe(data => {
      this.collaborators = data;
    })
  }

}
