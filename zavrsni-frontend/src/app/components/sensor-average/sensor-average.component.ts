import { Component, OnInit, OnDestroy } from '@angular/core';
import { SensorAverageService } from '../../services/sensor-average/sensor-average.service';
import { SensorAverage } from '../../models/sensor-average.model';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-sensor-average',
  standalone: false,
  templateUrl: './sensor-average.component.html',
  styleUrl: './sensor-average.component.css'
})
export class SensorAverageComponent implements OnInit, OnDestroy {
  sensorAverageData: SensorAverage[] = [];
  loading = true;
  errorMessage = '';
  private subscription: Subscription | undefined;

  constructor(private sensorAverageService: SensorAverageService) {}

  ngOnInit(): void {
    this.loadData();
    
    this.subscription = interval(60000).subscribe(() => {
      this.loadData();
    })

  }

  loadData() {
    this.sensorAverageService.getLastDataDay().subscribe({
      next: (data) => {
        this.sensorAverageData = data;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Greška pri učitavanju podataka.';
        this.loading = false;
      }
    });
  }

  ngOnDestroy(): void {
      this.subscription?.unsubscribe();
  }

}