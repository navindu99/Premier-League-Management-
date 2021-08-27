import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PlayMatch } from '../League';
import { PremierLeagueServiceService } from '../premier-league-service.service';
let ELEMENT_DATA : PlayMatch[];

@Component({
  selector: 'app-date-sort',
  templateUrl: './date-sort.component.html',
  styleUrls: ['./date-sort.component.css']
})
export class DateSortComponent implements OnInit {
  displayedColumns: string[] = ['firstPlay', 'firstPlayGoal', 'firstGoalReceived', 'secondPlay','secondPlayGoal','secondGoalReceived','Date'];
  dataSource = new MatTableDataSource<PlayMatch>(ELEMENT_DATA); 

  constructor(private service:PremierLeagueServiceService) {}

  ngOnInit(): void {
    this.getPlayMatch();
  }

  public getPlayMatch(){
    let resp = this.service.matchSort();
    resp.subscribe(report=>this.dataSource.data = report as PlayMatch[]);
  }

}
