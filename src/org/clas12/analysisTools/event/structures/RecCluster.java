package org.clas12.analysisTools.event.structures;

import org.clas12.analysisTools.event.particles.Particle;
import org.jlab.clas.physics.Vector3;
import org.jlab.io.base.DataBank;

public class RecCluster {

	/**
	 * Id of the cluster (starting at 0) (unique for each detector)
	 */
	private int uniqueID;

	/**
	 * ID of the detector defined in COATJAVA DetectorType
	 */
	private int detector;

	/**
	 * Sector of the cluster
	 */
	private int sector;

	/**
	 * Layer of the cluster
	 */
	private int layer;

	/**
	 * Energy associated with the cluster
	 */
	private double energy;
	
	/**
	 * Time associated with the cluster;
	 */
	private double time;
	
	/**
	 * Path from vertex to the cluster
	 */
	private double path;
	
	/**
	 * Chi2 (or quality) of hit-track matching
	 */
	private double chi2;
	
	/**
	 * Position of the cluster
	 */
	private Vector3 position;
	
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
	 * @return the sector
	 */
	public int getSector() {
		return sector;
	}

	/**
	 * @param sector the sector to set
	 */
	public void setSector(int sector) {
		this.sector = sector;
	}

	/**
	 * @return the layer
	 */
	public int getLayer() {
		return layer;
	}

	/**
	 * @param layer the layer to set
	 */
	public void setLayer(int layer) {
		this.layer = layer;
	}

	/**
	 * @return the energy
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * @param energy the energy to set
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(double time) {
		this.time = time;
	}
	
	/**
	 * @return the path
	 */
	public double getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(double path) {
		this.path = path;
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
	 * @return the position
	 */
	public Vector3 getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Vector3 position) {
		this.position = position;
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
	 * Fill the current cluster with a given bank row
	 * 
	 * @param bankRec bank to read
	 * @param bankRow row of the bank
	 */
	public void readBankRow(DataBank bankRec, int bankRow){
		int id = bankRec.getShort("index", bankRow);
		int particleId = bankRec.getShort("pindex", bankRow);
		int detector = bankRec.getByte("detector", bankRow);
		int sector = bankRec.getByte("sector", bankRow);
		int layer = bankRec.getByte("layer", bankRow);
		double energy = bankRec.getFloat("energy", bankRow);
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
		this.setLayer(layer);
		this.setEnergy(energy);
		this.setTime(time);
		this.setPath(path);
		this.setChi2(chi2);
		this.setPosition(new Vector3(x,y,z));
	}
	
}
