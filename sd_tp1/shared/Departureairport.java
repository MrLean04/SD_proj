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
    private int nPassengerCheck = 0;
    private boolean guyinqueue = false;
    private int nextPassenger = -1;
    private boolean pilotInpark = false;
    private boolean pilotready = false;
    private boolean inaArraivalAir = false;
    private boolean readyflyPilot = false;
    private boolean readyflyPassenger = false;
    //private boolean readyfly=false;
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
        notifyAll();
    }

    @Override
    public synchronized void readyForBoarding() {
        pilotready = true;
    }

    @Override
    public synchronized void WaitForBoarding() {
        //notifyAll();    
    }

    // Hostess

    @Override
    public synchronized boolean queueNotEmpty(){
        if(inQueue.size() != 0) return true;
        return false;
    }

    @Override
    public synchronized boolean hostessJobDone() {
        if (inQueue.size() == 0 && guyinqueue==true) {
            return true;
        }
        return false;
    }

    
    @Override
    public synchronized void preparePassBoarding() {
            readyForCheckDoc = true;
    }

    @Override
    public synchronized void checkAndWait() {
        // TO-DO

        if (inQueue.size() != 0) {
            notifyAll();
            while (!readyForCheckDoc) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
        }

        System.out.println(inQueue.toString());
        nextPassenger = inQueue.poll();
        documentCheck.replace(nextPassenger, false, true);
        nPassengerCheck++;
        System.out.println(documentCheck);
    }
    
    @Override
    public synchronized boolean planeReadyToTakeoff() {
        if (nPassengerCheck== 10) {
            readyForCheckDoc = false;
            readyflyPilot =true;
            readyflyPassenger = true;
            pilotInpark=false;
            notifyAll();
            return true;
        }
        return false;
    }
    @Override
    public synchronized int numberPassCheck(){
        return nPassengerCheck;
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
    // Passenger
    @Override
    public synchronized void travelToAirport() {
        // TO-DO
    }

    @Override
    public synchronized boolean waitinQueueFlight(int id) {
        // TO-DO
            while (!readyflyPassenger){
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            return true;
    }

    @Override
    public synchronized void waitInQueue(int id, PassengerState state) {
        
        if(!inQueue.contains(id)){
            inQueue.add(id);
            guyinqueue = true;
            documentCheck.put(id, false);
        }
        

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

    @Override
    public synchronized int planeSize(){
        return inPlane.size();
    }
}