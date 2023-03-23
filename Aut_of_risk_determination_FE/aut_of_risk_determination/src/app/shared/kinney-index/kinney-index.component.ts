import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { KinneyIndexService } from './data-access/kinney-index.service';

@Component({
  selector: 'app-kinney-index',
  templateUrl: './kinney-index.component.html',
  styleUrls: ['./kinney-index.component.css']
})
export class KinneyIndexComponent implements OnChanges {
  @Input() result: number;

  rizik: string = "";

  constructor(
    private kinneyIndexService: KinneyIndexService
  ) {

  }

  ngOnChanges(change: SimpleChanges) {
    if ('result' in change) {
      const newResult = change['result'].currentValue;

      this.rizik = this.kinneyIndexService.calculateRang(newResult);

    }
  }
}