package com.example.demo10;
import java.io.Serializable;
import java.util.Objects;

public class AddMatch implements Serializable ,Comparable<Date>{
	//FootballClub attributes
	private String firstPlay;
	private String secondPlay;
	private int firstPlayGoal;
	private int secondPlayGoal;
	private int firstGoalReceived;
	private int secondGoalReceived;
	private Date date;

	//args constructor
	public AddMatch(String firstPlay, int firstGoalReceived, int firstPlayGoal, String secondPlay, int secondGoalReceived, int secondPlayGoal, Date date){
		this.date = date;
		this.firstPlay = firstPlay;
		this.firstGoalReceived = firstGoalReceived;
		this.firstPlayGoal = firstPlayGoal;
		this.secondPlay = secondPlay;
		this.secondGoalReceived = secondGoalReceived;
		this.secondPlayGoal = secondPlayGoal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//getter and setter methods of FootballClub
	public String getFirstPlay() { return firstPlay; }
	public int getFirstGoalReceived() { return firstGoalReceived; }
	public int getFirstPlayGoal() { return firstPlayGoal; }
	public String getSecondPlay() { return secondPlay; }
	public int getSecondGoalReceived() { return secondGoalReceived; }
	public int getSecondPlayGoal() { return secondPlayGoal; }


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AddMatch addMatch = (AddMatch) o;
		return firstPlayGoal == addMatch.firstPlayGoal && secondPlayGoal == addMatch.secondPlayGoal && firstGoalReceived == addMatch.firstGoalReceived && secondGoalReceived == addMatch.secondGoalReceived && Objects.equals(firstPlay, addMatch.firstPlay) && Objects.equals(secondPlay, addMatch.secondPlay) && Objects.equals(date, addMatch.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstPlay, secondPlay, firstPlayGoal, secondPlayGoal, firstGoalReceived, secondGoalReceived, date);
	}

	@Override
	public String toString() {
		return "AddMatch{" +
				"firstPlay='" + firstPlay + '\'' +
				", secondPlay='" + secondPlay + '\'' +
				", firstPlayGoal=" + firstPlayGoal +
				", secondPlayGoal=" + secondPlayGoal +
				", firstGoalReceived=" + firstGoalReceived +
				", secondGoalReceived=" + secondGoalReceived +
				", date=" + date +
				'}';
	}

	public void setFirstPlay(String firstPlay) { this.firstPlay = firstPlay; }
	public void setFirstGoalReceived(int firstGoalReceived) { this.firstGoalReceived = firstGoalReceived; }
	public void setFisrtPlayGoal(int fisrtPlayGoal) { this.firstPlayGoal = fisrtPlayGoal; }
	public void setSecondPlay(String secondPlay) { this.secondPlay = secondPlay; }
	public void setsecondGoalReceived(int secondGoalReceived) { this.secondGoalReceived = secondGoalReceived; }
	public void setSecondPlayGoal(int secondPlayGoal) { this.secondPlayGoal = secondPlayGoal; }

	@Override
	public int compareTo(Date o) {
		return this.getDate().toString().compareTo(getDate().toString());
	}
}

