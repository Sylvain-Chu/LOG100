package labo6.src;

/**
 * @author CHURLET Sylvain
 */
public class Flight {
    /**
     * The company of the flight
     */
    private String company;
    /**
     * The flight number
     */
    private int flightNumber;
    /**
     * The flight destination
     */
    private String destination;
    /**
     * The flight departure
     */
    private int departureTime;
    /**
     * The flight gate
     */
    private String gate;
    /**
     * The flight status
     */
    private String status;

    /**
     * The constant use for the status : ON TIME
     */
    public static final String ONTIME = "ON TIME";
    /**
     * The constant use for the status : DELAYED
     */
    public static final String DELAYED = "DELAYED";
    /**
     * The constant use for the status : CANCELED
     */
    public static final String CANCELLED = "CANCELLED";
    /**
     * The constant use for the status : ARRIVED
     */
    public static final String BOARDING = "BOARDING";

    /**
     * The default constructor
     * @param company The company of the flight
     * @param flightNumber The flight number
     * @param destination The flight destination
     * @param departureTime The flight departure
     * @param gate The flight gate
     * @param status The flight status
     */
    public Flight(String company, int flightNumber, String destination, int departureTime, String gate, String status) {
        this.company = company;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
    }

    /**
     * Get the company of the flight
     * @return The company of the flight
     */
    public String getCompany() {
        return company;
    }

    /**
     * Set the company of the flight
     * @param company The company of the flight
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Get the flight number
     * @return The flight number
     */
    public int getFlightNumber() {
        return flightNumber;
    }

    /**
     * Set the flight number
     * @param flightNumber The flight number
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Get the flight destination
     * @return The flight destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Set the flight destination
     * @param destination The flight destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Get the flight departure
     * @return The flight departure
     */
    public int getDepartureTime() {
        return departureTime;
    }

    /**
     * Set the flight departure
     * @param departureTime The flight departure
     */
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Get the flight gate
     * @return The flight gate
     */
    public String getGate() {
        return gate;
    }

    /**
     * Set the flight gate
     * @param gate The flight gate
     */
    public void setGate(String gate) {
        this.gate = gate;
    }

    /**
     * Get the flight status
     * @return The flight status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the flight status
     * @param status The flight status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the string representation of the flight
     * @return The string representation of the flight
     */
    @Override
    public String toString() {
        return company + flightNumber + " " + destination + " " + departureTime + " " + gate + " " + status;
    }
}
