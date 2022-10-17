package labo6.src;

import java.util.List;

public class AirportScreen extends Observer {

    private Airport airport;
    private String screenName;

    public AirportScreen(Airport airport, String screenName) {
        this.airport = airport;
        this.screenName = screenName;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public void update() {
        List<Flight> flights = airport.getFlights();

        System.out.println(screenName);

        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
