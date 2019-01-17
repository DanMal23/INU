package model;

public class Language {
	private String programmingLanguage;
	private String year;
	private String developer;

	public Language(String pglg, String y, String dev) {
		this.programmingLanguage = pglg;
		this.year = y;
		this.developer = dev;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}
}
