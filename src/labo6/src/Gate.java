package labo6.src;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CHURLET Sylvain
 */
public class Gate extends Subject{

    /**
     * The name of the gate
     */
    private String gateName;

    /**
     * The list of flights
     */
    private List<Flight> flights;

    /**
     * Get the gate name
     * @return The gate name
     */
    public String getGateName() {
        return gateName;
    }

    /**
     * Set the gate name
     * @param gateName The gate name
     */
    public void setGateName(String gateName) {
        this.gateName = gateName;
    }

    /**
     * Default constructor
     * @param gateName The gate name
     */
    public Gate(String gateName) {
        this.gateName = gateName;
        this.flights = new LinkedList<Flight>();
    }

    /**
     * Empty constructor
     */
    public Gate() {
    }

    /**
     * Add a flight to the gate
     * @param flight The flight to add
     */
    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
        notifyObservers();
    }

    /**
     * Remove a flight from the gate
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

    public boolean isAvailable() {
        return flights.isEmpty();
    }
}