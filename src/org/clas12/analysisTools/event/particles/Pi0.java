package org.clas12.analysisTools.event.particles;

public class Pi0 extends Particle {

	/**
	 * Particle mass
	 */
	public static double mass = 0.13498;
	
	/**
	 * Particle ID in LUND convention (11 electron, 22 gamma, 2212 proton, ...)
	 */
	public static int pid = 111;

	/**
	 * Create a new proton
	 */
	public Pi0(){
		super();
	}

	/**
	 * Create new electron
	 */
	public Pi0(Particle particle){
		super(particle);
	}
	@Override
	public double getMass(){
		return Pi0.mass;
	}
	
	@Override
	public int getPid() {
		return Pi0.pid;
	}
	
}
