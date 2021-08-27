package com.example.demo10;
import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClubs extends FootballClub implements Serializable {
    private String schoolFcClubName;
    private int age;

    public SchoolFootballClubs(String footballClubName, String footballClubLocation, int footballClubStartYear, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOfMatchesPlayed) {
        super (footballClubName,footballClubLocation,footballClubStartYear, numberOfWins, numberOfDraws, numberOfDefeats,numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOfMatchesPlayed) ;
        this.schoolFcClubName = schoolFcClubName;
        this.age = age;
    }

    public String getSchoolFcClubName() {
        return schoolFcClubName;
    }

    public void setSchoolFcClubName(String schoolFcClubName) {
        this.schoolFcClubName = schoolFcClubName;
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
        SchoolFootballClubs that = (SchoolFootballClubs) o;
        return age == that.age &&
                Objects.equals(schoolFcClubName, that.schoolFcClubName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolFcClubName, age);
    }

    @Override
    public String toString() {
        return "SchoolFootballClubs{" + super.toString() +
                "schoolName='" + schoolFcClubName + '\'' +
                ", age=" + age +
                '}';
    }
}
