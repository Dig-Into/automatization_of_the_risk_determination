import { TestBed } from '@angular/core/testing';

import { DangerNameService } from './danger-name.service';

describe('DangerNameService', () => {
  let service: DangerNameService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DangerNameService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
