package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class GithubUsersRatings {

	private SimpleStringProperty languageName;
	private SimpleDoubleProperty percent;
	
	public GithubUsersRatings(String languageName, double percent) {
		this.languageName = new SimpleStringProperty(languageName);
		this.percent = new SimpleDoubleProperty(percent);
	}
	public String getLanguageName() {
		return languageName.get();
	}

	public void setLanguageName(String languegeName) {
		this.languageName = new SimpleStringProperty(languegeName);
	}
	
	public double getPercent() {
		return percent.get();
	}

	public void setPercent(double percent) {
		this.percent = new SimpleDoubleProperty(percent);
	}
	
	public String toString() {
		return String.format("%s %s", languageName, percent);
	}
}
