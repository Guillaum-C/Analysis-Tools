package org.clas12.analysisTools.event.particles;

public class Electron extends Particle {

	/**
	 * Particle mass
	 */
	public static double mass = 0.000511;
	
	/**
	 * Particle ID in LUND convention (11 electron, 22 gamma, 2212 proton, ...)
	 */
	public static int pid = 11;

	/**
	 * Create a new proton
	 */
	public Electron(){
		super();
	}

	/**
	 * Create new electron
	 */
	public Electron(Particle particle){
		super(particle);
	}
	@Override
	public double getMass(){
		return Electron.mass;
	}
	
	@Override
	public int getPid() {
		return Electron.pid;
	}
	
}
