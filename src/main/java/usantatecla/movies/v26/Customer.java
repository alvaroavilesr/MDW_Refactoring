package usantatecla.movies.v26;

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
		for (Rental each : this.rentals) {
			rentalLines.append("\t")
					.append(each.getMovie().getTitle())
					.append("\t")
					.append(each.getCharge())
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
        for (Rental each : this.rentals) {
            result += each.getCharge();
        }
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
        for (Rental each : this.rentals) {
            result += each.getFrequentRenterPoints();
        }
		return result;
	}

}
