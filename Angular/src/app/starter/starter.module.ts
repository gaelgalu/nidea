import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { StarterComponent } from './starter.component';
import {IdeaBodyComponent} from "../idea-body/idea-body.component";

const routes: Routes = [
  {
    path: '',
    data: [{
      title: 'Ideas',
      urls: [
        { title: 'Dashboard', url: '/dashboard' },
        { title: 'Ideas' }
      ]
    },
      {
        title: 'Idea',
        urls: [
          {title: 'Dashboard', url: '/dashboard'},
          {title: 'Ideas', url: '/dashboard'},
          {title: 'Idea'}
        ]
      }
    ],
    component: StarterComponent
  }
];

@NgModule({
  imports: [FormsModule, CommonModule, RouterModule.forChild(routes)],
  declarations: [StarterComponent, IdeaBodyComponent ]
})
export class StarterModule {}
