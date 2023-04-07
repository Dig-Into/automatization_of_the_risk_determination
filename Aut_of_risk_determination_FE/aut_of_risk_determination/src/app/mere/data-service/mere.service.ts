import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mera } from 'src/app/model/Mera';

@Injectable({
  providedIn: 'root'
})

export class MereService {

  private meresUrl = 'http://localhost:8080/api/riskRemovalMeasurement';

  constructor(private http: HttpClient) {

  }

  getAllMere() {
    return this.http.get(`${this.meresUrl}/getAll`);
  }

  getMereById(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.get(`${this.meresUrl}/findById/`, {params});
  }

  createMere(mere: Mera) {
    return this.http.post(`${this.meresUrl}/create`, mere);
  }

  updateMere(mere: Mera) {
    return this.http.put(`${this.meresUrl}/update`, mere);
  }

  deleteMere(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.delete(`${this.meresUrl}/delete`, {params});
  }
  
}
