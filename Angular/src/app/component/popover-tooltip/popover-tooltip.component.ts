import { Component, ViewChild, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-ngbd-popover-tooltip',
  templateUrl: './popover-tooltip.component.html',
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .card {
        overflow: hidden;
      }
      .my-custom-class {
        background: aliceblue;
        font-size: 125%;
      }
      .my-custom-class .arrow::after {
        border-top-color: aliceblue;
      }
    `
  ]
})
export class NgbdPopTooltipComponent {
  greeting = {};
  lastShown: Date;
  lastHidden: Date;
  name = 'World';

  @ViewChild('p') public popover;

  public changeGreeting(greeting: any): void {
    const isOpen = this.popover.isOpen();
    this.popover.close();
    if (greeting !== this.greeting || !isOpen) {
      this.greeting = greeting;
      this.popover.open(greeting);
    }
  }

  recordShown() {
    this.lastShown = new Date();
  }

  recordHidden() {
    this.lastHidden = new Date();
  }
}
