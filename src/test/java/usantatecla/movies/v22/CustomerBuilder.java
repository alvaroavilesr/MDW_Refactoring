package usantatecla.movies.v22;

import usantatecla.movies.v21.Customer;
import usantatecla.movies.v21.Rental;

import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder {

	private String name;
	private List<usantatecla.movies.v21.Rental> rentals;
	
	public CustomerBuilder() {
		rentals = new ArrayList<usantatecla.movies.v21.Rental>();
	}
	
	public CustomerBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public CustomerBuilder rental(usantatecla.movies.v21.Rental rental) {
		rentals.add(rental);
		return this;
	}
	
	public usantatecla.movies.v21.Customer build() {
		usantatecla.movies.v21.Customer customer = new Customer(name);
		for(Rental rental : rentals) {
			customer.addRental(rental);
		}
		return customer;
	}
}
