import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SensorAverageComponent } from './sensor-average.component';

describe('SensorAverageComponent', () => {
  let component: SensorAverageComponent;
  let fixture: ComponentFixture<SensorAverageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SensorAverageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SensorAverageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
