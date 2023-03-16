import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProbabilityService {

  private probabilityUrl = 'http://localhost:8080/api/probability';

  constructor(private http: HttpClient) { }

  getAllProbabilities() {
    return this.http.get(`${this.probabilityUrl}/getAll`);
  }

  getProbabilityById(id:number) {
    let params = new HttpParams().set("id", id);
    return this.http.get(`${this.probabilityUrl}/findById`, {params});
  }

}