import { animate, style, transition, trigger } from '@angular/animations';
import { Component } from '@angular/core';


@Component({
  selector: 'app-procena-rizika',
  templateUrl: './procena-rizika.component.html',
  styleUrls: ['./procena-rizika.component.css'],
  animations: [
    trigger('fadeInFromRight', [
      transition(':enter', [
        style({ transform: 'translateX(100%)', opacity: 0 }),
        animate('300ms ease-out', style({ transform: 'translateX(0)', opacity: 1 }))
      ])
    ])
  ]
})
export class ProcenaRizikaComponent {
  inputs: string[] = [''];
  showAnotherComponent = false;
  fadeState = '';

  addInput() {
    this.inputs.push('');
  }
}
