import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IdeaComponent} from './idea/idea.component';
import { DesafioComponent} from './desafio/desafio.component';
import { FullComponent } from './layouts/full/full.component';

export const Approutes: Routes = [
  {
    path: '',
    component: FullComponent,
    children: [
      { path: '', redirectTo: '/starter', pathMatch: 'full' },
      {
        path: 'starter',
        loadChildren: './starter/starter.module#StarterModule'
      },
      {
        path: 'component',
        loadChildren: './component/component.module#ComponentsModule'
      },
      { 
        path: 'idea/:id',
        component: IdeaComponent
      },
      {
        path: 'desafios',
        component: DesafioComponent
      }
    ]
  }
  // },
  // {
  //   path: '**',
  //   redirectTo: '/starter'
  // }
];
