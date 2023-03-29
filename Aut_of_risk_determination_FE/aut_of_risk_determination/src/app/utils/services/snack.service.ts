import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SnackService {

  constructor(private snackBar: MatSnackBar, private router: Router) { }

  authError() {
    this.snackBar.open('Morate se prijaviti kako bi ste videli ovaj sadržaj!', 'OK', {
      duration: 5000
    });

    return this.snackBar._openedSnackBarRef
    ?.onAction()
    .pipe(
      tap(_ => 
        this.router.navigate(['/login'])
      )
    )
    .subscribe();
  }

  creationError() {
    this.snackBar.open('Morate popuniti sva polja kako bi nastavili!', 'OK', {
      duration: 5000
    });

    return this.snackBar._openedSnackBarRef
    ?.onAction().subscribe();
  }
}