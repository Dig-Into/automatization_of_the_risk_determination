import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { DangerDetails } from 'src/app/model/DangerDetails';
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
  dangerDetails: DangerDetails[] = [];
  dangerDetailsFiltered: DangerDetails[] = [];

  displayedColumns: string[] = ['code', 'descriptions', 'probability', 'effect', 'frequency', 'value'];
  dataSource = new MatTableDataSource(this.dangerDetails);
  show: boolean = true;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private dangerDetailsService: DangerDetailsService
  ) {

  }

  ngOnInit(): void {
    this.getAllDangerDetails();
  }

  getAllDangerDetails() {
    this.dangerDetailsService.getAllDangerDetails().subscribe(response => {
      this.dangerDetails = Object.values(response);
      this.dangerDetailsFiltered = Object.values(response);
      this.dataSource.data = this.dataSource.data.concat(this.dangerDetails.slice(0, 1000));
      this.paginator._changePageSize(this.paginator.pageSize);
  
    });
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}