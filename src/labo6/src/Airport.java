package labo6.src;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CHURLET Sylvain
 */
public class Airport extends Subject {

    /**
     * The list of planes
     */
    private List<Flight> flights;

    /**
     * The default constructor
     */
    public Airport() {
        this.flights = new LinkedList<Flight>();
    }

    /**
     * Add a flight to the airport
     * @param flight The flight to add
     */
    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
        notifyObservers();
    }

    /**
     * Remove a flight from the airport
     * @param flight The flight to remove
     */
    @Override
    public void removeFlight(Flight flight) {
        flights.remove(flight);
        notifyObservers();
    }

    /**
     * Get the list of flights
     * @return The list of flights
     */
    @Override
    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * Get the flight at the given company and number
     * @param company The compagny of the flight
     * @param flightNumber The flight number of the flight
     * @return The flight
     */
    public Flight getFlight(String company, int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber && flight.getCompany().equals(company)) {
                return flight;
            }
        }
        return null;
    }
}
