package labo6.src;

import java.util.List;

public class Terminal extends Subject {
    private String terminalName;
    private Gate gate;


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

    }

    @Override
    public void removeFlight(Flight flight) {

    }

    @Override
    public List<Flight> getFlights() {
        return null;
    }
}
