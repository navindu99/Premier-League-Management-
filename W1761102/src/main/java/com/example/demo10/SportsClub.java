package com.example.demo10;
import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {
	//SportsClub attributes
	private String footballClubName;
	private String footballClubLocation;
	private int footballClubStartYear;


	public SportsClub(String footballClubName, String footballClubLocation, int footballClubStartYear) {
	 //constructor
		this.footballClubName = footballClubName;
		this.footballClubLocation = footballClubLocation;
		this.footballClubStartYear = footballClubStartYear;

	}

	//getter methods of SportsClub
	public String getFootballClubName() {
		return footballClubName;
	}
	public String getFootballClubLocation() {
		return footballClubLocation;
	}
	public int getfootballClubStartYear() {
		return footballClubStartYear;
	}

	//setter methods of SportsClub
	public void setFootballClubName(String footballClubName) {this.footballClubName = footballClubName;	}
	public void setLocation(String footballClubLocation) {
		this.footballClubLocation = footballClubLocation;
	}
	public void setfootballClubStartYear(int footballClubStartYear) {
		this.footballClubStartYear = footballClubStartYear;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SportsClub)) return false;
		SportsClub that = (SportsClub) o;
		return getfootballClubStartYear() == that.getfootballClubStartYear() &&
				Objects.equals(getFootballClubName(), that.getFootballClubName()) &&
				Objects.equals(getFootballClubLocation(), that.getFootballClubLocation());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFootballClubName(), getFootballClubLocation(), getfootballClubStartYear());
		
	}

	@Override
	public String toString() {
		return "SportsClub{" +
				"footballClubName='" + footballClubName + '\'' +
				", footballClubLocation='" + footballClubLocation + '\'' +
				", footballClubStartYear=" + footballClubStartYear +
				'}';
	}
}
