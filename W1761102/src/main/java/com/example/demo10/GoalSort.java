package com.example.demo10;
import  java.util.Comparator;

public class GoalSort implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub fbClubOne, FootballClub fbClubTwo){
        return fbClubTwo.getNumberOfGoalsScored()-fbClubOne.getNumberOfGoalsScored();
    }
}
