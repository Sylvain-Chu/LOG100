package labo6.src;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CHURLET Sylvain
 */
public abstract class Subject {

    /**
     * The list of observers
     */
    public List<Observer> listObservers = new LinkedList<Observer>();

    /**
     * Add an observer
     * @param o The observer to add
     */
    public void attach(Observer o) {
        listObservers.add(o);
    }

    /**
     * Remove an observer
     * @param o The observer to remove
     */
    public void detach(Observer o) {
        listObservers.remove(o);
    }

    /**
     * Notify the observers
     */
    public void notifyObservers() {
        for (Observer obv : listObservers) {
            obv.update();
        }
    }

    /**
     * Add a flight to the subject
     * @param flight The flight to add
     */
    public abstract void addFlight(Flight flight);

    /**
     * Remove a flight from the subject
     * @param flight The flight to remove
     */
    public abstract void removeFlight(Flight flight);

    /**
     * Get the list of flights
     * @return The list of flights
     */
    public abstract List<Flight> getFlights();

}
