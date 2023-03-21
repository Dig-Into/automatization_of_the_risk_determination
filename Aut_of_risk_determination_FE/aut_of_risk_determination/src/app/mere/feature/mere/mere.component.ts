import { Component, OnInit } from '@angular/core';
import { DangerNameService } from 'src/app/procena/data-access/danger-name/danger-name.service';
import { DangerDetailsService } from 'src/app/procena/data-access/danger-details/danger-details.service';
import { MereService } from '../../data-service/mere.service';

@Component({
  selector: 'app-mere',
  templateUrl: './mere.component.html',
  styleUrls: ['./mere.component.css']
})


export class MereComponent {
  mere: any;
  dangers: any;
  rokovi: any;

  constructor(
    private mereService: MereService,
    private dangerNameService: DangerNameService,
    private dangerDetailsService: DangerDetailsService
    ) {}

  ngOnInit() {
    this.rokovi = [
    {
      id: '1',
      description: 'Stalno'
    },
    {
      id: '2',
      description: 'Povremeno'
    },
    {
      id: '3',
      description: 'Nikad'
    },
  ]
    
    this.getAllDangerDetails();
  
  }


  addItem() {
    var dangerNumber = document.getElementById("danger-number")["value"]
    var measurementImplFreq = document.getElementById("rok-dropdown")["value"];
    var description = document.getElementById("opis")["value"];

    this.dangerNameService.getDangerNameByDangerNumber(dangerNumber).subscribe(response => {
      var dangerCode = response["id"];
      
      
      this.dangerDetailsService.getDangerDetailsByCode(dangerCode).subscribe(response => {
        var riskRemovalMeasurement = {
          id: 0,
          riskFactorValue: response["value"],
          description: description,
          measurementImplFreq: measurementImplFreq,
          dangerDetails: {
            id: response["id"]
        }
      };
        
        
        this.mereService.createMere(riskRemovalMeasurement).subscribe(response => {
          console.log("Created successfully");
          
        });
        
      });
      
    });
    

   
    
  }

  getAllDangerDetails() {
    this.dangerDetailsService.getAllDangerDetails().subscribe(response => {
      this.dangers = response;
    })
  }

}