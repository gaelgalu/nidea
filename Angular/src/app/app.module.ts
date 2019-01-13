import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { CollaboratorListComponent } from './collaborator-list/collaborator-list.component';
import { IdeaListComponent } from './idea-list/idea-list.component';
import { AddIdeaComponent } from './add-idea/add-idea.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    CollaboratorListComponent,
    IdeaListComponent,
    AddIdeaComponent
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
