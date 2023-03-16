import { Component } from '@angular/core';

@Component({
  selector: 'app-container-big',
  template: `
    <div class="container-big">
      <ng-content></ng-content>
    </div>
  `,
  styles: [`
    .container-big {
      width: 60%;
      margin: auto;
    }
  `]
})
export class ContainerBigComponent{
  constructor() { }

}