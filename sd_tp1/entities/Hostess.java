package entities;
import java.util.*;
import shared.HostessDA ;
import shared.HostessP;
import shared.HostessDSA ;


public class Hostess extends Thread{

    private HostessState state;
	boolean happyhostess=false;
	private final HostessDA Departureairport;
	private final HostessP Plane;
	private final HostessDSA Destinationairport; 
    

	/**
	 * Hostess's constructor.
	 *
	 * @param Departureairport
	 * @param Plane
	 * @param Destinationairport */	 
	public Hostess(HostessDA Departureairport, HostessP Plane, HostessDSA Destinationairport) {
		this.Departureairport = Departureairport;
		this.Plane = Plane;
		this.Destinationairport = Destinationairport;
	}

	@Override
	public void run() {
		this.setHostessState(HostessState.WAIT_FOR_PASSENGER);
		while (!happyhostess) {
			switch (this.state) {
				case  WAIT_FOR_PASSENGER:
					System.out.println("WAIT_FOR_PASSENGER");
					if(Departureairport.queueNotEmpty()){
						setHostessState(HostessState.CHECK_PASSENGER );
					}
					break;
				
				case  CHECK_PASSENGER:
					if(!Departureairport.hostessJobDone()){
						System.out.println("CHECK_PASSENGER");
						Departureairport.preparePassBoarding();
						Departureairport.checkAndWait();					
						boolean ready = Departureairport.planeReadyToTakeoff();
						if (ready){
							Plane.youCanFly();				
							setHostessState(HostessState.READY_TO_FLY );
						}
					}else happyhostess = true;
					break;
					
				case  READY_TO_FLY:
					System.out.println("READY_TO_FLY");										
					setHostessState(HostessState.WAIT_FOR_NEXT_FLIGHT );
					break;
				case  WAIT_FOR_NEXT_FLIGHT:
					System.out.println("WAIT_FOR_NEXT_FLIGHT");
					Departureairport.waitForNextFlight();
					setHostessState(HostessState.WAIT_FOR_PASSENGER);
					break;		
					
			}
		}
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