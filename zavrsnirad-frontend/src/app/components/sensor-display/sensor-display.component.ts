import { Component, OnDestroy, OnInit } from '@angular/core';
import { SensorService } from '../../services/dhmz/sensor/sensor.service';
import { SensorData } from '../../models/sensor-data.model';
import { interval, Subscription } from 'rxjs';
import { DhmzService } from '../../services/dhmz/dhmz.service';
import { DhmzData } from '../../models/dhmz-data.model';

@Component({
  selector: 'app-sensor-display',
  standalone: false,
  templateUrl: './sensor-display.component.html',
  styleUrl: './sensor-display.component.css'
})

export class SensorDisplayComponent implements OnInit, OnDestroy {
  sensorData: SensorData | null = null;
  dhmzData: DhmzData | null = null;

  loading = true;
  errorMessage = '';
  private subscription: Subscription | undefined;

  constructor( private sensorService: SensorService, private dhmzService: DhmzService) {}

  ngOnInit(): void {
    this.loadData();
    this.subscription = interval(60000).subscribe(() => {
      this.loadData();
    });
  }

  loadData() {
    this.sensorService.getLastData().subscribe({
      next: (data) => {
        this.sensorData = data;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Greška pri učitavanju podataka senzora.';
        this.loading = false;
      }
    });

    this.dhmzService.getZagrebMaksimir().subscribe({
      next: (data) => {
        this.dhmzData = data;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Greška pri učitavanju podataka senzora. DHMZ';
        this.loading = false;
      }
    });

  }

  ngOnDestroy(): void {
    this.subscription?.unsubscribe();
  }
}
