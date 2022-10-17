package labo6.src;

import java.util.List;

public class Airport extends Subject {

    private List<Flight> flights;

    public Airport() {
    }

    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
        super.notifyObservers();
    }

    @Override
    public void removeFlight(Flight flight) {
        flights.remove(flight);
        super.notifyObservers();
    }

    @Override
    public List<Flight> getFlights() {
        return flights;
    }

    public Flight getFlight(int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

}
