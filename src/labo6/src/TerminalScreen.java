package labo6.src;

import java.util.List;

public class TerminalScreen extends Observer {
    private Terminal terminal;
    private String screenName;

    public TerminalScreen(Terminal terminal, String screenName) {
        this.terminal = terminal;
        this.screenName = screenName;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public void update() {
        List<Flight> flights = terminal.getFlights();

        System.out.println(screenName);

        for (Flight flight : flights) {
            System.out.println(flight);
        }

    }

}
