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
    int nPassengerPlane = 0;
    private int nextPassenger = -1;
    private boolean pilotInpark = false;
    private boolean pilotready = false;
    private boolean inaArraivalAir = false;
    private boolean readyfly = false;
    private boolean readyForCheckDoc = false;
    private final HashMap<Integer, Boolean> documentCheck = new HashMap<>();
    private final Queue<Integer> inQueue = new LinkedList<>();
    private final Queue<Integer> inPlane = new LinkedList<>();
    private final Queue<Integer> inqueueforboarding = new LinkedList<>();
    private final Queue<Integer> documentsQueue = new LinkedList<>();

    public Departureairport() {
        //
    }

    // Pilot
    @Override
    public synchronized void parkAtTransfer() {
        pilotInpark = true;
        readyfly= false;
    }

    @Override
    public synchronized void readyForBoarding() {
        pilotready = true;
    }

    @Override
    public synchronized void WaitForBoarding() {
        notifyAll();
        while (!planeReadyToTakeoff()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    // Hostess
    @Override
    public synchronized void preparePassBoarding() {
        if (pilotInpark && pilotready) {
            readyForCheckDoc = true;
        }

    }

    @Override
    public synchronized void checkAndWait() {
        // TO-DO

        if (inQueue.size() == 0)
            try {
                wait();
            } catch (InterruptedException e) {
            }

        System.out.println(inQueue.toString());
        nextPassenger = inQueue.poll();
        //System.out.println(nextPassenger + " entrei na queue");
        documentCheck.replace(nextPassenger, false, true);
        inPlane.add(nextPassenger);
        nPassengerPlane++;
        notifyAll();
        System.out.println(documentCheck);

    }

    @Override
    public synchronized boolean planeReadyToTakeoff() {
        if (inPlane.size() == 10) {
            readyForCheckDoc = false;
            readyfly =true;
            return readyfly;
        }
        return readyfly;
    }

    @Override
    public synchronized void waitForNextFlight() {
        // TO-DO
        if (inQueue.size() != 0) {
            notifyAll();
            while (!pilotInpark) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    @Override
    public synchronized boolean hostessJobDone() {
        if (inQueue.size() == 0) {
            return true;
        }
        return false;
    }

    // Passenger
    @Override
    public synchronized void travelToAirport() {
        // TO-DO
    }

    @Override
    public synchronized boolean waitinQueueFlight() {
        // TO-DO
        notifyAll();
        while (!planeReadyToTakeoff()) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (planeReadyToTakeoff())
            return true;
        return false;
    }

    @Override
    public synchronized void waitInQueue(int id, PassengerState state) {
        inQueue.add(id);
        documentCheck.put(id, false);

        notifyAll();
        while (nextPassenger != id && readyForCheckDoc) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public synchronized boolean showDocuments(int id) {
        // TO-DO
        boolean temp = documentCheck.get(id);
        return documentCheck.get(id);
    }
}