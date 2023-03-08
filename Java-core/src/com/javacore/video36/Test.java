package com.javacore.video36;

public class Test {
public static void main(String[] args) {
	MovieDay mvd1 = new MovieDay(11, 2, 2022);
	MovieDay mvd2 = new MovieDay(12, 3, 2022);
	MovieDay mvd3 = new MovieDay(13, 2, 2022);
	
	FilmProductionCompany fpc1 = new FilmProductionCompany("hang a", "quoc gia a");
	FilmProductionCompany fpc2 = new FilmProductionCompany("hang b", "quoc gia b");
	FilmProductionCompany fpc3 = new FilmProductionCompany("hang c", "quoc gia c");
	
	Movie mv1 = new Movie("phim 1", 2020, fpc1, 100000, mvd1);
	Movie mv2 = new Movie("phim 2", 2020, fpc2, 200000, mvd2);
	Movie mv3 = new Movie("phim 3", 2020, fpc3, 300000, mvd3);
	
	System.out.println("So sanh phim 1 voi phim 2 "+mv1.checkTichetPrice(mv2));
	System.out.println("So sanh phim 1 voi phim 3 "+mv1.checkTichetPrice(mv3));
	System.out.println("Ten phim 1: "+mv1.movieProductionCompanyName());
	System.out.println("Ten phim 2: "+mv2.movieProductionCompanyName());
	System.out.println("Ten phim 3: "+mv3.movieProductionCompanyName());
	System.out.println("Gia ve phim 1 khi co km: "+mv1.ticketPriceWhenThereIsPromotion(10));
	System.out.println("Gia ve phim 1 khi co km: "+mv1.ticketPriceWhenThereIsPromotion(15));
	System.out.println("Gia ve phim 2 khi co km: "+mv2.ticketPriceWhenThereIsPromotion(10));
	System.out.println("Gia ve phim 3 khi co km: "+mv3.ticketPriceWhenThereIsPromotion(10));
	
}
}
