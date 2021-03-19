package entities;

import shared.PilotDA ;
import shared.PilotP;
import shared.PilotDSA ;
import java.util.*;


public class Pilot extends Thread{

    private PilotState state;
	private final PilotDA Departureairport;
	private final PilotP Plane;
	private final PilotDSA Destinationairport; 
    

	/**
	 * Pilot's constructor.
	 *
	 * @param Departureairport
	 * @param Plane
	 * @param Destinationairport
	 */
	public Pilot(PilotDA Departureairport, PilotP Plane, PilotDsA Destinationairport) {
		this.DepartureAirport = DepartureAirport;
		this.Plane = Plane;
		this.DestinationAirport = DestinationAirport;
	}

	@Override
	public void run() {
		this.setPilotState(PilotState.GOING_TO_AIRPORT);
		//while (!this.happyCustomer) {
			switch (this.state) {
				case  AT_TRANSFER_GATE:
					System.out.println("AT_TRANSFER_GATE ");
					setPilotState(PilotState.READY_FOR_BOARDING);
					break;

				case  READY_FOR_BOARDING:
					System.out.println(" READY_FOR_BOARDING ");					
					setPilotState(PilotState.WAIT_FOR_BOARDING );
					break;
				
				case  WAIT_FOR_BOARDING:
					System.out.println(" READY_FOR_BOARDING ");					
					setPilotState(PilotState.FLYING_FORWARD );
					break;
					
				case  FLYING_FORWARD:
					System.out.println("FLYING_FORWARD ");					
					setPilotState(PilotState.DEBOARDING );
					break;
				
				case  DEBOARDING:
					System.out.println("DEBOARDING ");					
					setPilotState(PilotState.FLYING_BACK );
					break;
				
				case FLYING_BACK:
					System.out.println("FLYING BACK");					
					setPilotState(PilotState.AT_TRANSFER_GATE);
					break;
			}
		//}
	}


    /**
	 * Pilot's method. Change state of pilot and report status to log.
	 *
	 * @param state state of Pilot
	 */
	private void setPilotState(PilotState state) {
		if (state == this.state) {
			return;
		}
		this.state = state;
	}

	/**
	 * Pilot's method. Retrieves pilot's state.
	 *
	 * @return pilot's state
	 */
	private PilotState getPilotState() {
		return this.state;
	}

}