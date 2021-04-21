/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import entities.PassengerState;

/**
 *
 * @author Leandro e João
 */
public interface PassengerDA {

    public void travelToAirport();
    public void waitInQueue(int id, PassengerState state);
    public boolean showDocuments(int id);
    public boolean waitinQueueFlight(int id);
    public int planeSize();
    
}