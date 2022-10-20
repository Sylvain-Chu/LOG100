package labo6.src;


import java.util.List;

/**
 * @author CHURLET Sylvain
 */
public class GateScreen extends Observer{

    /**
     * The gate
     */
    private Gate gate;

    /**
     * The screen name
     */
    private String screenName;

    /**
     * The default constructor
     * @param gate The gate
     */
    public GateScreen(Gate gate) {
        this.gate = gate;
    }

    /**
     * Get the gate
     * @return Gate The gate of the screen
     */
    public Gate getGate() {
        return gate;
    }

    /**
     * Set the gate
     */
    public void setGate(Gate gate) {
        this.gate = gate;
    }

    /**
     * Get the screen name
     * @return The screen name
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * Set the screen name
     * @param screenName The screen name
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     * Update the screen
     */
    @Override
    public void update() {
        List<Flight> flights = gate.getFlights();

        System.out.println("GATE " + this.getGate().getGateName());

        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
