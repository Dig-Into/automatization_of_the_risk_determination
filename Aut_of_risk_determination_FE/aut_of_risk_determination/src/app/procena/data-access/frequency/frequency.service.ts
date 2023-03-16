import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FrequencyService {

  private frequencyUrl = 'http://localhost:8080/api/frequency';

  constructor(private http: HttpClient) { }

  getAllFrequencies() {
    return this.http.get(`${this.frequencyUrl}/getAll`);
  }

  getFrequencyById(id:number) {
    let params = new HttpParams().set("id", id);
    return this.http.get(`${this.frequencyUrl}/findById`, {params});
  }
  
}