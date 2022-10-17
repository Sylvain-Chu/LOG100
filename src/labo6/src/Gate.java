package labo6.src;

import java.util.List;

public class Gate extends Subject{
    private String gateName;

    private List<Flight> flights;

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }

    public Gate(String gateName) {
        this.gateName = gateName;
    }

    public Gate() {
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
}
