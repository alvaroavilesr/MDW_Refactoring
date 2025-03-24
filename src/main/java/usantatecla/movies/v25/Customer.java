package usantatecla.movies.v25;

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
		StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
		for (Rental each : this.rentals) {
			result.append("\t")
					.append(each.getMovie().getTitle())
					.append("\t")
					.append(each.getCharge())
					.append("\n");
		}
		result.append("Amount owed is ")
				.append(this.getTotalCharge())
				.append("\n");
		result.append("You earned ")
				.append(this.getTotalFrequentRenterPoints())
				.append(" frequent renter points");
		return result.toString();
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
