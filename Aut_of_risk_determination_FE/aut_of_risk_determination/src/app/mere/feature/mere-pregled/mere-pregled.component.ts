import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit, ViewChild, AfterViewInit, ElementRef } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Mera } from 'src/app/model/Mera';
import { MereService } from '../../data-service/mere.service';
import { KinneyIndexService } from 'src/app/shared/kinney-index/data-access/kinney-index.service';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-mere-pregled',
  templateUrl: './mere-pregled.component.html',
  styleUrls: ['./mere-pregled.component.css'],
  animations: [
    trigger('fadeInFromRight', [
      transition(':enter', [
        style({ transform: 'translateX(100%)', opacity: 0 }),
        animate('300ms ease-out', style({ transform: 'translateX(0)', opacity: 1 }))
      ])
    ])
  ]
})

export class MerePregledComponent implements OnInit, AfterViewInit {
  riskMeasurements: Mera[] = [];
  riskMeasurementsFiltered: Mera[] = [];

  displayedColumns: string[] = ['code', 'value', 'description', 'measurementFreq'];
  dataSource = new MatTableDataSource(this.riskMeasurements);
  show: boolean = true;

  target: string = "";
  found: boolean = false;
  data: string = "";
  dataFound: boolean = false;

  viewTable : boolean = true;
  showData: boolean = false;
  result: string = "";
  results: string[] = [];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild('cellRef', {static: false}) cellRef: ElementRef;

  constructor(
    private mereService: MereService,
    private kinneyIndexService: KinneyIndexService
  ) {

  }


  ngOnInit(): void {
    this.getAllRiskRemovalMeasurements();
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    setTimeout(() => {
      const rows = document.querySelectorAll('.riskValue');
      
      rows.forEach(row => {
        const rowValue = Number(row.textContent);
        const result = this.kinneyIndexService.calculateRang(rowValue);
        this.results.push(result);
      });      
      
    }, 100);

  }

  getAllRiskRemovalMeasurements() {
    this.mereService.getAllMere().subscribe(response => {
      this.riskMeasurements = Object.values(response);
      this.riskMeasurementsFiltered = Object.values(response);
      this.dataSource.data = this.dataSource.data.concat(this.riskMeasurements.slice(0, 1000));
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
    this.getAllRiskRemovalMeasurements();
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

  generateExcel() {
    let element = document.getElementById("mereTable") as HTMLTableElement;

    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    // Add header row style
    ws["!cols"] = [
      { width: 8 },
      { width: 10 },
      { width: 50 },
      { width: 20 }
    ];

    ws['A1'] = {v: "Rb. / šifra"};

    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'MereZaSprečavanjeRizikaSheet');

    XLSX.writeFile(wb, 'MereZaSprečavanjeRizika.xlsx');

    
  }

}