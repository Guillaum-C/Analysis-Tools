package org.clas12.analysisTools.event.particles;

public class Electron extends Particle {

	/**
	 * Particle mass
	 */
	private static double mass = 0.000511;
	
	/**
	 * Particle ID in LUND convention (11 electron, 22 gamma, 2212 proton, ...)
	 */
	private static int pid = 11;

	/**
	 * Particle identification chi2
	 */
	private double chi2pid;
	
	/**
	 * Create a new proton
	 */
	public Electron(){
		super();
	}
	
	@Override
	public double getMass(){
		return Electron.mass;
	}
	
	@Override
	public int getPid() {
		return Electron.pid;
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
	
}