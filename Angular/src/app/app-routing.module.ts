import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {VistaListComponent} from "./vista-list/vista-list.component";
import {IdeaListComponent} from "./idea-list/idea-list.component";
import {CollaboratorListComponent} from "./collaborator-list/collaborator-list.component";
import {AddIdeaComponent} from "./add-idea/add-idea.component";

const routes: Routes = [
  {
    path: 'vista',
    component: VistaListComponent,
  },
  {
    path: 'agregarIdea',
    component: AddIdeaComponent
  },
  {
    path: 'colaboradores',
    component: CollaboratorListComponent
  },
  {
    path: '**', redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
