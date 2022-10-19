package labo6.src;


public class Flight {
    private String company;
    private int flightNumber;
    private String destination;
    private int departureTime;
    private String gate;
    private String status;

    public static final String ONTIME = "ON TIME";
    public static final String DELAYED = "DELAYED";
    public static final String CANCELLED = "CANCELLED";
    public static final String BOARDING = "BOARDING";

    public Flight(String company, int flightNumber, String destination, int departureTime, String gate, String status) {
        this.company = company;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return company + flightNumber + " " + destination + " " + departureTime + " " + gate + " " + status;
    }

    public static void main(String[] args) {
        Flight flight = new Flight("KLM", 873, "NewYork", 0024, "A1", Flight.ONTIME);
        System.out.println(flight.getDepartureTime());
    }
}
