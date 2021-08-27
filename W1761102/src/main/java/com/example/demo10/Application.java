package com.example.demo10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import static com.example.demo10.PremierLeagueManager.footballClubList;


@SpringBootApplication
public class Application {
    private static Scanner sc = new Scanner(System.in);
    static PremierLeagueManager manager = new PremierLeagueManager();
    private static int footballClubStartYear;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        loadRecords();
        menu:
        while (true) {
            System.out.println();
            System.out.println("WELCOME TO THE PREMIER LEAGUE");
            System.out.println("------------------------------------------");
            System.out.println("Enter A to Create a New football club  " + '\n'
                    + "Enter D to Delete a football club" + '\n'
                    + "Enter P to display club Performance " + '\n'
                    + "Enter T to display League Table" + '\n'
                    + "Enter R to add Played Match Records" + '\n'
                    + "Enter S to Save the Records" + '\n'
                    + "Enter g to Open the Gui" + "\n"
                    + "Enter Q to Exit ");
            String option = sc.next();
            //Switch  cases to chose inputs
            switch (option) {
                case "a":
                case "A":
                    addClub();
                    break;
                case "d":
                case "D":
                    deleteFcClub();
                    break;
                case "p":
                case "P":
                    viewStats();
                    break;
                case "t":
                case "T":
                    leagueTable();
                    break;
                case "r":
                case "R":
                    addRecord();
                    break;
                case "s":
                case "S":
                    saveRecord();
                    break;
                case "g":
                case "G":
                    openGui();
                    break;
                case "l":
                case "L":
                    loadRecords();
                    break;
                case "q":
                case "Q":
                    System.out.println("Thank You for using the system!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Option. Please Try Again!");
                    break;
            }
        }
    }

    //create date selector
    //add new club to the league
    private static void addClub() {
        FootballClub fbClub;
        System.out.print("Enter the Football Club Name                   :  ");
        String footballClubName = sc.next();
        boolean found = false;
        for (FootballClub fbclub : footballClubList) {
            if (fbclub.getFootballClubName().equals(footballClubName)) {
                System.out.println("The Club " + footballClubName + " has been already added to the league");
                return;
            }
        }
        if (!found) {
            System.out.print("Enter the location of the Football Club        :  ");
            String footballClubLocation = sc.next();
            System.out.print("Enter the started year of the Football Club    :  ");
            try {
                footballClubStartYear = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.. Please Try Again");
                return;
            }
            int numberOfWins = 0;
            int numberOfDefeats = 0;
            int numberOfDraws = 0;
            int numberOfGoalsScored = 0;
            int numberOfGoalsReceived = 0;
            int numberOfPoints = 0;
            int numberOFMatchesPlayed = 0;

            fbClub = new FootballClub(footballClubName, footballClubLocation, footballClubStartYear, numberOfWins, numberOfDraws, numberOfDefeats, numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOFMatchesPlayed);
            manager.AddClub(fbClub);
        }
    }

    private static void deleteFcClub() {
        System.out.println("Enter the name of the Club need to delete from the league");
        String deleteFccClubName = sc.next();
        manager.Delete(deleteFccClubName);
    }

    public static void viewStats() {
        System.out.println("Enter the name of the Club need to display statics");
        String viewClubStats = sc.next();
        manager.viewStatics(viewClubStats);
    }

    public static void leagueTable() {
        manager.leagueTable();
    }

    public static void addRecord() {
        manager.playManualMatch();
    }

    private static void saveRecord() {
        try {
            manager.saveRecords("PremierLeague.txt", "Match.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadRecords() throws Exception{
        try {
            manager.loadRecords("PremierLeague.txt", "Match.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void openGui(){
        ProcessBuilder builder = new ProcessBuilder("C:\\Users\\HP\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe","http://localhost:4200/");
        try {
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
