import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { DangerDetailsService } from '../../data-access/danger-details/danger-details.service';

@Component({
  selector: 'app-procena-rizika-pregled',
  templateUrl: './procena-rizika-pregled.component.html',
  styleUrls: ['./procena-rizika-pregled.component.css'],
  animations: [
    trigger('fadeInFromRight', [
      transition(':enter', [
        style({ transform: 'translateX(100%)', opacity: 0 }),
        animate('300ms ease-out', style({ transform: 'translateX(0)', opacity: 1 }))
      ])
    ])
  ]
})

export class ProcenaRizikaPregledComponent implements OnInit {
  displayedColumns: string[] = ['#', "šifra", ];


  ngOnInit(): void {
    
  }


  test() {
    alert("You clicked it, didn't you...");
    
  }

}