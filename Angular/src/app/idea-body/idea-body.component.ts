import {Component, Input, OnInit} from '@angular/core';
import {CollaboratorService} from "../services/collaborator.service";
import Idea from "../models/idea.model";
import Collaborator from "../models/collaborator.model";

@Component({
  selector: 'app-idea-body',
  templateUrl: './idea-body.component.html',
  styleUrls: ['./idea-body.component.css'],
})
export class IdeaBodyComponent implements OnInit {
  @Input() ideaInput: Idea;
  collaborator: Collaborator;
  constructor(private collaboratorService: CollaboratorService) {
  }

  ngOnInit() {
    this.getCollaborators();
  }

  getCollaborators() {
    this.collaboratorService.getById(this.ideaInput.author).subscribe(collaborator => {
      this.collaborator = collaborator;
    });
  }
}
