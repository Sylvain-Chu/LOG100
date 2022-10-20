package labo6.src;

import java.util.List;

/**
 * @author CHURLET Sylvain
 */
public class TerminalScreen extends Observer {

    /**
     * The terminal
     */
    private Terminal terminal;

    /**
     * The screen name
     */
    private String screenName;

    /**
     * The default constructor
     * @param terminal The terminal
     * @param screenName The screen name
     */
    public TerminalScreen(Terminal terminal, String screenName) {
        this.terminal = terminal;
        this.screenName = screenName;
    }

    /**
     * Get the terminal
     * @return Terminal The terminal of the screen
     */
    public Terminal getTerminal() {
        return terminal;
    }

    /**
     * Set the terminal
     */
    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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
        List<Flight> flights = terminal.getFlights();

        System.out.println(screenName);

        for (Flight flight : flights) {
            System.out.println(flight);
        }

    }

}
