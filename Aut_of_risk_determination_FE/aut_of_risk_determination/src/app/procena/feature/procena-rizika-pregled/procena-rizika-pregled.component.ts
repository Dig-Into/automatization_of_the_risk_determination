import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit, ViewChild, AfterViewInit, ElementRef } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { DangerDetails } from 'src/app/model/DangerDetails';
import { DangerDetailsService } from '../../data-access/danger-details/danger-details.service';
import { KinneyIndexService } from 'src/app/shared/kinney-index/data-access/kinney-index.service';

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

export class ProcenaRizikaPregledComponent implements OnInit, AfterViewInit {
  dangerDetails: DangerDetails[] = [];
  dangerDetailsFiltered: DangerDetails[] = [];

  displayedColumns: string[] = ['code', 'descriptions', 'probability', 'effect', 'frequency', 'value'];
  dataSource = new MatTableDataSource(this.dangerDetails);
  show: boolean = true;

  target: string = "";
  found: boolean = false;
  data: string = "";
  dataFound: boolean = false;

  viewTable : boolean = true;
  showData: boolean = false;
  result: string = "";

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild('cellRef', {static: false}) cellRef: ElementRef;

  constructor(
    private dangerDetailsService: DangerDetailsService,
    private kinneyIndexService: KinneyIndexService
  ) {

  }

  ngOnInit(): void {
    this.getAllDangerDetails();
    
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    setTimeout(() => {
      const value = this.cellRef.nativeElement.innerText;
      this.result = this.kinneyIndexService.calculateRang(value);
    }, 100);
    

  }

  getAllDangerDetails() {
    this.dangerDetailsService.getAllDangerDetails().subscribe(response => {
      this.dangerDetails = Object.values(response);
      this.dangerDetailsFiltered = Object.values(response);
      this.dataSource.data = this.dataSource.data.concat(this.dangerDetails.slice(0, 1000));
      this.paginator._changePageSize(this.paginator.pageSize);
  
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  reset() {
    this.target = "";
    this.emptyTable();
    this.getAllDangerDetails();
  }

  emptyTable() {
    this.dataSource.data = [];
    this.paginator._changePageSize(this.paginator.pageSize);
  }

  isFound() {
    return this.found;
  }

  getViewTable(){
    return this.viewTable;
  }

  getShowData(){
    return this.showData;
  }

  goBack(){
    this.showData = false;
    this.viewTable = true;
  }


}