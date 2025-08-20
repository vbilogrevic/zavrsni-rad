import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { SensorData } from '../../../models/sensor-data.model';

@Injectable({
  providedIn: 'root'
})

export class SensorService {

  private apiUrl = 'http://localhost:8080/sensor';

  constructor(private http: HttpClient) { }

  getLastData(): Observable<SensorData | null> {
    return this.http.get<SensorData | null>(`${this.apiUrl}/last`);
  }

}