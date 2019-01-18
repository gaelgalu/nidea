import {Component, Input, OnInit} from '@angular/core';
import {CollaboratorService} from "../services/collaborator.service";
import Collaborator from "../models/collaborator.model";
import {Comment} from "../models/comment.model";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],

})
export class CommentComponent implements OnInit {
  @Input() commentInput: Comment;
  collaborator: Collaborator;
  constructor(private collaboratorService: CollaboratorService) {
    this.collaborator= new Collaborator();
  }

  ngOnInit() {
    this.getCollaborators();
  }

  getCollaborators() {
    this.collaboratorService.getById(this.commentInput.author).subscribe(collaborator => {
      this.collaborator = collaborator;
    });
  }
}
