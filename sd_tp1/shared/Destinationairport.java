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
public class Destinationairport implements PilotDSA, PassengerDSA, HostessDSA {
    private final Queue<Integer> inDestinationAirport = new LinkedList<>();

    public Destinationairport(){// 
    }
     //Pilot
    @Override
    public synchronized boolean AnnounceArrival() {
        //TO-DO
        if(inDestinationAirport.size() == 20) return true;
        return false;
    }
    //Passenger
    @Override
    public synchronized boolean Deboarding(int id) {
        //TO-DO
        inDestinationAirport.add(id);
        //System.out.println("chegamos" + inDestinationAirport);
        return false;
    }
}