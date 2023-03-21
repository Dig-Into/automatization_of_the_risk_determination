import { Component, OnInit } from '@angular/core';
import { DangerNameService } from 'src/app/procena/data-access/danger-name/danger-name.service';

@Component({
  selector: 'app-mere',
  templateUrl: './mere.component.html',
  styleUrls: ['./mere.component.css']
})


export class MereComponent {
  mere: any;
  dangers: any;
  rokovi: any;

  constructor(private dangerNamesService: DangerNameService) {}

  ngOnInit() {
    this.rokovi = [
    {
      id: '1',
      description: 'Stalno'
    },
    {
      d: '2',
      description: 'Povremeno'
    },
    {
      d: '3',
      description: 'Nikad'
    },
  ]
    this.getAllDangerNames()
  }

  addItem() {
    console.log("dodat");
    
  }

  // getAllMere() {
  //   this.mere = [
  //       {id: '1', code: '1', description: 'Strogo je zabranjeno da se uklanja fabrička zaštita sa opreme za rad, štitnika i zaštite prenosnika snage. Zabranjena je u upotreba bilo kakvih alata i opreme na kojima je vršena modifikacija, odnosno bilo kakva odstupanja u odnosu na fabričko stanje. Obavezno izvršiti vizuelni pregled pre upotrebe opreme za rad, a takođe u pauzama radova proveriti ispravnost i funkcionalnost sigurnosnih sklopova i spojeva. Mašine, alate i opremu koristiti isključivo prema nameni, odnosno u skladu sa uputstvom za upotrebu proizvođača. Tokom korišćenja opreme i alata na mehanizovani pogon neophodna je upotreba ličnih.'},
  //       {id: '2', code: '2', description: 'Opreznost u radu je neophodna puno radno vreme. Prekontrolisati ispravnost opreme i alata pre početka rada. Sigurno i pravilno pričvršćivanje reznog alata; Prilikom prenošenja materijala i opreme ne kretati se ispod tereta. Pridržavanje usvojenih uputstva za bezbedan rad. Ne žuriti sa pripremom i izvršavanjem radnih aktivnosti. Raditi ujednačeno i postupno (po redosledu radnji bez preskakanja).'},
  //       {id: '3', code: '3', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '4', code: '4', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '5', code: '5', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '6', code: '6', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '7', code: '7', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '8', code: '8', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '9', code: '9', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '10', code: '10', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '11', code: '11', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '12', code: '12', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '13', code: '13', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '14', code: '14', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '15', code: '15', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //       {id: '16', code: '16', description: 'Prilikom kretanja obratiti pažnju na sve prepreke i predmete na putanji kretanja; Ne preskakati složajeve materijala, ili druge nestabilne oslonce.   Ne kretati se u manipulativnom ili manevarskom prostoru mehanizacije ili opreme za rad koja se nalazi u istom radnom prostoru. Koristiti odvojene putanje za kretanje van domašaja vozila, mašina, mehanizacije. Ukoliko se radi u blizini putnog pojasa, neophodno je primeniti dodatne mere zaštite uz saglasnost nadležnog ministarstva. Obeležavanje zone radova, postavljanje saobraćajnih oznaka prema projektu, upotreba reflektujuće radne opreme i sl.'},
  //     ]
  //   }

    getAllDangerNames() {
      this.dangerNamesService.getAllDangerNames().subscribe(response => {
        this.dangers = response;
      });
    }
}



