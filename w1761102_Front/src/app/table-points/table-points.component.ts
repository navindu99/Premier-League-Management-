import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { LeagueTableList } from '../League';
import { PremierLeagueServiceService } from '../premier-league-service.service';
let ELEMENT_DATA : LeagueTableList[];

@Component({
  selector: 'app-table-points',
  templateUrl: './table-points.component.html',
  styleUrls: ['./table-points.component.css']
})
export class TablePointsComponent implements OnInit {
  displayedColumns: string[] = ['footballClubName', 'footballClubLocation', 'footballClubStartYear', 'numberOfWins','numberOfDraws','numberOfDefeats','numberOfGoalsReceived','numberOfGoalsScored','numberOfPoints','numberOfMatchesPlayed'];
  dataSource = new MatTableDataSource<LeagueTableList>(ELEMENT_DATA);  

  constructor(private service:PremierLeagueServiceService) { }

  ngOnInit(): void {
    this.getTablePoint();
  }

  public getTablePoint(){
    let resp = this.service.TablePointsSort();
    resp.subscribe(report=>this.dataSource.data = report as LeagueTableList[]);
  }

}
