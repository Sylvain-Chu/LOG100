package labo6.src;

import java.util.Scanner;

/**
 * @author CHURLET Sylvain
 */
public class ConsoleApp {

    /*
     * Simulation attributes
     * DO NOT EDIT
     */
    /**
     * Scanner
     */
    private Scanner scan = new Scanner(System.in);

    /**
     * The airport
     */
    private Airport airport = new Airport();
    /**
     * The terminal A
     */
    private Terminal termA = new Terminal("TERMINAL A");
    /**
     * The terminal B
     */
    private Terminal termB = new Terminal("TERMINAL B");
    /**
     * The terminal C
     */
    private Terminal termC = new Terminal("TERMINAL C");
    /**
     * The Gates A
     */
    private Gate[] gatesA = new Gate[3];
    /**
     * The Gates B
     */
    private Gate[] gatesB = new Gate[7];
    /**
     * The Gates C
     */
    private Gate[] gatesC = new Gate[5];

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
        // Create an instance of Flight
        Flight flight = getFlight();

        flight.setStatus(Flight.DELAYED);
        airport.notifyObservers();

        String gate = flight.getGate();
        String terminal = gate.substring(0, 1);
        int gateNumber = Integer.parseInt(gate.substring(2));

        notifyTerminalAndGate(terminal, gateNumber);
    }

    /**
     * Notify the terminal and the gates of a flight's
     */
    private void notifyTerminalAndGate(String terminal, int gateNumber) {
        // Notifie the appropriate terminal and gate
        switch (terminal) {
            case "A":
                termA.notifyObservers();
                gatesA[gateNumber - 1].notifyObservers();
                break;
            case "B":
                termB.notifyObservers();
                gatesB[gateNumber - 1].notifyObservers();
                break;
            case "C":
                termC.notifyObservers();
                gatesC[gateNumber - 1].notifyObservers();
                break;
        }
    }

    /**
     * Gets a flight based on user-provided information.
     * @return The flight find
     */
    private Flight getFlight() {
        // Collect flight information from the console
        System.out.print("Company: ");
        String company = scan.next();

        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        // Create an instance of Flight
        return airport.getFlight(company, flightNumber);
    }

    /**
     * Changes the status of a flight based on user-provided information.
     */
    public void changeGate() {
        Flight flight = getFlight();

        System.out.print("Terminal (A, B, C): ");
        String terminal = scan.next();

        System.out.print("Gate Number: ");
        int gateNumber = scan.nextInt();

        String oldGate = flight.getGate();
        char oldTerminal = oldGate.charAt(0);
        int oldGateNumber = Integer.parseInt(oldGate.substring(2));

        flight.setGate(terminal + "-" + gateNumber);
        if(isGateAvailable(terminal, gateNumber)) {
            if (oldTerminal != terminal.charAt(0)) {
                switch (oldTerminal) {
                    case 'A':
                        termA.removeFlight(flight);
                        gatesA[oldGateNumber - 1].removeFlight(flight);
                        break;
                    case 'B':
                        termB.removeFlight(flight);
                        gatesB[oldGateNumber - 1].removeFlight(flight);
                        break;
                    case 'C':
                        termC.removeFlight(flight);
                        gatesC[oldGateNumber - 1].removeFlight(flight);
                        break;
                }

                airport.notifyObservers();

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

            } else {

                switch (oldTerminal) {
                    case 'A':
                        gatesA[oldGateNumber - 1].removeFlight(flight);
                        break;
                    case 'B':
                        gatesB[oldGateNumber - 1].removeFlight(flight);
                        break;
                    case 'C':
                        gatesC[oldGateNumber - 1].removeFlight(flight);
                        break;
                }

                airport.notifyObservers();

                switch (terminal) {
                    case "A":
                        termA.notifyObservers();
                        gatesA[gateNumber - 1].addFlight(flight);
                        break;
                    case "B":
                        termB.notifyObservers();
                        gatesB[gateNumber - 1].addFlight(flight);
                        break;
                    case "C":
                        termC.notifyObservers();
                        gatesC[gateNumber - 1].addFlight(flight);
                        break;
                }
            }
        }
        else {
            System.out.println("New gate" + terminal + "-" + gateNumber + " is not available");
        }
    }

    /**
     * Verifies if a gate is available
     * @param terminal The terminal
     * @param gateNumber The gate number
     * @return True if the gate is available, false otherwise
     */
    private boolean isGateAvailable(String terminal, int gateNumber) {
        for (Flight f : airport.getFlights()){
            if (f.getGate().equals(terminal + "-" + gateNumber)){
                return false;
            }
        }
        return true;
    }

    /**
     * Cancels a flight based on user-provided information.
     */
    public void cancelFlight() {
        // Create an instance of Flight
        Flight flight = getFlight();

        flight.setStatus(Flight.CANCELLED);
        airport.notifyObservers();

        String gate = flight.getGate();
        String terminal = gate.substring(0, 1);
        int gateNumber = Integer.parseInt(gate.substring(2));

        notifyTerminalAndGate(terminal, gateNumber);
    }

    /**
     * Notifies the airport that a flight has arrived.
     */
    public void notifyBoarding() {
        // Create an instance of Flight
        Flight flight = getFlight();

        flight.setStatus(Flight.BOARDING);
        airport.notifyObservers();

        String gate = flight.getGate();
        String terminal = gate.substring(0, 1);
        int gateNumber = Integer.parseInt(gate.substring(2));

        notifyTerminalAndGate(terminal, gateNumber);
    }

    /**
     * Removes a flight based on user-provided information.
     */
    public void removeFlight() {
        Flight flight = getFlight();

        String gate = flight.getGate();
        String terminal = gate.substring(0, 1);
        int gateNumber = Integer.parseInt(gate.substring(2));

        airport.removeFlight(flight);

        switch (terminal) {
            case "A":
                termA.removeFlight(flight);
                gatesA[gateNumber - 1].removeFlight(flight);
                break;
            case "B":
                termB.removeFlight(flight);
                gatesB[gateNumber - 1].removeFlight(flight);
                break;
            case "C":
                termC.removeFlight(flight);
                gatesC[gateNumber - 1].removeFlight(flight);
                break;
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

}
