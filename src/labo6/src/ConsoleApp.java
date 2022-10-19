package labo6.src;

import java.util.Scanner;

public class ConsoleApp {

    /*
     * Simulation attributes
     * DO NOT EDIT
     */

    private Scanner scan = new Scanner(System.in);

    private Airport airport = new Airport();
    private Terminal termA = new Terminal("TERMINAL A");
    private Terminal termB = new Terminal("TERMINAL B");
    private Terminal termC = new Terminal("TERMINAL C");
    private Gate[] gatesA = new Gate[3];
    private Gate[] gatesB = new Gate[7];
    private Gate[] gatesC = new Gate[5];

    /**
     * Creates the objects used for the simulation.
     * DO NOT EDIT
     */
    public void createObjects() {

        // Airport screens

        AirportScreen airportScreen1 = new AirportScreen(airport, "AIRPORT (1)");
        AirportScreen airportScreen2 = new AirportScreen(airport, "AIRPORT (2)");
        airport.attach(airportScreen1);
        airport.attach(airportScreen2);

        // Terminal screens (three each)

        TerminalScreen termAScreen1 = new TerminalScreen(termA, "TERMINAL A (1)");
        TerminalScreen termAScreen2 = new TerminalScreen(termA, "TERMINAL A (2)");
        TerminalScreen termAScreen3 = new TerminalScreen(termA, "TERMINAL A (3)");
        termA.attach(termAScreen1);
        termA.attach(termAScreen2);
        termA.attach(termAScreen3);

        TerminalScreen termBScreen1 = new TerminalScreen(termB, "TERMINAL B (1)");
        TerminalScreen termBScreen2 = new TerminalScreen(termB, "TERMINAL B (2)");
        TerminalScreen termBScreen3 = new TerminalScreen(termB, "TERMINAL B (3)");
        termB.attach(termBScreen1);
        termB.attach(termBScreen2);
        termB.attach(termBScreen3);

        TerminalScreen termCScreen1 = new TerminalScreen(termC, "TERMINAL C (1)");
        TerminalScreen termCScreen2 = new TerminalScreen(termC, "TERMINAL C (2)");
        TerminalScreen termCScreen3 = new TerminalScreen(termC, "TERMINAL C (3)");
        termC.attach(termCScreen1);
        termC.attach(termCScreen2);
        termC.attach(termCScreen3);

        // Gates and gate screens

        // Terminal A
        for (int i = 0; i < gatesA.length; ++i) {
            gatesA[i] = new Gate("A-" + (i + 1));
            gatesA[i].attach(new GateScreen(gatesA[i]));
        }

        // Terminal B
        for (int i = 0; i < gatesB.length; ++i) {
            gatesB[i] = new Gate("B-" + (i + 1));
            gatesB[i].attach(new GateScreen(gatesB[i]));
        }

        // Terminal C
        for (int i = 0; i < gatesC.length; ++i) {
            gatesC[i] = new Gate("C-" + (i + 1));
            gatesC[i].attach(new GateScreen(gatesC[i]));
        }
    }

    /**
     * Adds a new flight based on user-provided information.
     */
    public void addFlight() {

        // Collect flight information from the console

        System.out.print("Company: ");
        String company = scan.next();

        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        System.out.print("Destination: ");
        String destination = scan.next();

        System.out.print("Departure Time (0000): ");
        int departureTime = scan.nextInt();

        System.out.print("Terminal (A, B, C): ");
        String terminal = scan.next();

        System.out.print("Gate Number: ");
        int gateNumber = scan.nextInt();

        System.out.println("Status:");
        System.out.println("1 - " + Flight.ONTIME);
        System.out.println("2 - " + Flight.CANCELLED);
        System.out.println("3 - " + Flight.BOARDING);
        System.out.println("4 - " + Flight.DELAYED);
        int statusInt = scan.nextInt();
        String statusStr = "";
        switch (statusInt) {
            case 1:
                statusStr = Flight.ONTIME;
                break;
            case 2:
                statusStr = Flight.CANCELLED;
                break;
            case 3:
                statusStr = Flight.BOARDING;
                break;
            case 4:
                statusStr = Flight.DELAYED;
                break;
        }

        // Create an instance of Flight
        Flight flight = new Flight(company, flightNumber, destination,
                departureTime, terminal + "-" + gateNumber, statusStr);

        // Add it to the airport's list of flights
        airport.addFlight(flight);

        // Add it to the appropriate terminal and gate
        switch (terminal) {
            case "A":
                termA.addFlight(flight);
                gatesA[gateNumber - 1].addFlight(flight);
                break;
            case "B":
                termB.addFlight(flight);
                gatesB[gateNumber - 1].addFlight(flight);
                break;
            case "C":
                termC.addFlight(flight);
                gatesC[gateNumber - 1].addFlight(flight);
                break;
        }
    }

    /**
     * Removes a flight based on user-provided information.
     */
    public void delayFlight() {
        // Collect flight information from the console
        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        // Create an instance of Flight
        Flight flight = airport.getFlight(flightNumber);

        // Verify that the flight exists
        if (flight != null) {
            // Delay the flight
            flight.setStatus(Flight.DELAYED);
            System.out.print("The flight is delayed");
        } else {
            System.out.println("Flight not found.");
        }
    }

    /**
     * Changes the status of a flight based on user-provided information.
     */
    public void changeGate() {
        //TODO implement this method
    }

    /**
     * Cancels a flight based on user-provided information.
     */
    public void cancelFlight() {
        // Collect flight information from the console
        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        // Create an instance of Flight
        Flight flight = airport.getFlight(flightNumber);

        // Verify that the flight exists
        if (flight != null) {
            // Cancel the flight
            flight.setStatus(Flight.CANCELLED);
            System.out.print("The flight is cancelled");
        } else {
            System.out.println("Flight not found.");
        }
    }

    /**
     * Notifies the airport that a flight has arrived.
     */
    public void notifyBoarding() {
        // Collect flight information from the console
        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        // Create an instance of Flight
        Flight flight = airport.getFlight(flightNumber);

        // Verify that the flight exists
        if (flight != null) {
            // Notify the airport that the flight has arrived
            flight.setStatus(Flight.BOARDING);
            System.out.print("The flight is boarding");
        } else {
            System.out.println("Flight not found.");
        }
    }

    /**
     * Removes a flight based on user-provided information.
     */
    public void removeFlight() {
        //TODO implement this method
        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();
        Flight flight = airport.getFlight(flightNumber);
        if (flight != null) {
            airport.removeFlight(flight);
        } else {
            System.out.println("Flight not found.");
        }
    }

    /**
     * Displays the options available in the console.
     * DO NOT EDIT
     */
    public void displayMenu() {
        System.out.println("********************");
        System.out.println("1 - Add Flight");
        System.out.println("2 - Delay Flight");
        System.out.println("3 - Change Gate");
        System.out.println("4 - Cancel Flight");
        System.out.println("5 - Notify Boarding");
        System.out.println("6 - Remove Flight");
        System.out.println("0 - Quit");
        System.out.println("********************");
    }

    /**
     * Displays the choice menu, waits for the user input, and calls the appropriate method.
     * DO NOT EDIT
     */
    public void displayPrompt() {
        int option = 0;

        do {
            displayMenu();
            System.out.print("Select Option: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    delayFlight();
                    break;
                case 3:
                    changeGate();
                    break;
                case 4:
                    cancelFlight();
                    break;
                case 5:
                    notifyBoarding();
                    break;
                case 6:
                    removeFlight();
                    break;
                case 0:
                    scan.close();
                    break;
                default:
                    System.out.println("Error - stop");
                    scan.close();
                    return;
            }
        } while (option != 0); // While the option is not Quit
    }

    /**
     * Creates all the objects and starts the simulation.
     * DO NOT EDIT
     */
    public static void main(String[] args) {
        ConsoleApp app = new ConsoleApp();

        // Object setup
        app.createObjects();

        // Start the simulation
        app.displayPrompt();
    }

}
