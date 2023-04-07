import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DangerType } from 'src/app/model/DangerType';

@Injectable({
  providedIn: 'root'
})
export class DangerTypeService {

  private dangerTypeUrl = 'http://localhost:8080/api/dangerType';

  constructor(private http: HttpClient) { 

  }

  getAllDangerTypes() {
    return this.http.get(`${this.dangerTypeUrl}/getAll`);
  }

  getDangerTypeById(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.get(`${this.dangerTypeUrl}/findById/`, {params});
  }

  createDangerType(dangerType: DangerType) {
    return this.http.post(`${this.dangerTypeUrl}/create`, dangerType);
  }

  updateDangerType(dangerType: DangerType) {
    return this.http.put(`${this.dangerTypeUrl}/update`, dangerType);
  }

  deleteDangerType(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.delete(`${this.dangerTypeUrl}/delete`, {params});
  }

}