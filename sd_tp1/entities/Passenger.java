package entities;

import java.lang.ref.Cleaner;
import java.util.*;
import shared.PassengerDA;
import shared.PassengerP;
import shared.PassengerDSA ;


public class Passenger extends Thread{

    private PassengerState state;
    private final int id;
	private final PassengerDA Departureairport;
	private final PassengerP Plane;
	private final PassengerDSA Destinationairport; 
	private boolean happyPassenger = false;
    

	/**
	 * Passenger's constructor.
	 *
	 * @param Departureairport
	 * @param Plane
	 * @param Destinationairport
     * @param id
	 */ 
	public Passenger(PassengerDA Departureairport, PassengerP Plane, PassengerDSA Destinationairport, int id) {
		this.Departureairport = Departureairport;
		this.Plane = Plane;
		this.Destinationairport = Destinationairport;
        this.id = id;
	} 

	@Override
	public void run() {
		this.setPassengerState(PassengerState.GOING_TO_AIRPORT);
		while (!this.happyPassenger) {
			switch (this.state) {
				case  GOING_TO_AIRPORT:
					System.out.println("GOING_TO_AIRPORT " + id);
					setPassengerState(PassengerState.IN_QUEUE);
					break;

				case  IN_QUEUE:
					//System.out.println("IN_QUEUE " + id);
					Departureairport.waitInQueue(id,state);
					boolean check = Departureairport.waitinQueueFlight();  //Departureairport.showDocuments(id);
					if (check){				
						setPassengerState(PassengerState.IN_FLIGHT );
					}	
					break;
				
				case  IN_FLIGHT:
					System.out.println("IN_FLIGHT " + id);					
					setPassengerState(PassengerState.AT_DESTINATION );
					break;
					
				case   AT_DESTINATION:
					System.out.println("AT_DESTINATION " + id);					
					//setPassengerState(PassengerState.GOING_TO_AIRPORT );
					Destinationairport.Deboarding(id);
					this.happyPassenger = true;
					break;
			}
		}
	}

    /**
	 * Passenger's method. Change state of passenger and report status to log.
	 *
	 * @param state state of passenger
	 */
	private void setPassengerState(PassengerState state) {
		if (state == this.state) {
			return;
		}
		this.state = state;
	}

	/**
	 * Passenger's method. Retrieves passenger's state.
	 *
	 * @return passenger's state
	 */
	private PassengerState getPassengersState() {
		return this.state;
	}

    /**
	 * Passenger's method. Retrieves passenger's id.
	 *
	 * @return passenger's id
	 */
	private int getPassengerId() {
		return this.id;
	}

}