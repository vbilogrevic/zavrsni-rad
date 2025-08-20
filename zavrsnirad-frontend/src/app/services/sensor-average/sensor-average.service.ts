import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SensorAverage } from '../../models/sensor-average.model';

@Injectable({
  providedIn: 'root'
})
export class SensorAverageService {

  private apiUrl = 'http://localhost:8080/sensor';

  constructor(private http: HttpClient) { }

  getLastDataDay(): Observable<SensorAverage[]> {
    return this.http.get<SensorAverage[]>(`${this.apiUrl}/average`);
  }
}
