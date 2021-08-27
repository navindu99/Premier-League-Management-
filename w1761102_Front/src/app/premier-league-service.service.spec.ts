import { TestBed } from '@angular/core/testing';

import { PremierLeagueServiceService } from './premier-league-service.service';

describe('PremierLeagueServiceService', () => {
  let service: PremierLeagueServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PremierLeagueServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
