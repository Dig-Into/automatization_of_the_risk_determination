import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class KinneyIndexService {

    calculateRang(result: number): string {
        if (result <= 20) {
            return "(R-1)";
          } else if (result <= 70) {
            return "(R-2)";
          } else if (result <= 200) {
            return "(R-3)";
          } else if (result <= 400) {
            return "(R-4)";
          } else {
            return "(R-5)";
          }
    }


}