export interface LeagueTableList{
    footballClubName: string;
    footballClubLocation: string;
    footballClubStartYear: number;
    numberOfWins: number;
    numberOfDraws: number;
    numberOfDefeats: number;
    numberOfGoalsReceived: number;
    numberOfGoalsScored: number;
    numberOfPoints: number;
    numberOfMatchesPlayed: number;
}

export interface PlayMatch{
    firstPlay:string;
    firstPlayGoal:number;
    firstGoalReceived:number;
    secondPlayGoal:number;
    secondPlay:string;
    secondGoalReceived:number;
    date: {
        [key: string] : Date
    };
}

export class Date{
    
    year : number;
    day : number
    month : number;
    
}