package org.clas12.analysisTools.event.central.cvt;

import org.clas12.analysisTools.event.structures.RecTrack;
import org.jlab.clas.physics.Vector3;
import org.jlab.detector.base.DetectorType;
import org.jlab.io.base.DataBank;

public class CVTRecTrack extends RecTrack{

	/**
	 * Create new CVT track
	 */
	public CVTRecTrack() {
		super();
	}
	
	
	
	
	
	/**
	 * Fill the current track with a given bank row
	 * 
	 * @param bankRec bank to read
	 * @param bankRow row of the bank
	 */
	public void readBankRow(DataBank bankRec, int bankRow){
		int id = bankRec.getShort("ID", bankRow);
		int detector = DetectorType.CVT.getDetectorId();
		int charge = bankRec.getByte("q", bankRow);
		double chi2 = bankRec.getFloat("chi2", bankRow);
		int ndf = bankRec.getShort("ndf", bankRow);
		
		int particleId = -1; //TODO update with correct value when available
		
		/*Compute momentum components*/
		double p = bankRec.getFloat("p", bankRow);
		double pt = bankRec.getFloat("pt", bankRow);
		double phi0 = bankRec.getFloat("phi0", bankRow);
		double tanDip = bankRec.getFloat("tandip", bankRow);
		
		double px = pt * Math.cos(phi0);
		double py = pt * Math.sin(phi0);
		double pz = Math.signum(tanDip)*Math.sqrt(p*p - px*px - py*py);
		
		/*Compute vertex components*/
		double d0 = bankRec.getFloat("d0", bankRow);
		double z0 = bankRec.getFloat("z0", bankRow);
		
		double vx = d0 * Math.cos(phi0);
		double vy = d0 * Math.sin(phi0);
		double vz = z0;
		
		this.setUniqueID(id);
		this.setDetector(detector);
		this.setCharge(charge);
		this.setChi2(chi2);
		this.setNdf(ndf);
		this.setMomentum(new Vector3(px,py,pz));
		this.setVertex(new Vector3(vx,vy,vz));
		this.setParticleId(particleId);
	}
}
