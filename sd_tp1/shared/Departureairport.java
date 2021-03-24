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
    }

    public synchronized void parkAtTransfer() {
    }

    //Hostess
    public synchronized void preparePassBoarding() {
    }

    public synchronized void checkAndWait() {
    }

    public synchronized void planeReadyToTakeoff() {
    }

    public synchronized void waitForNextFlight() {
    }

    //Passenger 
    public synchronized void travelToAirport() {
    }

    public synchronized void waitInQueue() {
    }

    public synchronized void showDocuments() {
    }



}