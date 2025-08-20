import { TestBed } from '@angular/core/testing';

import { DhmzService } from './dhmz.service';

describe('DhmzService', () => {
  let service: DhmzService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DhmzService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
