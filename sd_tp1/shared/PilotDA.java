/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import entities.PilotState;

/**
 *
 * @author Leandro e João
 */
public interface PilotDA {
	public void parkAtTransfer();
    public void readyForBoarding();
    public void WaitForBoarding();
}