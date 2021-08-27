package com.example.demo10;
import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {
    private String uniFcCLubName;
    private int age;


    public UniversityFootballClub(String footballClubName, String footballClubLocation, int footballClubStartYear, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOfMatchesPlayed) {
        super (footballClubName,footballClubLocation,footballClubStartYear, numberOfWins, numberOfDraws, numberOfDefeats,numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOfMatchesPlayed) ;
        this.uniFcCLubName = uniFcCLubName;
        this.age = age;
    }

    public String getUniFcCLubName() {
        return uniFcCLubName;
    }

    public void setUniFcCLubName(String uniName) {
        this.uniFcCLubName = uniName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return age == that.age &&
                Objects.equals(uniFcCLubName, that.uniFcCLubName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uniFcCLubName, age);
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" + super.toString() +
                "uniName='" + uniFcCLubName + '\'' +
                ", age=" + age +
                '}';
    }
}
