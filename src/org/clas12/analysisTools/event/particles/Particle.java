package org.clas12.analysisTools.event.particles;

import java.util.ArrayList;

import org.clas12.analysisTools.event.forward.calorimeter.CalorimeterRecCluster;
import org.clas12.analysisTools.event.forward.ftof.FTOFRecCluster;
import org.clas12.analysisTools.event.forward.htcc.HTCCRecCluster;
import org.jlab.clas.physics.Vector3;

public class Particle {

	/**
	 * Unique ID
	 */
	private int particleId;
	
	/**
	 * Particle 3-momentum
	 */
	private Vector3 momentum;

	/**
	 * Particle 4-momentum
	 */
	private LorentzVector fourMomentum;
	
	/**
	 * Particle vertex position
	 */
	private Vector3 vertex;

	/**
	 * Particle theta (using clas12 angle convention)
	 */
	private double theta;

	/**
	 * Particle phi (using clas12 angle convention)
	 */
	private double phi;
	
	/**
	 * Particle charge
	 */
	private int charge;

	/**
	 * Particle beta (measured by ToF)
	 */
	private double beta;

	/**
	 * Particle identification chi2
	 */
	private double chi2pid;

	/**
	 * Calorimeter clusters associated with the particle
	 */
	private ArrayList<CalorimeterRecCluster> calorimeterRecClusters;
	
	/**
	 * Ftof clusters associated with the particle
	 */
	private ArrayList<FTOFRecCluster> ftofRecClusters;
	
	/**
	 * Htcc clusters associated with the particle
	 */
	private ArrayList<HTCCRecCluster> htccRecClusters;
	
	
	
	
	
	/**
	 * Create a new particle
	 */
	public Particle() {
		this.fourMomentum = new LorentzVector();
		this.momentum = new Vector3();
		this.vertex = new Vector3();
		this.calorimeterRecClusters = new ArrayList<>();
		this.ftofRecClusters = new ArrayList<>();
		this.htccRecClusters = new ArrayList<>();
	}

	/**
	 * Set unique ID
	 * @param particleId  unique ID for the particle
	 */
	protected void setParticleId(int particleId){
		this.particleId = particleId;
	}
	
	/**
	 * Get unique ID
	 * @return unique ID
	 */
	public int getParticleId() {
		return this.particleId;
	}
	
	/**
	 * Set momentum
	 * 
	 * @param px  x-component
	 * @param py  y-component
	 * @param pz  z-component
	 */
	public void setMomentum(double px, double py, double pz) {
		if (this.getMass()!=-1){
			this.fourMomentum.setPxPyPzM(px, py, pz, this.getMass());
		}else{
			this.momentum.setXYZ(px, py, pz);
		}
		this.computePhiTheta();
	}
	
	/**
	 * Get momentum-vector
	 * 
	 * @return particle momentum-vector
	 */
	public Vector3 getMomentum(){
		if (this.getMass()!=-1){
			return this.fourMomentum.vect();
		}else{
			return this.momentum;
		}
	}
	
	/**
	 * Get momentum-vector
	 * 
	 * @return particle momentum-vector
	 */
	public LorentzVector getFourMomentum(){
		if (this.getMass()==-1){
			
			return new LorentzVector(momentum, -1);
		}else{
			return this.fourMomentum;
		}
	}

	/**
	 * Get momentum x-component
	 * 
	 * @return momentum x-component
	 */
	public double getPx() {
		return this.getMomentum().x();
	}

	/**
	 * Get momentum y-component
	 * 
	 * @return momentum y-component
	 */
	public double getPy() {
		return this.getMomentum().y();
	}

	/**
	 * Get momentum z-component
	 * 
	 * @return momentum z-component
	 */
	public double getPz() {
		return this.getMomentum().z();
	}

	/**
	 * Set vertex-vector
	 * 
	 * @param vertex  vertex-vector
	 */
	public void setVertex(Vector3 vertex) {
		this.vertex = vertex;
	}

	/**
	 * Set vertex
	 * 
	 * @param vx  vertex x-component
	 * @param vy  vertex x-component
	 * @param vz  vertex x-component
	 */
	public void setVertex(double vx, double vy, double vz) {
		this.vertex.setXYZ(vx, vy, vz);
	}
	
	/**
	 * Get vertex-vector
	 * 
	 * @return vertex-vector
	 */
	public Vector3 getVertex() {
		return vertex;
	}

	/**
	 * Get vertex x-component
	 * 
	 * @return vertex x-component
	 */
	public double getVx() {
		return this.getVertex().x();
	}
	
	/**
	 * Get vertex y-component
	 * 
	 * @return vertex y-component
	 */
	public double getVy() {
		return this.getVertex().y();
	}

	/**
	 * Get vertex z-component
	 * 
	 * @return vertex z-component
	 */
	public double getVz() {
		return this.getVertex().z();
	}
	
	/**
	 * Get momentum theta (in clas12 conventions)
	 * 
	 * @return momentum theta (radian)
	 */
	public double getTheta() {
		return this.theta;
	}

	/**
	 * Get momentum theta (in clas12 conventions)
	 * 
	 * @return momentum theta (degree)
	 */
	public double getThetaDeg() {
		return Math.toDegrees(this.theta);
	}

	/**
	 * Get momentum phi (in clas12 conventions)
	 * 
	 * @return momentum phi (radian)
	 */
	public double getPhi() {
		return this.phi;
	}

	/**
	 * Get momentum phi (in clas12 conventions)
	 * 
	 * @return momentum phi (degree)
	 */
	public double getPhiDeg() {
		return Math.toDegrees(this.phi);
	}

	/**
	 * Compute phi thanks to the momentum
	 */
	public void computePhiTheta() {
		this.phi = this.fourMomentum.phi();
		this.theta = this.fourMomentum.theta();
	}

	/**
	 * Get charge
	 * 
	 * @return charge
	 */
	public int getCharge() {
		return charge;
	}

	/**
	 * Set charge
	 * 
	 * @param charge  charge
	 */
	public void setCharge(int charge) {
		this.charge = charge;
	}

	/**
	 * Get beta (measured by ToF)
	 * 
	 * @return beta  beta
	 */
	public double getBeta() {
		return beta;
	}

	/**
	 * Set beta (measured by ToF)
	 * 
	 * @return beta
	 */
	public void setBeta(double beta) {
		this.beta = beta;
	}
	
	/**
	 * Get Particle mass
	 * 
	 * @return particle mass (-1 if particle is not identified)
	 */
	protected double getMass() {
		return -1;
	}
	
	/**
	 * Get Particle energy
	 * 
	 * @return particle energy (-1 if particle is not identified)
	 */
	public double getEnergy(){
		if (this.getMass()!=-1){
			return this.fourMomentum.e();
		}else{
			return -1;
		}
	}
	
	/**
	 * Get particle identification
	 * 
	 * @return particle identification
	 */
	protected int getPid() {
		return -1;
	}
	
	/**
	 * Get particle identification chi2
	 * 
	 * @return particle identification chi2
	 */
	public double getChi2pid() {
		return chi2pid;
	}

	/**
	 * Set particle identification chi2
	 * 
	 * @param chi2pid  particle identification chi2
	 */
	public void setChi2pid(double chi2pid) {
		this.chi2pid = chi2pid;
	}
	
	
	
	
	
	/**
	 * Add a calorimeter cluster associated with the current particle
	 * 
	 * @param calorimeterCluster calorimeter cluster to associate
	 */
	public void addCalorimeterCluster(CalorimeterRecCluster calorimeterCluster){
		this.calorimeterRecClusters.add(calorimeterCluster);
	}
	
	/**
	 * Get calorimeter clusters
	 * 
	 * @return the list of calorimeter clusters
	 */
	public ArrayList<CalorimeterRecCluster> getCalorimeterClusters(){
		return this.calorimeterRecClusters;
	}
	
	/**
	 * Get number of calorimeter clusters
	 * 
	 * @return the number of calorimeter clusters
	 */
	public int hasCalorimeterClusters(){
		return this.getCalorimeterClusters().size();
	}
	
	/**
	 * Add a ftof cluster associated with the current particle
	 * 
	 * @param ftofCluster ftof cluster to associate
	 */
	public void addFTOFCluster(FTOFRecCluster ftofCluster){
		this.ftofRecClusters.add(ftofCluster);
	}
	
	/**
	 * Get ftof clusters
	 * 
	 * @return the list of ftof clusters
	 */
	public ArrayList<FTOFRecCluster> getFTOFClusters(){
		return this.ftofRecClusters;
	}
	
	/**
	 * Get number of FTOF clusters
	 * 
	 * @return the number of FTOF clusters
	 */
	public int hasFTOFClusters(){
		return this.getFTOFClusters().size();
	}
	
	/**
	 * Add a htcc cluster associated with the current particle
	 * 
	 * @param htccCluster htcc cluster to associate
	 */
	public void addHTCCCluster(HTCCRecCluster htccCluster){
		this.htccRecClusters.add(htccCluster);
	}

	/**
	 * Get htcc clusters
	 * 
	 * @return the list of htcc clusters
	 */
	public ArrayList<HTCCRecCluster> getHTCCClusters() {
		return htccRecClusters;
	}
		
	/**
	 * Get number of HTCC clusters
	 * 
	 * @return the number of HTCC clusters
	 */
	public int hasHTCCClusters(){
		return this.getHTCCClusters().size();
	}
	
}
