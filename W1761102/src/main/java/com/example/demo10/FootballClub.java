package com.example.demo10;
import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
	//FootballClub attributes
	private int numberOfWins;
	private int numberOfDraws;
	private int numberOfDefeats;
	private int numberOfGoalsReceived;
	private int numberOfGoalsScored;
	private int numberOfPoints;
	private int numberOfMatchesPlayed;

	//args constructor
	public FootballClub(String footballClubName, String footballClubLocation, int footballClubStartYear, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOfMatchesPlayed) {
		super(footballClubName,footballClubLocation,footballClubStartYear);
		this.numberOfWins = numberOfWins;
		this.numberOfDraws = numberOfDraws;
		this.numberOfDefeats = numberOfDefeats;
		this.numberOfGoalsReceived = numberOfGoalsReceived;
		this.numberOfGoalsScored = numberOfGoalsScored;
		this.numberOfPoints = numberOfPoints;
		this.numberOfMatchesPlayed = numberOfMatchesPlayed;
	}

	//getter and setter methods of FootballClub
	public int getNumberOfWins() {
		return numberOfWins;
	}
	public int getNumberOfGoalsScored() {
		return numberOfGoalsScored;
	}
	public int getNumberOfGoalsReceived() {
		return numberOfGoalsReceived;
	}
	public int getNumberOfDraws() {
		return numberOfDraws;
	}
	public int getNumberOfMatchesPlayed() {
		return numberOfMatchesPlayed;
	}
	public int getNumberOfPoints() {
		return numberOfPoints;
	}
	public int getNumberOfDefeats() {
		return numberOfDefeats;
	}

	//setter methods of FootballClub
	public void setNumberOfDraws(int numberOfDraws) {
		this.numberOfDraws = numberOfDraws;
	}
	public void setNumberOfPoints(int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
	}
	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}
	public void setNumberOfGoalsScored(int numberOfGoalsScored) {
		this.numberOfGoalsScored = numberOfGoalsScored;
	}
	public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
		this.numberOfMatchesPlayed = numberOfMatchesPlayed;
	}
	public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
		this.numberOfGoalsReceived = numberOfGoalsReceived;
	}
	public void setNumberOfDefeats(int numberOfDefeats) {
		this.numberOfDefeats = numberOfDefeats;
	}

	@Override
	public String toString() {
		return "FootballClub{"+ super.toString() +
				"numberOfWins=" + numberOfWins +
				", numberOfDraws=" + numberOfDraws +
				", numberOfDefeats=" + numberOfDefeats +
				", numberOfGoalsReceived=" + numberOfGoalsReceived +
				", numberOfGoalsScored=" + numberOfGoalsScored +
				", numberOfPoints=" + numberOfPoints +
				", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FootballClub)) return false;
		if (!super.equals(o)) return false;
		FootballClub that = (FootballClub) o;
		return getNumberOfWins() == that.getNumberOfWins() &&
				getNumberOfDraws() == that.getNumberOfDraws() &&
				getNumberOfDefeats() == that.getNumberOfDefeats() &&
				getNumberOfGoalsReceived() == that.getNumberOfGoalsReceived() &&
				getNumberOfGoalsScored() == that.getNumberOfGoalsScored() &&
				getNumberOfPoints() == that.getNumberOfPoints() &&
				getNumberOfMatchesPlayed() == that.getNumberOfMatchesPlayed();
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getNumberOfWins(), getNumberOfDraws(), getNumberOfDefeats(), getNumberOfGoalsReceived(), getNumberOfGoalsScored(), getNumberOfPoints(), getNumberOfMatchesPlayed());
	}

	@Override
	public int compareTo(FootballClub club) {
		int comparePoints = club.getNumberOfPoints();

		if(comparePoints == this.numberOfPoints){
			//get goal difference
			int goalDifference= (club.getNumberOfGoalsScored() - club.getNumberOfGoalsReceived()) - (this.getNumberOfGoalsScored() - this.getNumberOfGoalsReceived());
			return goalDifference;
		}
		else {
			comparePoints = club.getNumberOfPoints();

			// Descending order of the points
			int goalDifference=comparePoints-this.numberOfPoints;
			return goalDifference;

		}
	}
}