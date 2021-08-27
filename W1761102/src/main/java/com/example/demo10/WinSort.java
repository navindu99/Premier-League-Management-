package com.example.demo10;
import  java.util.Comparator;

public class WinSort implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub fbClubOne, FootballClub fbClubTwo){
        return fbClubTwo.getNumberOfWins()-fbClubOne.getNumberOfWins();
    }
}
