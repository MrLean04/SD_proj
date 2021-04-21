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
public class Plane implements PilotP, PassengerP, HostessP {

    private final Queue<Integer> inPlane = new LinkedList<>();
    private boolean readyflyPilot=false;
    private boolean passengersGoFly=false;
    private boolean arrived = false;

    public Plane(){
        //
    }

    //Pilot
    @Override
    public synchronized boolean WaitForAllInBoard() {
        //TO-DO
        while (!readyflyPilot) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        passengersGoFly=true;
        notifyAll();
        return true;
    }

    //
    @Override
    public synchronized void Arrived(){
        arrived = true;
        notifyAll();
    }

    //hostess
    @Override
    public synchronized void youCanFly(){
        //to do
        readyflyPilot = true;
        notifyAll();
    }

     //Passenger
    @Override
    public synchronized void BoardThePlane(int id) {
        //TO-DO
        inPlane.add(id);
        while (!passengersGoFly) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

     //Passenger 
    public synchronized boolean WaitingForEndOfFlight() {
        //TO-DO
        while (!arrived) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        } return true;
    }

        
}


