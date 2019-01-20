package model;

import javafx.beans.property.SimpleStringProperty;

public class LinuxDistro {

	private SimpleStringProperty distroName, year, developerName;

	public LinuxDistro(String distroName, String year, String developerName) {
		this.distroName = new SimpleStringProperty(distroName);
		this.year = new SimpleStringProperty(year);
		this.developerName = new SimpleStringProperty(developerName);
	}

	public String getDistroName() {
		return distroName.get();
	}

	public void setDistroName(String distroName) {
		this.distroName = new SimpleStringProperty(distroName);
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
		return String.format("%s %s", distroName, year);
	}
}
