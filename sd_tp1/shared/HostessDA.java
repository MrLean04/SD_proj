/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import entities.HostessState;

/**
 *
 * @author Leandro e João
 */
public interface HostessDA {

    public  void preparePassBoarding();

        public  void checkAndWait();

    
        public  boolean planeReadyToTakeoff(); 

    
        public  void waitForNextFlight();
        //public  boolean readyForCheck();
        public boolean hostessJobDone();

}