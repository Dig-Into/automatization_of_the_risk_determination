import { ChangeDetectionStrategy, Component } from '@angular/core';

export interface Tabela {
    vrednost: number;
    opis: string;
}

const ELEMENT_DATA: Tabela[] = [
    {vrednost: 0.1, opis: 'jedva pojmljivo'},
    {vrednost: 0.2, opis: 'praktično neverovatno'},
    {vrednost: 0.5, opis: 'postoji, ali malo verovatno'},
    {vrednost: 1, opis: 'moguće u ograničenim slučajevima (mala verovatnoća)'},
    {vrednost: 3, opis: 'nije aktuelno, ali je moguće (malo moguće)'},
    {vrednost: 6, opis: 'apsolutno moguće'},
    {vrednost: 10, opis: 'predvidivo, očekivano'},
]

const ELEMENT_DATA2: Tabela[] = [
    {vrednost: 1, opis: 'mali (male povrede bez bolovanja)'},
    {vrednost: 2, opis: 'znatne (medicinski tretman i bolovanje)'},
    {vrednost: 3, opis: 'ozbiljne (povreda sa ozbiljnim posledicama , hospitalizacija, moguć invaliditet)'},
    {vrednost: 6, opis: 'veoma ozbiljan / jedan smrtni slučaj'},
    {vrednost: 10, opis: 'katastrofalan (višestruki smrtni ishod)'},
]

const ELEMENT_DATA3: Tabela[] = [
    {vrednost: 1, opis: 'retko (godišnje)'},
    {vrednost: 2, opis: 'ponekad (mesečno)'},
    {vrednost: 3, opis: 'povremeno (nedeljno)'},
    {vrednost: 6, opis: 'redovno (dnevno)'},
    {vrednost: 10, opis: 'stalno – kontinualno'},
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
    constructor() {}
}