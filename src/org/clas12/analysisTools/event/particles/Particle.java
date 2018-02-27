package org.clas12.analysisTools.event.particles;

import org.jlab.clas.physics.Vector3;

public class Particle {

	/**
	 * Particle 3-momentum
	 */
	Vector3 momentum;

	/**
	 * Particle vertex position
	 */
	Vector3 vertex;

	/**
	 * Particle theta (using clas12 angle convention)
	 */
	double theta;

	/**
	 * Particle phi (using clas12 angle convention)
	 */
	double phi;
	
	/**
	 * Particle charge
	 */
	int charge;

	/**
	 * Particle beta (measured by ToF)
	 */
	double beta;


	/**
	 * Create a new particle
	 */
	public Particle() {
		this.momentum = new Vector3();
		this.vertex = new Vector3();
	}
	
	/**
	 * Set momentum-vector
	 * 
	 * @param momentum  momentum-vector
	 */
	public void setMomentum(Vector3 momentum) {
		this.momentum = momentum;
	}

	/**
	 * Set momentum
	 * 
	 * @param px  x-component
	 * @param py  y-component
	 * @param pz  z-component
	 */
	public void setMomentum(double px, double py, double pz) {
		this.momentum.setXYZ(px, py, pz);
	}
	
	/**
	 * Get momentum-vector
	 * 
	 * @return particle momentum-vector
	 */
	public Vector3 getMomentum(){
		return momentum;
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
		this.phi = this.momentum.phi();
		this.theta = this.momentum.theta();
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


}
