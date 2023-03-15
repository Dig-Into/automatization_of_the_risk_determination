import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FrequencyService {

  private getAllFrequenciesUrl = 'http://localhost:8080/api/frequency/getAll';
  private getFrequencyByIdUrl = 'http://localhost:8080/api/frequency/findById';

  constructor(private http: HttpClient) { }

  getAllFrequencies() {
    return this.http.get(this.getAllFrequenciesUrl);
  }

  getFrequencyById(id:number) {
    
    let params = new HttpParams().set("id", id);
    return this.http.get(this.getFrequencyByIdUrl, {params});
  }
}



