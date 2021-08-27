import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Date } from '../League';
import { PlayMatch } from '../League';
import { PremierLeagueServiceService } from '../premier-league-service.service';
let ELEMENT_DATA : PlayMatch[];

@Component({
  selector: 'app-find-match',
  templateUrl: './find-match.component.html',
  styleUrls: ['./find-match.component.css']
})
export class FindMatchComponent implements OnInit {
  year:number;
  month:number;
  day:number;
  
  dateObj = new Date();

  displayedColumns: string[] = ['firstPlay', 'firstPlayGoal', 'firstGoalReceived', 'secondPlay','secondPlayGoal','secondGoalReceived'];
  dataSource = new MatTableDataSource<PlayMatch>(ELEMENT_DATA);  

  constructor(private service : PremierLeagueServiceService) { }

  ngOnInit(): void {
  }

  findClub(){
    this.dateObj.day=this.day
    this.dateObj.year=this.year
    this.dateObj.month=this.month
    console.log(this.dateObj)
    this.post();
  }

  post(){
    let resp = this.service.findClub(this.dateObj)
    resp.subscribe(
      report=>this.dataSource.data = report as PlayMatch[]
    )
  }

}
