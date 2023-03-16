import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DangerDetails } from 'src/app/model/DangerDetails';

@Injectable({
  providedIn: 'root'
})
export class DangerDetailsService {

  private dangerDetailsUrl = 'http://localhost:8080/api/dangerDetails';

  constructor(private http: HttpClient) {

  }

  getAllDangerDetails() {
    return this.http.get(`${this.dangerDetailsUrl}/getAll`);
  }

  getDangerDetailsById(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.get(`${this.dangerDetailsUrl}/findById/`, {params});
  }

  createDangerDetails(dangerDetails: DangerDetails) {
    return this.http.post(`${this.dangerDetailsUrl}/create`, dangerDetails);
  }

  updateDangerDetails(dangerDetails: DangerDetails) {
    return this.http.put(`${this.dangerDetailsUrl}/update`, dangerDetails);
  }

  deleteDangerDetails(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.delete(`${this.dangerDetailsUrl}/delete`, {params});
  }


}