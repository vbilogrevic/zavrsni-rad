import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DhmzData } from '../../models/dhmz-data.model';

@Injectable({
  providedIn: 'root'
})

export class DhmzService {

  private apiUrl = 'http://localhost:8080/dhmz';

  constructor(private http: HttpClient) {}

  getZagrebMaksimir(): Observable<DhmzData |null> {
    return this.http.get<DhmzData | null>(`${this.apiUrl}/xml`);
  }
}
