package com.example.demo10;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class PremierLeagueManager implements LeagueManager {
	public static ArrayList<FootballClub> footballClubList = new ArrayList<>();
	private static   ArrayList<AddMatch> matchList = new ArrayList<>();
	public static  List tempMatchList = new ArrayList();
	private static int year;
	private static int month;
	private static int day;
	private static int firstPlayGoal;
	private static int secondPlayGoals;

	public ArrayList<FootballClub> getFootballList() {
		return footballClubList;
	}

	public ArrayList<AddMatch> getMatchList() {
		return matchList;
	}

	public List<FootballClub> getTableGoalSort(){
		Collections.sort(footballClubList,new GoalSort());
		return footballClubList;
	}

	public List<FootballClub> getTableWinsSort(){
		Collections.sort(footballClubList,new WinSort());
		return footballClubList;
	}

	public List<FootballClub> getTablePointSort(){
		Collections.sort(footballClubList,new PointsSort());
		return footballClubList; }


	@Override
	public void AddClub(FootballClub footballClub) {
		for (FootballClub footballClub1 : footballClubList){
			if (footballClub1.getFootballClubName().equals(footballClub.getFootballClubName())){
				System.out.println("Club is already in the List");
			}
		}
		footballClubList.add(footballClub);
		System.out.println("Football club has been added to the league successfully.");
	}

	//delete football club from premier league
	@Override
	public void Delete(String deleteFccClubName) {
		if (footballClubList.isEmpty()) {
			System.out.println("No Clubs in the League..!");
		} else {
			boolean found = false;
			for (FootballClub fbClub : footballClubList) {
				if (fbClub.getFootballClubName().equals(deleteFccClubName)) {
					System.out.println("The Football Club " + fbClub.getFootballClubName() + " has been successfully deleted");
					footballClubList.remove(fbClub);
				}
				break;
			}
			if (!found) {
				System.out.println("No Club Found.");
			}
		}
	}

	//show statistics of chosen club
	@Override
	public void viewStatics(String viewClubStats) {
		if(footballClubList.isEmpty()){
			System.out.println("No Clubs in the League..!");
		}else{
			boolean found = false;
			for(FootballClub fbClub : footballClubList){
				if (fbClub.getFootballClubName().equals(viewClubStats)){
					System.out.println("Current statics of the club " + fbClub.getFootballClubName());
					System.out.println("---------------------------------------------");
					System.out.println(" |   Club Name   |   " +
							" Club Location |" +
							" Club Start Year |" +
							" No. of Wins |" +
							" No. of Draws |" +
							" No. Of Defeats |" +
							" Received Goals |" +
							" Scored Goals |" +
							" Points |" +
							" Matches Played |");
					System.out.println("         " + fbClub.getFootballClubName() + "        " +
							"  " + fbClub.getFootballClubLocation() +"            " +
							"   " + fbClub.getfootballClubStartYear() + "          " +
							"      " + fbClub.getNumberOfWins() + "          " +
							"      " + fbClub.getNumberOfDraws()+ "          " +
							"      " + fbClub.getNumberOfDefeats()+"        "+
							"      " +fbClub.getNumberOfGoalsReceived()+"        "+
							"      " + fbClub.getNumberOfGoalsScored() + "        "+
							"    " + fbClub.getNumberOfPoints() + "      " +
							"      " + fbClub.getNumberOfMatchesPlayed() + "      ");
				}
			}if(!found){
				System.out.println("No Club Found");
			}
		}
	}

	@Override
	public void leagueTable(){

		if (footballClubList.isEmpty()) {
			System.out.println("No Clubs in the League..!");
		} else {
			Collections.sort(footballClubList, new Comparator<FootballClub>() {
				@Override
				public int compare(FootballClub club1, FootballClub club2) {
					return Integer.valueOf(club2.getNumberOfPoints()).compareTo(club1.getNumberOfPoints());
				}
			});
			System.out.println(" |   Club Name   |   " +
					" Club Location |" +
					" Club Start Year |" +
					" No. of Wins |" +
					" No. of Draws |" +
					" No. Of Defeats |" +
					" Received Goals |" +
					" Scored Goals |" +
					" Points |" +
					" Matches Played |");
			for (int count = 0; count < footballClubList.size(); count++) {
				System.out.println("         " + footballClubList.get(count).getFootballClubName() + "        " +
						"  " + footballClubList.get(count).getFootballClubLocation() + "            " +
						"   " + footballClubList.get(count).getfootballClubStartYear() + "          " +
						"      " + footballClubList.get(count).getNumberOfWins() + "          " +
						"      " + footballClubList.get(count).getNumberOfDraws() + "          " +
						"      " + footballClubList.get(count).getNumberOfDefeats() + "        " +
						"      " + footballClubList.get(count).getNumberOfGoalsReceived() + "        " +
						"      " + footballClubList.get(count).getNumberOfGoalsScored() + "        " +
						"    " + footballClubList.get(count).getNumberOfPoints() + "      " +
						"      " + footballClubList.get(count).getNumberOfMatchesPlayed() + "      ");
			}
		}
	}

	//play a match between two clubs
	@Override
	public void playMatch() {
		if (footballClubList.isEmpty()) {
			System.out.println("There are no clubs to show.");
		} else {
			AddMatch match;
			Scanner sc = new Scanner(System.in);

			//Generating random numbers
			Random rand = new Random();

			//Generating Random Date
			int randYear = rand.nextInt(2023 - 2021 + 1) + 2021;
			System.out.println(randYear);
			int randMonth = rand.nextInt(13-1) ;
			int randDay = 0;
			if(randMonth == 1 || randMonth == 3 || randMonth == 5 || randMonth == 7 || randMonth == 8 || randMonth == 10 || randMonth == 12){
				randDay = rand.nextInt(32-1) + 1;
			}
			else if(randMonth == 4 || randMonth == 6 || randMonth == 9 || randMonth == 11){
				randDay = rand.nextInt(31-1);
			}
			else if(randMonth == 2){
				randDay = rand.nextInt(29 - 1);
			}
			//Generating random numbers to the list size and obtain random club using index
			int randOne = rand.nextInt(footballClubList.size());
			int randTwo = rand.nextInt(footballClubList.size());
			//Generating random numbers for no of goals
			int firstPlayGoal = rand.nextInt(15);
			int secondPlayGoals = rand.nextInt(15);
			int firstReceivedGoal = secondPlayGoals;
			int secondReceivedGoal = firstPlayGoal;
			//Check whether randomly selected clubs are different
			if (randOne == randTwo) {
				if (randTwo == footballClubList.size() - 1) {
					randTwo -= 1;
				} else {
					randTwo += 1;
				}
			}
			//Creating a match object with the super class Match
			tempMatchList.clear();
			Date date = new Date(randYear,randMonth,randDay);
			match = new AddMatch(footballClubList.get(randOne).getFootballClubName(), firstReceivedGoal, firstPlayGoal, footballClubList.get(randTwo).getFootballClubName(), secondReceivedGoal,secondPlayGoals,date);
			tempMatchList.add(match);
			matchList.add(match);
			System.out.println("Match list" + matchList);
			for (FootballClub fbClub : footballClubList) {
				if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
					int matches = fbClub.getNumberOfMatchesPlayed() + 1;
					fbClub.setNumberOfMatchesPlayed(matches);

					int score = fbClub.getNumberOfGoalsScored() + match.getFirstPlayGoal();
					fbClub.setNumberOfGoalsScored(score);

					int goals = fbClub.getNumberOfGoalsReceived() + match.getFirstGoalReceived();
					fbClub.setNumberOfGoalsReceived(goals);
				}

				if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
					int matches = fbClub.getNumberOfMatchesPlayed() + 1;
					fbClub.setNumberOfMatchesPlayed(matches);

					int score = fbClub.getNumberOfGoalsScored() + match.getSecondPlayGoal();
					fbClub.setNumberOfGoalsScored(score);

					int goals = fbClub.getNumberOfGoalsReceived() + match.getSecondGoalReceived();
					fbClub.setNumberOfGoalsReceived(goals);
				}

				if (match.getFirstPlayGoal() > match.getSecondPlayGoal()) {
					if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
						int points = fbClub.getNumberOfPoints() + 3;
						fbClub.setNumberOfPoints(points);
						int wins = fbClub.getNumberOfWins() + 1;
						fbClub.setNumberOfWins(wins);

					}
					if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
						int defeats = fbClub.getNumberOfDefeats() + 1;
						fbClub.setNumberOfDefeats(defeats);
					}

				} else if (match.getFirstPlayGoal() < match.getSecondPlayGoal()) {
					if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
						int points = fbClub.getNumberOfPoints() + 3;
						fbClub.setNumberOfPoints(points);
						int wins = fbClub.getNumberOfWins() + 1;
						fbClub.setNumberOfWins(wins);
					}
					if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
						int defeats = fbClub.getNumberOfDefeats() + 1;
						fbClub.setNumberOfDefeats(defeats);
					}
				} else if (match.getFirstPlayGoal() == match.getSecondPlayGoal()) {
					if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
						int points = fbClub.getNumberOfPoints() + 1;
						fbClub.setNumberOfPoints(points);
						int draws = fbClub.getNumberOfDraws() + 1;
						fbClub.setNumberOfDraws(draws);
					}
					if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
						int points = fbClub.getNumberOfPoints() + 1;
						fbClub.setNumberOfPoints(points);
						int draws = fbClub.getNumberOfDraws() + 1;
						fbClub.setNumberOfDraws(draws);
					}
				}
			}
		}
	}

	@Override
	public void playManualMatch(){
		int checkOne = 0;
		int checkTwo = 0;
		int checkThree = 0;
		if(footballClubList.isEmpty()){
			System.out.println("There are no clubs to show.");
		}else {
			AddMatch match;
			Scanner sc = new Scanner(System.in);
			System.out.println("Continue to add a new match");
			System.out.println("Enter the Date");

			System.out.println("Year");
			try {
				year = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input.. Please Try Again" + '\n' + "");
				return;
			}
			if (year > 2020 && year < 2023) {
				checkOne = 1;
			} else {
				System.out.println("invalid year.. Try again");
				return;
			}

			System.out.println("Month");
			try {
				month = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input.. Please Try Again" + '\n' + "");
				return;
			}
			if (month > 12) {
				System.out.println("invalid date.. Try again");
				return;
			} else {
				checkTwo = 1;
			}

			System.out.println("Date");
			try {
				day = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input.. Please Try Again" + '\n' + "");
				return;
			}
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				if (day > 31) {
					System.out.println("invalid date.. Try again");
					return;
				}else {
					checkThree = 1;
				}
			else if(month == 4 || month == 6 || month == 9 || month == 11 ){
				if (day > 30) {
					System.out.println("invalid date.. Try again");
					return;
				}else {
					checkThree = 1;
				}
			}else if(month == 2){
				if (day > 29) {
					System.out.println("invalid date.. Try again");
					return;
				}else {
					checkThree = 1;
				}
			}
			if (checkOne == 1 && checkTwo == 1 && checkThree == 1) {
				int checkClubOne = 0;
				int checkClubTwo = 0;
				System.out.println("Football Clubs in the League");
				for (int i = 0; i < footballClubList.size(); i++) {
					System.out.println(footballClubList.get(i).getFootballClubName());
				}
				System.out.println("-----------------------------");
				System.out.print("Enter the Team One  :  ");
				String firstPlay = sc.next();
				boolean found = false;
				for (FootballClub fbClub : footballClubList) {
					if (fbClub.getFootballClubName().equals(firstPlay)) {
						checkClubOne = 1;
					}
				}

				System.out.print("Enter the goals scored  :  ");
				try {
					firstPlayGoal = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input.. Please Try Again" + '\n' + "");
					return;
				}
				System.out.println("-   -   -   -   -   -");
				System.out.print("Enter the Team Two  :  ");
				String secondPlay = sc.next();
				for (FootballClub fbClub : footballClubList) {
					if (fbClub.getFootballClubName().equals(secondPlay)) {
						checkClubTwo = 1;
					}
				}

				System.out.print("Enter the goals scored  :  ");
				try {
					secondPlayGoals = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input.. Please Try Again" + '\n' + "");
					return;
				}
				if (checkClubOne == 1 && checkClubTwo == 1) {
					int firstReceivedGoal = secondPlayGoals;
					int secondReceivedGoal = firstPlayGoal;

					//Creating a match object with the super class Match
					Date date = new Date(year,month,day);
					match = new AddMatch(firstPlay, firstReceivedGoal, firstPlayGoal, secondPlay, secondReceivedGoal, secondPlayGoals, date);
					System.out.println("Clubs in the league");
					for (FootballClub fbClub : footballClubList) {
						matchList.add(match);

						if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
							int matches = fbClub.getNumberOfMatchesPlayed() + 1;
							fbClub.setNumberOfMatchesPlayed(matches);

							int score = fbClub.getNumberOfGoalsScored() + match.getFirstPlayGoal();
							fbClub.setNumberOfGoalsScored(score);

							int goals = fbClub.getNumberOfGoalsReceived() + match.getFirstGoalReceived();
							fbClub.setNumberOfGoalsReceived(goals);
						}

						if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
							int matches = fbClub.getNumberOfMatchesPlayed() + 1;
							fbClub.setNumberOfMatchesPlayed(matches);

							int score = fbClub.getNumberOfGoalsScored() + match.getSecondPlayGoal();
							fbClub.setNumberOfGoalsScored(score);

							int goals = fbClub.getNumberOfGoalsReceived() + match.getSecondGoalReceived();
							fbClub.setNumberOfGoalsReceived(goals);
						}

						if (match.getFirstPlayGoal() > match.getSecondPlayGoal()) {
							if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
								int points = fbClub.getNumberOfPoints() + 3;
								fbClub.setNumberOfPoints(points);
								int wins = fbClub.getNumberOfWins() + 1;
								fbClub.setNumberOfWins(wins);

							}
							if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
								int defeats = fbClub.getNumberOfDefeats() + 1;
								fbClub.setNumberOfDefeats(defeats);
							}

						} else if (match.getFirstPlayGoal() < match.getSecondPlayGoal()) {
							if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
								int points = fbClub.getNumberOfPoints() + 3;
								fbClub.setNumberOfPoints(points);
								int wins = fbClub.getNumberOfWins() + 1;
								fbClub.setNumberOfWins(wins);
							}
							if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
								int defeats = fbClub.getNumberOfDefeats() + 1;
								fbClub.setNumberOfDefeats(defeats);
							}
						} else if (match.getFirstPlayGoal() == match.getSecondPlayGoal()) {
							if (fbClub.getFootballClubName().equals(match.getFirstPlay())) {
								int points = fbClub.getNumberOfPoints() + 1;
								fbClub.setNumberOfPoints(points);
								int draws = fbClub.getNumberOfDraws() + 1;
								fbClub.setNumberOfDraws(draws);
							}
							if (fbClub.getFootballClubName().equals(match.getSecondPlay())) {
								int points = fbClub.getNumberOfPoints() + 1;
								fbClub.setNumberOfPoints(points);
								int draws = fbClub.getNumberOfDraws() + 1;
								fbClub.setNumberOfDraws(draws);
							}
						} else {
							System.out.println("Invalid Inputs.. Can not find the club..");
						}
					}
				}else {
					System.out.println("No clubs found with names entered");
				}
			}
			else {
				System.out.println("Invalid Date");
			}
		}
	}

	public List getPlayMatch() {
		return tempMatchList;
	}

	public List getMatch(){
		return matchList;
	}

	@Override
	public List<AddMatch> FindMatch(Date date){
		List<AddMatch> tempList = new ArrayList<>();
		boolean found = false;
		for (AddMatch fbClub : matchList) {
			if (fbClub.getDate().equals(date)) {
				System.out.println(fbClub);
				tempList.add(fbClub);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Club Found");
		}
		return tempList;
	}

	@Override
	public void loadRecords(String PremierLeague,String Match) throws IOException {
		FileInputStream fileOutClubs=new FileInputStream(PremierLeague);
		ObjectInputStream objectOutClubs=new ObjectInputStream(fileOutClubs);
		for (; ;){
			try {
				FootballClub footballClubs=(FootballClub)objectOutClubs.readObject();
				footballClubList.add(footballClubs);
			}catch (IOException|ClassNotFoundException e){
				break;
			}
		}

		FileInputStream fileOutMatch=new FileInputStream(Match);
		ObjectInputStream objectOutMatch=new ObjectInputStream(fileOutMatch);
		for (; ;){
			try {
				AddMatch match=(AddMatch) objectOutMatch.readObject();
				matchList.add(match);
			}catch (IOException|ClassNotFoundException e){
				break;
			}
		}
		System.out.println("Your Records are successfully Loaded in to the system");
	}

	@Override
	public void saveRecords(String PremierLeague,String Match) throws IOException  {
		FileOutputStream fileOutClubs = new FileOutputStream(PremierLeague);
		ObjectOutputStream objectOutClubs = new ObjectOutputStream(fileOutClubs);
		for(FootballClub fbClub:getFootballList()){
			objectOutClubs.writeObject(fbClub);
		}
		objectOutClubs.close();
		fileOutClubs.close();

		FileOutputStream fileOutMatch = new FileOutputStream(Match);
		ObjectOutputStream objectOutMatch = new ObjectOutputStream(fileOutMatch);
		for(AddMatch match:getMatchList()){
			objectOutMatch.writeObject(match);
		}
		objectOutMatch.close();
		fileOutMatch.close();
		System.out.println("Your Records are successfully saved");
	}
}





