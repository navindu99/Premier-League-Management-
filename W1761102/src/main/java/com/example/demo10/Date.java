package com.example.demo10;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable , Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @JsonIgnore
    public Integer getDate(){
        return this.year +this.month+this.day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object dateO) {
        if (this == dateO) return true;
        if (dateO == null || getClass() != dateO.getClass()) return false;
        Date date = (Date) dateO;
        return year == date.year && month == date.month && day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public int compareTo(Date date) {
        if (this.getDate() > date.getDate()){
            return 1;
        }else  if (this.getDate() < date.getDate()){
            return -1;
        }else
            return 0;
    }
}
