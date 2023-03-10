import { ChangeDetectionStrategy, Component } from '@angular/core';

export interface Tabela1 {
    vrednost: number;
    opis: string;
}

export interface Tabela2 {
    id: number,
    vrednost: string,
    opis: string,
    kinney: string;
}

const ELEMENT_DATA: Tabela1[] = [
    {vrednost: 0.1, opis: 'jedva pojmljivo'},
    {vrednost: 0.2, opis: 'praktično neverovatno'},
    {vrednost: 0.5, opis: 'postoji, ali malo verovatno'},
    {vrednost: 1, opis: 'moguće u ograničenim slučajevima (mala verovatnoća)'},
    {vrednost: 3, opis: 'nije aktuelno, ali je moguće (malo moguće)'},
    {vrednost: 6, opis: 'apsolutno moguće'},
    {vrednost: 10, opis: 'predvidivo, očekivano'},
]

const ELEMENT_DATA2: Tabela1[] = [
    {vrednost: 1, opis: 'mali (male povrede bez bolovanja)'},
    {vrednost: 2, opis: 'znatne (medicinski tretman i bolovanje)'},
    {vrednost: 3, opis: 'ozbiljne (povreda sa ozbiljnim posledicama , hospitalizacija, moguć invaliditet)'},
    {vrednost: 6, opis: 'veoma ozbiljan / jedan smrtni slučaj'},
    {vrednost: 10, opis: 'katastrofalan (višestruki smrtni ishod)'},
]

const ELEMENT_DATA3: Tabela1[] = [
    {vrednost: 1, opis: 'retko (godišnje)'},
    {vrednost: 2, opis: 'ponekad (mesečno)'},
    {vrednost: 3, opis: 'povremeno (nedeljno)'},
    {vrednost: 6, opis: 'redovno (dnevno)'},
    {vrednost: 10, opis: 'stalno – kontinualno'},
]

const ELEMENT_DATA4: Tabela2[] = [
    {id: 1, vrednost: 'R <= 20', opis: 'veoma mali rizik - prihvatljivo', kinney: 'Radno mesto nije sa povećanim rizikom'},
    {id: 2, vrednost: '20 < R <= 70', opis: 'mali rizik - obratiti pažnju, rešiti ga redovnom procedurom', kinney: 'Radno mesto nije sa povećanim rizikom'},
    {id: 3, vrednost: '70 < R <= 200', opis: 'umeren rizik / definisati mere za smanjenje rizika', kinney: 'Umeren rizik'},
    {id: 4, vrednost: '200 < R <= 400', opis: 'visok rizik / odmah poboljšatii situaciju, potrebna brza reakcija od strane višeg rukovodstva', kinney: 'Radno mesto je sa povećanim rizikom'},
    {id: 5, vrednost: 'R > 400', opis: 'ekstremno visok rizik / zaustaviti sve radove, potrebna momentalna akcija do strane najvišeg rukovodstva', kinney: 'Radno mesto je sa povećanim rizikom'}
]



@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HomePage {
    displayedColumns: string[] = ['vrednost', 'opis'];
    dataSource1 = ELEMENT_DATA;
    dataSource2 = ELEMENT_DATA2;
    dataSource3 = ELEMENT_DATA3;
    dataSource4 = ELEMENT_DATA4;
    constructor() {}
}