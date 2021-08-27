package com.example.demo10;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface LeagueManager {

	ArrayList<FootballClub> getFootballList();
	void AddClub(FootballClub SportsClub);
	void Delete(String deleteFccClubName);
	List<AddMatch> FindMatch(Date date);
	void viewStatics(String viewClubStats);
	void playMatch();
	void leagueTable();
	void playManualMatch();
	void saveRecords(String PremierLeague, String Match) throws IOException;
	void loadRecords(String PremierLeague, String Match) throws IOException, ClassNotFoundException;

}

