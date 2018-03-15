package org.clas12.analysisTools.event.forward.htcc;

import org.clas12.analysisTools.event.structures.RecCluster;
import org.jlab.clas.physics.Vector3;
import org.jlab.io.base.DataBank;

public class HTCCRecCluster extends RecCluster {
	
	/**
	 * Number of photo-electrons
	 */
	int nphe;

	
	
	
	
	/**
	 * Create new HTCCC reconstructed cluster
	 */
	public HTCCRecCluster() {
		super();
	}
	
	/**
	 * @return the number of photo-electrons
	 */
	public int getNphe() {
		return nphe;
	}

	/**
	 * @param nphe the number of photo-electrons to set
	 */
	public void setNphe(int nphe) {
		this.nphe = nphe;
	}
	
	
	
	
	
	/**
	 * Add htcc-specific bank entries
	 */
	public void readBankRow(DataBank bankRec, int bankRow){
		int id = bankRec.getShort("index", bankRow);
		int particleId = bankRec.getShort("pindex", bankRow);
		int detector = bankRec.getByte("detector", bankRow);
		int sector = bankRec.getByte("sector", bankRow);
		
		int numberPhotoElectron = bankRec.getShort("nphe", bankRow);
		
		double time = bankRec.getFloat("time", bankRow);
		double path = bankRec.getFloat("path", bankRow);
		double chi2 = bankRec.getFloat("chi2", bankRow);
		double x = bankRec.getFloat("x", bankRow);
		double y = bankRec.getFloat("y", bankRow);
		double z = bankRec.getFloat("z", bankRow);
		
		this.setUniqueID(id);
		this.setParticleId(particleId);
		this.setDetector(detector);
		this.setSector(sector);
		
		this.setNphe(numberPhotoElectron);
		
		this.setTime(time);
		this.setPath(path);
		this.setChi2(chi2);
		this.setPosition(new Vector3(x,y,z));
	}

}
