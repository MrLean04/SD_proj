package main;

import entities.Pilot;
import entities.Hostess;
import entities.Passenger;
import shared.PilotDA;
import shared.PilotP;
import shared.PilotDSA;
import shared.HostessDA;
import shared.HostessP;
import shared.HostessDSA;
import shared.PassengerDA;
import shared.PassengerP;
import shared.PassengerDSA;
import shared.Plane;
import shared.Departureairport;
import shared.Destinationairport;

public class Main {
    
    private static Departureairport departureairport;
	private static Plane plane;
	private static Destinationairport destinationairport;
    public static void main(String[] args) {
        
		final int nPassengers = 20;
        
			Pilot = new Pilot((PilotDA) departureairport, (PilotP) plane, (PilotDSA) destinationairport);
			Pilot.start();
			Hostess = new Hostess((HostessDA) departureairport, (HostessP) plane, (HostessDSA) destinationairport);
			Hostess.start();

		Passenger = new Passenger[nPassengers];
		for (int i = 0; i < nPassengers; i++) {
			Passenger[i] = new Passenger((PassengerDA) departureairport, (PassengerP) plane, (PassengerDSA) destinationairport, (int) i);
			Passenger[i].start();
		}
}