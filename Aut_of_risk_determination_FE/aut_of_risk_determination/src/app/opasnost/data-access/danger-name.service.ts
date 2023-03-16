import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DangerName } from 'src/app/model/DangerName';

@Injectable({
  providedIn: 'root'
})
export class DangerNameService {

  private dangerNameUrl = 'http://localhost:8080/api/dangerName';

  constructor(private http: HttpClient) {

  }

  getAllDangerNames() {
    return this.http.get(`${this.dangerNameUrl}/getAll`);
  }

  getDangerNameById(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.get(`${this.dangerNameUrl}/findById/`, {params});
  }

  getDangerNameCodes() {
    return this.http.get(`${this.dangerNameUrl}/getAllCodes`);
  }

  createDangerName(dangerName: DangerName) {
    return this.http.post(`${this.dangerNameUrl}/create`, dangerName);
  }

  updateDangerName(dangerName: DangerName) {
    return this.http.put(`${this.dangerNameUrl}/update`, dangerName);
  }

  deleteDangerName(id: number) {
    let params = new HttpParams().set("id", id);
    return this.http.delete(`${this.dangerNameUrl}/delete`, {params});
  }

}