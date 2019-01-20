package model;

import javafx.beans.property.SimpleStringProperty;

public class OS {

	private SimpleStringProperty osName, year, developerName;

	public OS(String osName, String year, String developerName) {
		this.osName = new SimpleStringProperty(osName);
		this.year = new SimpleStringProperty(year);
		this.developerName = new SimpleStringProperty(developerName);
	}

	public String getOsName() {
		return osName.get();
	}

	public void setOsName(String osName) {
		this.osName = new SimpleStringProperty(osName);
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
		return String.format("%s %s", osName, year);
	}
}
