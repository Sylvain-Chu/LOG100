package labo6.src;

import java.util.List;

public class GateScreen extends Observer{
    private Gate gate;
    private String screenName;

    public GateScreen(Gate gate) {
        this.gate = gate;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public void update() {
        List<Flight> flights = gate.getFlights();

        System.out.println(screenName);

        for (Flight flight : flights) {
            System.out.println(flight);
        }

    }
}
