package org.clas12.analysisTools.event.particles;

public class Proton extends Particle {

	/**
	 * Particle mass
	 */
	public static double mass = 0.938272;
	
	/**
	 * Particle ID in LUND convention (11 electron, 22 gamma, 2212 proton, ...)
	 */
	public static int pid = 2212;

	/**
	 * Create a new proton
	 */
	public Proton(){
		super();
	}
	
	/**
	 * Create new proton
	 */
	public Proton(Particle particle){
		super(particle);
		this.setMomentum(particle.getPx(), particle.getPy(), particle.getPz());
	}
	
	@Override
	public double getMass(){
		return Proton.mass;
	}
	
	@Override
	public int getPid() {
		return Proton.pid;
	}
	
}
