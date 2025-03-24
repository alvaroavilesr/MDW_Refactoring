package usantatecla.movies.v24;

import usantatecla.movies.v21.Movie;
import usantatecla.movies.v21.Rental;

public class RentalBuilder {

	private Movie movie;
	private int daysRented;
	
	public RentalBuilder movie(Movie movie) {
		this.movie = movie;
		return this;
	}
	
	public RentalBuilder daysRented(int daysRented) {
		this.daysRented = daysRented;
		return this;
	}
	
	public Rental build() {
		return new Rental(movie, daysRented);
	}
	
	
}
