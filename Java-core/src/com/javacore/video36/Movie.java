package com.javacore.video36;

public class Movie {
	private String movieName;
	private int filmProductionYear;
	private FilmProductionCompany filmProductionCompany;
	private double ticketPrice;
	private MovieDay mdDay;
	
	public Movie(String movieName, int filmProductionYear, FilmProductionCompany filmProductionCompany,
			double ticketPrice, MovieDay mdDay) {
		this.movieName = movieName;
		this.filmProductionYear = filmProductionYear;
		this.filmProductionCompany = filmProductionCompany;
		this.ticketPrice = ticketPrice;
		this.mdDay = mdDay;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getFilmProductionYear() {
		return filmProductionYear;
	}

	public void setFilmProductionYear(int filmProductionYear) {
		this.filmProductionYear = filmProductionYear;
	}

	public FilmProductionCompany getFilmProductionCompany() {
		return filmProductionCompany;
	}

	public void setFilmProductionCompany(FilmProductionCompany filmProductionCompany) {
		this.filmProductionCompany = filmProductionCompany;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public MovieDay getMdDay() {
		return mdDay;
	}

	public void setMdDay(MovieDay mdDay) {
		this.mdDay = mdDay;
	}
	
	public boolean checkTichetPrice(Movie mv) {
		return this.getTicketPrice() < mv.getTicketPrice();
	}
	
	public String movieProductionCompanyName() {
		return this.getFilmProductionCompany().getMovieProductionCompanyName();
	}
	
	public double ticketPriceWhenThereIsPromotion(double x) {
		return this.ticketPrice*(1-x/100);
	}
}
