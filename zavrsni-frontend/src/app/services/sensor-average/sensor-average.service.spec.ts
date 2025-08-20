import { TestBed } from '@angular/core/testing';

import { SensorAverageService } from './sensor-average.service';

describe('SensorAverageService', () => {
  let service: SensorAverageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SensorAverageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
