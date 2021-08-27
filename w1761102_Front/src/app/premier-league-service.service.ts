import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PremierLeagueServiceService {

  constructor(private http:HttpClient) { }

  public TableGoalsSort(){
    return this.http.get("http://localhost:8080/tablegoals");
  }

  public TableWinsSort(){
    return this.http.get("http://localhost:8080/tablewins");
  }

  public TablePointsSort(){
    return this.http.get("http://localhost:8080/tablepoints");
  }

  public GenerateMatch(){
    return this.http.get("http://localhost:8080/genmatch");
  }

  public matchSort(){
    return this.http.get("http://localhost:8080/matchlist");
  }


  public findClub(date){
    return this.http.post("http://localhost:8080/findClub",date);
  }

}
