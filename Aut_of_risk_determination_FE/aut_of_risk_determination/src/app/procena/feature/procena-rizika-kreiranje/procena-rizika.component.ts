import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { EffectService } from '../../data-access/effect/effect.service';
import { FrequencyService } from '../../data-access/frequency/frequency.service';
import { ProbabilityService } from '../../data-access/probability/probability.service';
import { DangerNameService } from '../../data-access/danger-name/danger-name.service';
import { DangerDetailsService } from '../../data-access/danger-details/danger-details.service';

@Component({
  selector: 'app-procena-rizika-kreiranje',
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

export class ProcenaRizikaComponent implements OnInit {
  inputs: string[] = [''];
  showAnotherComponent = false;
  fadeState = '';
  probabilities: any;
  effects: any;
  frequencies: any;
  dangerNames: any;
  selectedItem1: any;
  selectedItem2: any;
  selectedItem3: any;
  descriptionArray = [];
  field1: number;
  field2: number;
  field3: number;
  probabilityId: number;
  effectId: number;
  frequencyId: number;

  constructor(
    private probabilityService: ProbabilityService,
    private frequencyService: FrequencyService,
    private effectService: EffectService,
    private dangerNameService: DangerNameService,
    private dangerDetailsService: DangerDetailsService
    ) {}

  ngOnInit(): void {
      this.loadProbabilities();
      this.loadFrequencies();
      this.loadEffects();
      this.loadDangerNames();
  }

  onSelect1(target: EventTarget) {
    const selectElement = target as HTMLSelectElement;
    const itemId = Number(selectElement.value);
    this.selectedItem1 = this.probabilities.find(item => item.code === Number(itemId));
  }
  onSelect2(target: EventTarget) {
    const selectElement = target as HTMLSelectElement;
    const itemId = Number(selectElement.value);
    this.selectedItem2 = this.effects.find(item => item.code === Number(itemId));
  }
  onSelect3(target: EventTarget) {
    const selectElement = target as HTMLSelectElement;
    const itemId = Number(selectElement.value);
    this.selectedItem3 = this.frequencies.find(item => item.code === Number(itemId));
  }

  loadProbabilities() {
    this.probabilityService.getAllProbabilities().subscribe(response => {
      this.probabilities = response;
    })
  }

  loadFrequencies() {
    this.frequencyService.getAllFrequencies().subscribe(response => {
      this.frequencies = response;
    })
  }

  loadEffects() {
    this.effectService.getAllEffects().subscribe(response => {
      this.effects = response;
    })
  }

  loadDangerNames() {
    this.dangerNameService.getAllDangerNames().subscribe(response => {
      this.dangerNames = response;
    })
  }

  addInput() {
    this.inputs.push('');
  }

  create() {
    var selectedDangerName = document.getElementById("opasnost-dropdown")["value"];
    var selectedProbability = document.getElementById("p-dropdown")["value"]; 
    var selectedEffect = document.getElementById("e-dropdown")["value"];
    var selectedFrequency = document.getElementById("f-dropdown")["value"];
    var descriptions = Array.from(document.querySelectorAll(".details"));

    this.probabilityService.getProbabilityByCode(selectedProbability).subscribe(response => {
      this.probabilityId = response["id"];

      this.effectService.getEffectByCode(selectedEffect).subscribe(response => {
        this.effectId = response["id"];

        this.frequencyService.getFrequencyByCode(selectedFrequency).subscribe(response => {
          this.frequencyId = response["id"];
        
          descriptions.forEach(desc => {
            this.descriptionArray.push(desc["value"]);
            
          });

          var value = this.getResult();
          var dangerDetails = {
              id: 0,
              code: selectedDangerName,
              value: value,
              descriptions: this.descriptionArray,
              probability: {
                id: this.probabilityId,
              },
              effect: {
                id: this.effectId,
              },
              frequency: {
                id: this.frequencyId,
              },
              dangerName: {
                id: selectedDangerName,
              }
          };

          this.dangerDetailsService.createDangerDetails(dangerDetails).subscribe(response => {
            console.log("Created successfully");
          
          })
        
        });
      
      });
    
    });

  }

  getResultClass() {        
    const result = Number(this.field1) * Number(this.field2) * Number(this.field3);
  
    if (result <= 70) {
      return 'green-background';
    } else if (result <= 200) {
      return 'yellow-background';
    } else {
      return 'red-background';
    }
  }

  getResult(): number {
    const result = Number(this.field1) * Number(this.field2) * Number(this.field3);
    const roundedResult = parseFloat(result.toFixed(2));
    return roundedResult;
  }

}