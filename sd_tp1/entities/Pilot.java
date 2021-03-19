package entities;

import shared.PilotDA ;
import shared.PilotP;
import shared.PilotDSA ;


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