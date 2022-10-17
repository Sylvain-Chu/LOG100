package labo6.src;

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

    }

}
