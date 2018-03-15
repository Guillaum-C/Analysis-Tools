package org.clas12.analysisTools.event.forward.calorimeter;

import org.clas12.analysisTools.event.structures.RecCluster;
import org.jlab.clas.physics.Vector3;
import org.jlab.io.base.DataBank;

public class CalorimeterRecCluster extends RecCluster {
	
	/**
	 * Position of the matched cluster
	 */
	Vector3 matchedPosition;
	
	
	
	
	
	/**
	 * Create new Calorimeter reconstructed cluster
	 */
	public CalorimeterRecCluster() {
		super();
	}

	/**
	 * @return the matchedPosition
	 */
	public Vector3 getMatchedPosition() {
		return matchedPosition;
	}

	/**
	 * @param matchedPosition the matchedPosition to set
	 */
	public void setMatchedPosition(Vector3 matchedPosition) {
		this.matchedPosition = matchedPosition;
	}
	
	
	
	
	
	/**
	 * Add calorimeter-specific bank entries
	 */
	public void readBankRow(DataBank bankRec, int bankRow){
		super.readBankRow(bankRec, bankRow);
		double matchedX = bankRec.getFloat("hx", bankRow);
		double matchedY = bankRec.getFloat("hy", bankRow);
		double matchedZ = bankRec.getFloat("hz", bankRow);
		
		this.setMatchedPosition(new Vector3(matchedX, matchedY, matchedZ));
	}

}
