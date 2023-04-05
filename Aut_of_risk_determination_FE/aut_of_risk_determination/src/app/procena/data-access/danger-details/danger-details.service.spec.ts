import { TestBed } from '@angular/core/testing';

import { DangerDetailsService } from './danger-details.service';

describe('DangerDetailsService', () => {
  let service: DangerDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DangerDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
