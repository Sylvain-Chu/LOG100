package labo6.src;

import java.util.List;

public class Terminal extends Subject {
    private String terminalName;
    private Gate gate;

    private List<Flight> flights;

    public Terminal(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
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
