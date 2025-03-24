package usantatecla.movies.v27;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
        return String.valueOf(getHeader()) + getRentalLines() + getFooter();
	}

	private StringBuilder getHeader() {
		return new StringBuilder()
				.append("Rental Record for ")
				.append(this.getName())
				.append("\n");
	}

	private StringBuilder getRentalLines() {
		StringBuilder rentalLines = new StringBuilder();
		for (Rental rental : this.rentals) {
			rentalLines.append("\t")
					.append(rental.getMovie().getTitle())
					.append("\t")
					.append(rental.getCharge())
					.append("\n");
		}
		return rentalLines;
	}

	private StringBuilder getFooter() {
		return new StringBuilder()
				.append("Amount owed is ")
				.append(this.getTotalCharge())
				.append("\nYou earned ")
				.append(this.getTotalFrequentRenterPoints())
				.append(" frequent renter points");
	}

	private double getTotalCharge() {
		double result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getCharge();
        }
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getFrequentRenterPoints();
        }
		return result;
	}

}
