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
    int nPassengerPlane=0;
    private int nextPassenger=-1;
    private boolean readyForFly = false;
    boolean readyfly = false;
    private boolean readyForCheckDoc = false;
    private final HashMap<Integer, Boolean> documentCheck = new HashMap<>();
    private final Queue<Integer> inQueue = new LinkedList<>();
    private final Queue<Integer> documentsQueue = new LinkedList<>();

    public Departureairport(){
        //
    }
    //Pilot
    public synchronized void readyForBoarding() {
        //TO-DO
    }

    public synchronized void parkAtTransfer() {
    //TO-DO
    }

    //Hostess
    @Override
    public synchronized void preparePassBoarding() {
    //TO-DOy
    
    }
    @Override
    public synchronized boolean checkAndWait() {
    //TO-DO

        if(inQueue.size()==0)
            try {
                wait();
            } catch (InterruptedException e) { }

        System.out.println(inQueue.toString());
        nextPassenger = inQueue.poll(); 
        System.out.println(nextPassenger+ " entrei na queue");
        documentCheck.replace(nextPassenger, false, true);
        
        nPassengerPlane++; 
        notifyAll();
        System.out.println(nextPassenger);
        System.out.println(documentCheck);
                                 
       

        if(nPassengerPlane == 10) //inQueue.size() == 0 || 
            return true;
        //readyForCheckDoc = false;
        return false;
    }
    @Override
    public synchronized void planeReadyToTakeoff() {
    //TO-DO
    }
    @Override
    public synchronized void waitForNextFlight() {
    //TO-DO
    }

    //Passenger 
    @Override
    public synchronized void travelToAirport() {
    //TO-DO
    }
    @Override
    public synchronized void waitInQueue(int id, PassengerState state) {
    //TO-DO
        inQueue.add(id);
        documentCheck.put(id, false);
        
        notifyAll();
        while (nextPassenger!= id ) { //!readyForCheckDoc
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        
        
        //inQueue.remove(id);
    }
    @Override
    public synchronized boolean showDocuments(int id) {
    //TO-DO
        boolean temp = documentCheck.get(id);       
        return  documentCheck.get(id);
    }
    @Override
    public synchronized void readyForCheck(){
        readyForCheckDoc = true;

    }



}