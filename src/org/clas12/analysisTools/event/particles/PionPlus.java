package org.clas12.analysisTools.event.particles;

public class PionPlus extends Particle {

	/**
	 * Particle mass
	 */
	public static double mass = 0.139570;
	
	/**
	 * Particle ID in LUND convention (11 electron, 22 gamma, 2212 proton, ...)
	 */
	public static int pid = 211;

	/**
	 * Create a new proton
	 */
	public PionPlus(){
		super();
	}

	/**
	 * Create new pion +
	 */
	public PionPlus(Particle particle){
		super(particle);
	}
	@Override
	public double getMass(){
		return PionPlus.mass;
	}
	
	@Override
	public int getPid() {
		return PionPlus.pid;
	}
	
}
