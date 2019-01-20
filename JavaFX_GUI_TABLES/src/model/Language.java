package model;

import javafx.beans.property.SimpleStringProperty;

public class Language {

	private SimpleStringProperty languageName, year, developerName;

	public Language(String languageName, String year, String developerName) {
		this.languageName = new SimpleStringProperty(languageName);
		this.year = new SimpleStringProperty(year);
		this.developerName = new SimpleStringProperty(developerName);
	}

	public String getLanguageName() {
		return languageName.get();
	}

	public void setLanguageName(String languageName) {
		this.languageName = new SimpleStringProperty(languageName);
	}

	public String getYear() {
		return year.get();
	}

	public void setYear(String year) {
		this.year = new SimpleStringProperty(year);
	}

	public String getDeveloperName() {
		return developerName.get();
	}

	public void setDeveloperName(String developerName) {
		this.developerName = new SimpleStringProperty(developerName);
	}

	public String toString() {
		return String.format("%s %s", languageName, year);
	}
}
