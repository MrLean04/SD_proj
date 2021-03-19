package entities;
import java.util.*;
import shared.HostessDA ;
import shared.HostessP;
import shared.HostessDSA ;


public class Hostess extends Thread{

    private HostessState state;
	/** 
	private final HostessDA Departureairport;
	private final HostessP Plane;
	private final HostessDSA Destinationairport; */
    

	/**
	 * Hostess's constructor.
	 *
	 * @param Departureairport
	 * @param Plane
	 * @param Destinationairport
	 
	public Pilot(HostessDA Departureairport, HostessP Plane, HostessDsA Destinationairport) {
		this.DepartureAirport = DepartureAirport;
		this.Plane = Plane;
		this.DestinationAirport = DestinationAirport;
	}*/

	@Override
	public void run() {
		this.setHostessState(HostessState.WAIT_FOR_NEXT_FLIGHT);
		//while (!this.happyCustomer) {
			switch (this.state) {
				case  WAIT_FOR_NEXT_FLIGHT:
					System.out.println("WAIT_FOR_NEXT_FLIGHT");
					setHostessState(HostessState.WAIT_FOR_PASSENGER);
					break;

				case  WAIT_FOR_PASSENGER:
					System.out.println("WAIT_FOR_PASSENGER");					
					setHostessState(HostessState.CHECK_PASSENGER );
					break;
				
				case  CHECK_PASSENGER:
					System.out.println("CHECK_PASSENGER");					
					setHostessState(HostessState.READY_TO_FLY );
					break;
					
				case   READY_TO_FLY:
					System.out.println("READY_TO_FLY");					
					setHostessState(HostessState.WAIT_FOR_NEXT_FLIGHT );
					break;
			}
		//}
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