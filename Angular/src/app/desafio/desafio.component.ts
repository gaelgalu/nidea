import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import Desafio from "../models/desafio.model";
import DesafioService from "../services/desafio.service";
import {NgbPanelChangeEvent} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-desafio',
  templateUrl: './desafio.component.html',
  styleUrls: ['./desafio.component.css']
})
export class DesafioComponent implements OnInit {
  desafios: Desafio[];

  desafio: Desafio;

  constructor(private desafioService: DesafioService) {
  	this.desafio = new Desafio();
  }

  ngOnInit() {
  	this.getDesafios();
  }

  getDesafios() {
  	this.desafioService.getAll().subscribe(desafios => {
  		this.desafios = desafios
  	});
  }

  save() {
    this.desafio.author = "1";
  	this.desafioService.addDesafio(this.desafio).subscribe((result) =>{
  		if (result._id) {
  			this.getDesafios();
  			alert("Creado con éxito!");
  		} else {
  			alert("Error!");
  		}
  	});
  }

  searchBy(search) {
    if(search.selector == "tag"){
      this.desafioService.searchByTag(search.search).subscribe(desafios => {
        this.desafios = desafios;
        alert("Se han encontrado " + this.desafios.length + " desafíos.");
      });
    }
    else {
      this.desafioService.searchByTitle(search.search).subscribe(desafios => {
        this.desafios = desafios;
        alert("Se han encontrado " + this.desafios.length + " desafíos.");
      });
    }
  }

  ngAfterViewInit(){

  }
}
