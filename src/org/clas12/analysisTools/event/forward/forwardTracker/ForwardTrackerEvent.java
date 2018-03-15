package org.clas12.analysisTools.event.forward.forwardTracker;

import java.util.ArrayList;

import org.clas12.analysisTools.event.particles.Particle;
import org.clas12.analysisTools.event.particles.ParticleEvent;
import org.jMath.Vector.fourVec;
import org.jlab.detector.base.DetectorType;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;

public class ForwardTrackerEvent {

	/**
	 * List of clusters in the calorimeter
	 */
	private ArrayList<ForwardRecTrack> forwardTracks;
	
	
	
	
	
	/**
	 * Create new forward tracker event
	 */
	public ForwardTrackerEvent() {
		super();
		this.forwardTracks = new ArrayList<>();
	}

	/**
	 * @param forwardTracks forward tracks to set for forward tracker event
	 */
	public ForwardTrackerEvent(ArrayList<ForwardRecTrack> forwardTracks) {
		super();
		this.forwardTracks = forwardTracks;
	}
	
	/**
	 * @return the forward tracks
	 */
	public ArrayList<ForwardRecTrack> getForwardTracks() {
		return forwardTracks;
	}

	/**
	 * @param forwardTracks the forward tracks to set
	 */
	public void setForwardTracks(ArrayList<ForwardRecTrack> forwardTracks) {
		this.forwardTracks = forwardTracks;
	}

	public void addForwardTrack(ForwardRecTrack forwardTrack){
		this.getForwardTracks().add(forwardTrack);
	}
	
	
	
	
	
	/**
	 * Read tracks banks from a given event
	 * 
	 * @param event event to read
	 */
	public void readBanks(DataEvent event){
		if (event.hasBank("REC::Track") == true) {
			DataBank bankRecTrack = event.getBank("REC::Track");
			for (int iteratorRecTrack = 0; iteratorRecTrack < bankRecTrack.rows(); iteratorRecTrack++) { /* For all cluster */
				if (bankRecTrack.getByte("detector", iteratorRecTrack) == DetectorType.DC.getDetectorId()){
					ForwardRecTrack newRecTrack = new ForwardRecTrack();
					newRecTrack.readBankRow(bankRecTrack, iteratorRecTrack);
					this.addForwardTrack(newRecTrack);
				}
			}
		}
	}
	
	/**
	 * Associate reconstructed tracks with a particle
	 * 
	 * @param particleEvent
	 */
	public void linkBanks(ParticleEvent particleEvent){
		for (ForwardRecTrack forwardTrack : forwardTracks){
			for (Particle particle : particleEvent.getParticles()){
				if (particle.getParticleId()==forwardTrack.getParticleId()){
					forwardTrack.setParticle(particle);
					particle.setForwardRecTrack(forwardTrack);
				}
			}
		}
	}
	
}
