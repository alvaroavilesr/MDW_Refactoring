package usantatecla.movies.v22;

import usantatecla.movies.v21.Movie;
import usantatecla.movies.v21.Rental;

public class RentalBuilder {

	private usantatecla.movies.v21.Movie movie;
	private int daysRented;
	
	public RentalBuilder movie(Movie movie) {
		this.movie = movie;
		return this;
	}
	
	public RentalBuilder daysRented(int daysRented) {
		this.daysRented = daysRented;
		return this;
	}
	
	public usantatecla.movies.v21.Rental build() {
		return new Rental(movie, daysRented);
	}
	
	
}
