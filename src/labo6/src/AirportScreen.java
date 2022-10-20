package labo6.src;

import java.util.List;

/**
 * @author CHURLET Sylvain
 */
public class AirportScreen extends Observer {

    /**
     * The airport
     */
    private Airport airport;

    /**
     * The screen name
     */
    private String screenName;

    /**
     * The default constructor
     * @param airport The airport
     * @param screenName The screen name
     */
    public AirportScreen(Airport airport, String screenName) {
        this.airport = airport;
        this.screenName = screenName;
    }

    /**
     * Get the airport
     * @return Airport The airport of the screen
     */
    public Airport getAirport() {
        return airport;
    }

    /**
     * Set the airport
     */
    public void setAirport(Airport airport) {
        this.airport = airport;
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
        List<Flight> flights = airport.getFlights();

        System.out.println(screenName);

        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
