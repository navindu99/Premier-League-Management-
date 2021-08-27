import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { LeagueTableList } from '../League';
import { PremierLeagueServiceService } from '../premier-league-service.service';
let ELEMENT_DATA : LeagueTableList[];

@Component({
  selector: 'app-table-wins',
  templateUrl: './table-wins.component.html',
  styleUrls: ['./table-wins.component.css']
})
export class TableWinsComponent implements OnInit {
  displayedColumns: string[] = ['footballClubName', 'footballClubLocation', 'footballClubStartYear', 'numberOfWins','numberOfDraws','numberOfDefeats','numberOfGoalsReceived','numberOfGoalsScored','numberOfPoints','numberOfMatchesPlayed'];
  dataSource = new MatTableDataSource<LeagueTableList>(ELEMENT_DATA);  

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service:PremierLeagueServiceService) { }

  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
    this.getTableWins();
  }

  public getTableWins(){
    let resp = this.service.TableWinsSort();
    resp.subscribe(report=>this.dataSource.data = report as LeagueTableList[]);
  }

}
