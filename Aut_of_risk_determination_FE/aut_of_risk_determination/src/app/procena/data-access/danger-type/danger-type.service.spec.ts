import { TestBed } from '@angular/core/testing';

import { DangerTypeService } from './danger-type.service';

describe('DangerTypeService', () => {
  let service: DangerTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DangerTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
