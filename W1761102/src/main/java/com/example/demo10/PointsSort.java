package com.example.demo10;

import java.util.Comparator;

public class PointsSort implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub fbClubOne, FootballClub fbClubTwo){
        return fbClubTwo.getNumberOfPoints()-fbClubOne.getNumberOfPoints();
    }
}
