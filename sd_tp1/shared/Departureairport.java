package shared;

import entities.PilotState;
import entities.PassengerState;
import entities.Hostess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Leandro and João
 */
public class Departureairport implements PilotDA, PassengerDA, HostessDA {
    private final int max = 10;
    private final int min = 5;
    private boolean readyForFly = false;
    private final List<Boolean> documentCheck = new LinkedList();
    private final Queue<Integer> documentsQueue = new LinkedList<>();

    //Pilot
    public synchronized void readyForBoarding() {
        //TO-DO
    }

    public synchronized void parkAtTransfer() {
    //TO-DO
    }

    //Hostess
    public synchronized void preparePassBoarding() {
    //TO-DO
    }

    public synchronized void checkAndWait() {
    //TO-DO
    }

    public synchronized void planeReadyToTakeoff() {
    //TO-DO
    }

    public synchronized void waitForNextFlight() {
    //TO-DO
    }

    //Passenger 
    public synchronized void travelToAirport() {
    //TO-DO
    }

    public synchronized void waitInQueue() {
    //TO-DO
    }

    public synchronized void showDocuments() {
    //TO-DO
    }



}