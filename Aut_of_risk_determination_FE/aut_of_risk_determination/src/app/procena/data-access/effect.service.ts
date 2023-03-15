import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EffectService {

  private getAllEffectsUrl = 'http://localhost:8080/api/effect/getAll';
  private getEffectByIdUrl = 'http://localhost:8080/api/effect/findById';

  constructor(private http: HttpClient) { }

  getAllEffects() {
    return this.http.get(this.getAllEffectsUrl);
  }

  getEffectById(id:number) {
    
    let params = new HttpParams().set("id", id);
    return this.http.get(this.getEffectByIdUrl, {params});
  }
}



