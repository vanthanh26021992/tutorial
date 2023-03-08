package com.javacore.video36;

public class FilmProductionCompany {
	private String movieProductionCompanyName;
	private String nation;
	
	public FilmProductionCompany(String movieProductionCompanyName, String nation) {
		super();
		this.movieProductionCompanyName = movieProductionCompanyName;
		this.nation = nation;
	}

	public String getMovieProductionCompanyName() {
		return movieProductionCompanyName;
	}

	public void setMovieProductionCompanyName(String movieProductionCompanyName) {
		this.movieProductionCompanyName = movieProductionCompanyName;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Override
	public String toString() {
		return "FilmProductionCompany [movieProductionCompanyName=" + movieProductionCompanyName + ", nation=" + nation
				+ "]";
	}
	
	
}
