import {Component, Input, OnInit} from '@angular/core';
import Idea from "../models/idea.model";
import Desafio from "../models/desafio.model";
import Collaborator from "../models/collaborator.model";
import {CollaboratorService} from "../services/collaborator.service";

@Component({
  selector: 'app-desafio-body',
  templateUrl: './desafio-body.component.html',
  styleUrls: ['./desafio-body.component.css']
})
export class DesafioBodyComponent implements OnInit {
  @Input() desafioInput: Desafio;
  collaborator: Collaborator;
  constructor(private collaboratorService: CollaboratorService) {
  }

  ngOnInit() {
    this.getCollaborators();
  }

  getCollaborators() {
    this.collaboratorService.getById(this.desafioInput.author).subscribe(collaborator => {
      this.collaborator = collaborator;
    });
  }

}
