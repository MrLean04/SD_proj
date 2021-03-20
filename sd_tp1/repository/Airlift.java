package repository;

import entities.PilotState;
import entities.HostessState;
import entities.PassengerState;
import genclass.GenericIO;
import genclass.TextFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Leandro e João
 */
public class Airlift {
	//private int count=0;

    private int nPassengers;
	private PassengerState[] PassengerStates;	
	private PilotState PilotState;
    private HostessState HostessState;
	
    private String fileName = "Airlift.log";

    public Airlift(int nPassengers, String fileName) {
		this.nPassengers = nPassengers;
		PassengerStates = new PassengerState[nPassengers];
    
        for (int i = 0; i < nPassengers; i++) {
			PassengerStates[i] = PassengerState.values()[0];
		}
		PilotState = PilotState.values()[0];
        HostessState = HostessState.values()[0];
		
        if ((fileName != null) && !("".equals(fileName))) {
            this.fileName = fileName;
        }
    
    }

}