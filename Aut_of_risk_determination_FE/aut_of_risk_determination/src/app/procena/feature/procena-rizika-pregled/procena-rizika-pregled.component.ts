import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit, ViewChild, AfterViewInit, ElementRef } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { DangerDetails } from 'src/app/model/DangerDetails';
import { DangerDetailsService } from '../../data-access/danger-details/danger-details.service';
import { KinneyIndexService } from 'src/app/shared/kinney-index/data-access/kinney-index.service';
import * as XLSX from 'xlsx';

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
  results: string[] = [];
  workplace: string = "";
 
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
      const rows = document.querySelectorAll('.riskValue');
      
      rows.forEach(row => {
        const rowValue = Number(row.textContent);
        const result = this.kinneyIndexService.calculateRang(rowValue);
        this.results.push(result);
      });      
      
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

  openModal() {
    document.getElementById('my-modal').style.display = 'block';
  }

  openRadnoMestoModal() {
    document.getElementById('my-radno-mesto-modal').style.display = 'block';
  }
  
  closeModal() {
    document.getElementById('my-modal').style.display = 'none';
  }

  closeRadnoMestoModal() {
    document.getElementById('my-radno-mesto-modal').style.display = 'none';
  }



  generateExcel() {
    let element = document.getElementById("procenaRizikaTable") as HTMLTableElement;

    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    // Add header row style
    ws["!cols"] = [
      { width: 8 },
      { width: 35 },
      { width: 13 },
      { width: 11 },
      { width: 12 },
      { width: 10 }
    ];

    // Modify each row to extract numerical values from columns C, D, and E
    for (let i = 2; i <= element.rows.length; i++) {
      const row = element.rows[i - 1];
      const cValue = row.cells[2].innerText.split(" ")[0]; // Extract numerical value from column C
      const dValue = row.cells[3].innerText.split(" ")[0]; // Extract numerical value from column D
      const eValue = row.cells[4].innerText.split(" ")[0]; // Extract numerical value from column E
      ws[`C${i}`] = { v: Number(cValue) }; // Assign numerical value to column C cell
      ws[`D${i}`] = { v: Number(dValue) }; // Assign numerical value to column D cell
      ws[`E${i}`] = { v: Number(eValue) }; // Assign numerical value to column E cell
        
    }

    ws['A1'] = {v: "Rb. / šifra"};
    ws['B1'] = {v: "Grupa, vrsta i opis opasnosti i štetnosti"}

    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'ProcenaRizikaSheet');

    XLSX.writeFile(wb, 'ProcenaRizika.xlsx');

  }

  generateExcel2() {
    let element = document.getElementById("procenaRizikaTable") as HTMLTableElement;
    let workplace = document.getElementById("danger-description")["value"];

    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    // Add header row style
    ws["!cols"] = [
      { width: 8 },
      { width: 35 },
      { width: 13 },
      { width: 11 },
      { width: 12 },
      { width: 10 }
    ];

    // Modify each row to extract numerical values from columns C, D, and E
    for (let i = 2; i <= element.rows.length; i++) {
      const row = element.rows[i - 1];
      const cValue = row.cells[2].innerText.split(" ")[0]; // Extract numerical value from column C
      const dValue = row.cells[3].innerText.split(" ")[0]; // Extract numerical value from column D
      const eValue = row.cells[4].innerText.split(" ")[0]; // Extract numerical value from column E
      ws[`C${i}`] = { v: Number(cValue) }; // Assign numerical value to column C cell
      ws[`D${i}`] = { v: Number(dValue) }; // Assign numerical value to column D cell
      ws[`E${i}`] = { v: Number(eValue) }; // Assign numerical value to column E cell
        
    }

    ws['A1'] = {v: "Rb. / šifra"};
    ws['B1'] = {v: "Grupa, vrsta i opis opasnosti i štetnosti"}

    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'ProcenaRizikaSheet');

    XLSX.writeFile(wb, workplace + '_ProcenaRizika.xlsx');

  }
  
}