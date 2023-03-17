import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EffectService {

  private effectUrl = 'http://localhost:8080/api/effect';

  constructor(private http: HttpClient) { }

  getAllEffects() {
    return this.http.get(`${this.effectUrl}/getAll`);
  }

  getEffectById(id:number) {
    let params = new HttpParams().set("id", id);
    return this.http.get(`${this.effectUrl}/findById`, {params});
  }

  getEffectByCode(code: string) {
    let params = new HttpParams().set("code", code);
    return this.http.get(`${this.effectUrl}/findByCode`, {params});
  }

}