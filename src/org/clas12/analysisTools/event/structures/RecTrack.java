package org.clas12.analysisTools.event.structures;

import org.clas12.analysisTools.event.particles.Particle;
import org.jlab.clas.physics.Vector3;
import org.jlab.io.base.DataBank;

public class RecTrack {

	/**
	 * Id of the track (starting at 0) (unique central, forward)
	 */
	private int uniqueID;

	/**
	 * ID of the detector defined in COATJAVA DetectorType
	 */
	private int detector;

	/**
	 * Charge of the track
	 */
	private int charge;

	/**
	 * Chi2 (or quality) of track fitting
	 */
	private double chi2;
	
	/**
	 * Number of degrees of freedom
	 */
	private int ndf;
	
	/**
	 * Momentum of the track
	 */
	private Vector3 momentum;
	
	/**
	 * Vertex of the track
	 */
	private Vector3 vertex;
	
	/**
	 * Id of the associated particle (if exists)
	 */
	private int particleId;
	
	/**
	 * Associated particle (if exists)
	 */
	private Particle particle;
	
	
	
	
	
	/**
	 * @return the uniqueID
	 */
	public int getUniqueID() {
		return uniqueID;
	}

	/**
	 * @param uniqueID the uniqueID to set
	 */
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	/**
	 * @return the detector
	 */
	public int getDetector() {
		return detector;
	}

	/**
	 * @param detector the detector to set
	 */
	public void setDetector(int detector) {
		this.detector = detector;
	}

	/**
	 * @return the charge
	 */
	public int getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(int charge) {
		this.charge = charge;
	}

	/**
	 * @return the chi2
	 */
	public double getChi2() {
		return chi2;
	}

	/**
	 * @param chi2 the chi2 to set
	 */
	public void setChi2(double chi2) {
		this.chi2 = chi2;
	}

	/**
	 * @return the ndf
	 */
	public int getNdf() {
		return ndf;
	}

	/**
	 * @param ndf the ndf to set
	 */
	public void setNdf(int ndf) {
		this.ndf = ndf;
	}

	/**
	 * @return the momentum
	 */
	public Vector3 getMomentum() {
		return momentum;
	}

	/**
	 * @param momentum the momentum to set
	 */
	public void setMomentum(Vector3 momentum) {
		this.momentum = momentum;
	}

	/**
	 * @return the vertex
	 */
	public Vector3 getVertex() {
		return vertex;
	}

	/**
	 * @param vertex the vertex to set
	 */
	public void setVertex(Vector3 vertex) {
		this.vertex = vertex;
	}

	/**
	 * @return the particleId
	 */
	public int getParticleId() {
		return particleId;
	}

	/**
	 * @param particleId the particleId to set
	 */
	public void setParticleId(int particleId) {
		this.particleId = particleId;
	}

	/**
	 * @return the particle
	 */
	public Particle getParticle() {
		return particle;
	}

	/**
	 * @param particle the particle to set
	 */
	public void setParticle(Particle particle) {
		this.particle = particle;
	}
	
	
	
	
	
	/**
	 * Fill the current track with a given bank row
	 * 
	 * @param bankRec bank to read
	 * @param bankRow row of the bank
	 */
	public void readBankRow(DataBank bankRec, int bankRow){
		int id = bankRec.getShort("index", bankRow);
		int detector = bankRec.getByte("detector", bankRow);
		int charge = bankRec.getByte("q", bankRow);
		double chi2 = bankRec.getFloat("chi2", bankRow);
		int ndf = bankRec.getShort("NDF", bankRow);
		double px = bankRec.getFloat("px_nomm", bankRow);
		double py = bankRec.getFloat("py_nomm", bankRow);
		double pz = bankRec.getFloat("pz_nomm", bankRow);
		double vx = bankRec.getFloat("vx_nomm", bankRow);
		double vy = bankRec.getFloat("vy_nomm", bankRow);
		double vz = bankRec.getFloat("vz_nomm", bankRow);
		int particleId = bankRec.getShort("pindex", bankRow);
		
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
