import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { CollaboratorListComponent } from './collaborator-list/collaborator-list.component';
import { IdeaListComponent } from './idea-list/idea-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CollaboratorListComponent,
    IdeaListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
