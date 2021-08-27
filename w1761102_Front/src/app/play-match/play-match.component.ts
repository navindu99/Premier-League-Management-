import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PlayMatch } from '../League';
import { PremierLeagueServiceService } from '../premier-league-service.service';

@Component({
  selector: 'app-play-match',
  templateUrl: './play-match.component.html',
  styleUrls: ['./play-match.component.css']
})
export class PlayMatchComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {
  }
}
