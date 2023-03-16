import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-kinney-index',
  templateUrl: './kinney-index.component.html',
  styleUrls: ['./kinney-index.component.css']
})
export class KinneyIndexComponent {
  @Input() result: number;
}
