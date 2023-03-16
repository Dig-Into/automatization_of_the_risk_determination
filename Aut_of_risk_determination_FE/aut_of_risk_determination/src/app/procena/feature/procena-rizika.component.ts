import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { EffectService } from '../data-access/effect/effect.service';
import { FrequencyService } from '../data-access/frequency/frequency.service';
import { ProbabilityService } from '../data-access/probability/probability.service';
import { DangerNameService } from '../data-access/danger-name/danger-name.service';
import { DangerDetailsService } from '../data-access/danger-details/danger-details.service';

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
    this.selectedItem1 = this.probabilities.find(item => item.id === Number(itemId));
  }
  onSelect2(target: EventTarget) {
    const selectElement = target as HTMLSelectElement;
    const itemId = Number(selectElement.value);
    this.selectedItem2 = this.effects.find(item => item.id === Number(itemId));
  }
  onSelect3(target: EventTarget) {
    const selectElement = target as HTMLSelectElement;
    const itemId = Number(selectElement.value);
    this.selectedItem3 = this.frequencies.find(item => item.id === Number(itemId));
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

    descriptions.forEach(desc => {
      this.descriptionArray.push(desc["value"]);
      
    });
    
    var value = 54; // calculate Kinney Index instead of this hard-coded value

    var dangerDetails = {
        id: 0,
        code: selectedDangerName,
        value: value,
        descriptions: this.descriptionArray,
        probability: {
          id: selectedProbability,
        },
        effect: {
          id: selectedEffect,
        },
        frequency: {
          id: selectedFrequency,
        },
        dangerName: {
          id: selectedDangerName,
        }
    };

    this.dangerDetailsService.createDangerDetails(dangerDetails).subscribe(response => {
      console.log("Created successfully");
    
    })
    
  }
}