import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProbabilityService {

  private getAllProbabilitiesUrl = 'http://localhost:8080/api/probability/getAll';
  private getProbabilityByIdUrl = 'http://localhost:8080/api/probability/findById';

  constructor(private http: HttpClient) { }

  getAllProbabilities() {
    return this.http.get(this.getAllProbabilitiesUrl);
  }

  getProbabilityById(id:number) {
    
    let params = new HttpParams().set("id", id);
    return this.http.get(this.getProbabilityByIdUrl, {params});
  }
}



