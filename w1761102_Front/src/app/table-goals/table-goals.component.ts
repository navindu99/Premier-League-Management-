import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { LeagueTableList } from '../League';
import { PremierLeagueServiceService } from '../premier-league-service.service';
let ELEMENT_DATA : LeagueTableList[];

@Component({
  selector: 'app-table-goals',
  templateUrl: './table-goals.component.html',
  styleUrls: ['./table-goals.component.css']
})
export class TableGoalsComponent implements OnInit {
  displayedColumns: string[] = ['footballClubName', 'footballClubLocation', 'footballClubStartYear', 'numberOfWins','numberOfDraws','numberOfDefeats','numberOfGoalsReceived','numberOfGoalsScored','numberOfPoints','numberOfMatchesPlayed'];
  dataSource = new MatTableDataSource<LeagueTableList>(ELEMENT_DATA);  

  constructor(private service:PremierLeagueServiceService) { }

  ngOnInit(): void {
    this.getTableGoals();
  }

  public getTableGoals(){
    let resp = this.service.TableGoalsSort();
    resp.subscribe(report=>this.dataSource.data = report as LeagueTableList[]);
  }
}
