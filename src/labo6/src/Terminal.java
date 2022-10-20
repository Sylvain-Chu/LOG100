package labo6.src;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CHURLET Sylvain
 */
public class Terminal extends Subject {

    /**
     * The name of the terminal
     */
    private String terminalName;

    /**
     * The gate of the terminal
     */
    private Gate gate;


    /**
     * List of flights
     */
    private List<Flight> flights;

    /**
     * Default constructor
     * @param terminalName The terminal name
     */
    public Terminal(String terminalName) {
        this.terminalName = terminalName;
        this.flights = new LinkedList<Flight>();
    }

    /**
     * Get the terminal name
     * @return The terminal name
     */
    public String getTerminalName() {
        return terminalName;
    }

    /**
     * Set the terminal name
     * @param terminalName The terminal name
     */
    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    /**
     * Get the gate
     * @return The gate
     */
    public Gate getGate() {
        return gate;
    }

    /**
     * Set the gate
     * @param gate The gate
     */
    public void setGate(Gate gate) {
        this.gate = gate;
    }

    /**
     * Add a flight to the terminal
     * @param flight The flight to add
     */
    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
        notifyObservers();
    }

    /**
     * Remove a flight from the terminal
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
}
