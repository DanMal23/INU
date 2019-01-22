package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TiobeRatings {

	private SimpleIntegerProperty year;
	private SimpleDoubleProperty percent;
	
	public TiobeRatings(int year, double percent) {
		this.year = new SimpleIntegerProperty(year);
		this.percent = new SimpleDoubleProperty(percent);
	}
	public int getYear() {
		return year.get();
	}

	public void setYear(int year) {
		this.year = new SimpleIntegerProperty(year);
	}
	
	public double getPercent() {
		return percent.get();
	}

	public void setPercent(double percent) {
		this.percent = new SimpleDoubleProperty(percent);
	}
	
	public String toString() {
		return String.format("%s %s", year, percent);
	}
}

