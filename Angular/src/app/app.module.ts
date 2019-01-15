import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { CollaboratorListComponent } from './collaborator-list/collaborator-list.component';
import { IdeaListComponent } from './idea-list/idea-list.component';
import { AddIdeaComponent } from './add-idea/add-idea.component';
import {FormsModule} from "@angular/forms";
import { VistaListComponent } from './vista-list/vista-list.component';
const appRoute: Routes=[
  {
    path: 'vista',
    component: VistaListComponent,
    pathMatch: 'full'
  },
  {
    path: 'agregarIdea',
    component: IdeaListComponent,
    pathMatch: 'full'
  },
  {
    path: 'colaboradores',
    component: CollaboratorListComponent,
    pathMatch: 'full'
  }
];
@NgModule({
  declarations: [
    AppComponent,
    CollaboratorListComponent,
    IdeaListComponent,
    AddIdeaComponent,
    VistaListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
