import { TestBed } from '@angular/core/testing';

import { OwnerDashboardService } from './owner-dashboard.service';

describe('OwnerDashboardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OwnerDashboardService = TestBed.get(OwnerDashboardService);
    expect(service).toBeTruthy();
  });
});
