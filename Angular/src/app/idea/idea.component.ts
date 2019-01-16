import { Component, OnInit } from '@angular/core';
import { NgbPanelChangeEvent } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-idea',
  templateUrl: 'idea.component.html'
})
export class IdeaComponent {
  beforeChange($event: NgbPanelChangeEvent) {
    if ($event.panelId === 'preventchange-2') {
      $event.preventDefault();
    }

    if ($event.panelId === 'preventchange-3' && $event.nextState === false) {
      $event.preventDefault();
    }
  }
}




// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-idea',
//   templateUrl: './idea.component.html'
// })
// export class IdeaComponent implements OnInit {

//   constructor() { }

//   ngOnInit() {
//   }

// }
