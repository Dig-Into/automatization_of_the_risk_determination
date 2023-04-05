import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-container',
  template: `
    <div class="container">
      <ng-content></ng-content>
    </div>
  `,
  styles: [`
    .container {
      width: 80%;
      margin: auto;
      display: flex;
    }
  `]
})
export class ContainerComponent implements OnInit {
  constructor() { }

  ngOnInit() { }
}