package entities;

import shared.HostessDA ;
import shared.HostessP;
import shared.HostessDSA ;


public class Hostess extends Thread{

    private HostessState state;
	private final HostessDA Departureairport;
	private final HostessP Plane;
	private final HostessDSA Destinationairport; 
    

	/**
	 * Hostess's constructor.
	 *
	 * @param Departureairport
	 * @param Plane
	 * @param Destinationairport
	 */
	public Pilot(HostessDA Departureairport, HostessP Plane, HostessDsA Destinationairport) {
		this.DepartureAirport = DepartureAirport;
		this.Plane = Plane;
		this.DestinationAirport = DestinationAirport;
	}


    /**
	 * Hostess's method. Change state of hostess and report status to log.
	 *
	 * @param state state of hostess
	 */
	private void setHostessState(HostessState state) {
		if (state == this.state) {
			return;
		}
		this.state = state;
	}

	/**
	 * Hostess's method. Retrieves hostess's state.
	 *
	 * @return hostess's state
	 */
	private HostessState getHostessState() {
		return this.state;
	}

}