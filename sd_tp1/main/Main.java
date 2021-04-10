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

public class Main extends Thread {

	private static Departureairport departureairport;
	private static Plane plane;
	private static Destinationairport destinationairport;

	public static void main(String[] args) {

		final int nPassengers = 10;
		departureairport = new Departureairport();
		plane = new Plane();
		destinationairport = new Destinationairport();
		Pilot p = new Pilot((PilotDA) departureairport, (PilotP) plane, (PilotDSA) destinationairport);
		p.start();
		Hostess h = new Hostess((HostessDA) departureairport, (HostessP) plane, (HostessDSA) destinationairport);
		h.start();

		Passenger[] passenger = new Passenger[nPassengers];
		for (int i = 0; i < nPassengers; i++) {
			passenger[i] = new Passenger((PassengerDA) departureairport, (PassengerP) plane,
					(PassengerDSA) destinationairport, (int) i);
			passenger[i].start();
		}
		try {
			h.join(0);
			System.err.println("Hostess died!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

		}
		
		try {
			p.join(0);
			System.err.println("Pilot died!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

		}

		for (int i = 0; i < nPassengers; i++) {
			try {
				passenger[i].join(0);
				System.err.println("Passenger " + i + " died!");
			} catch (InterruptedException ex) {

			}
		}				

	}
}