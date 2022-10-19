package labo6.src;

import java.util.LinkedList;
import java.util.List;

public class Airport extends Subject {

    private List<Flight> flights;

    public Airport() {
        this.flights = new LinkedList<Flight>();
    }

    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
        notifyObservers();
    }

    @Override
    public void removeFlight(Flight flight) {
        flights.remove(flight);
        notifyObservers();
    }

    @Override
    public List<Flight> getFlights() {
        return flights;
    }

    public Flight getFlight(String company, int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber && flight.getCompany().equals(company)) {
                return flight;
            }
        }
        return null;
    }
}
