package org.clas12.analysisTools.event.central.cvt;

import java.util.ArrayList;

import org.clas12.analysisTools.event.particles.Particle;
import org.clas12.analysisTools.event.particles.ParticleEvent;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;

public class CVTEvent {

	/**
	 * List of CVT tracks
	 */
	private ArrayList<CVTRecTrack> cvtTracks;

	
	
	
	
	/**
	 * Create new CVT event
	 */
	public CVTEvent() {
		super();
		this.cvtTracks = new ArrayList<>();
	}

	/**
	 * @param cvtTracks list of CVT tracks
	 */
	public CVTEvent(ArrayList<CVTRecTrack> cvtTracks) {
		super();
		this.cvtTracks = cvtTracks;
	}

	/**
	 * Copy constructor
	 * @param cvtEvent create a new cvt event with the same track as the given event
	 */
	public CVTEvent(CVTEvent cvtEvent){
		this.cvtTracks = new ArrayList<>();
		this.cvtTracks.addAll(cvtEvent.getCvtTracks());
	}
	
	/**
	 * @return the cvtTracks
	 */
	public ArrayList<CVTRecTrack> getCvtTracks() {
		return cvtTracks;
	}

	/**
	 * @param cvtTracks the cvtTracks to set
	 */
	public void setCvtTracks(ArrayList<CVTRecTrack> cvtTracks) {
		this.cvtTracks = cvtTracks;
	}
	
	/**
	 * Add a track to the list of CVT tracks
	 * @param cvtTrack track to add
	 */
	public void addCVTTrack(CVTRecTrack cvtTrack){
		this.getCvtTracks().add(cvtTrack);
	}

	
	
	
	
	/**
	 * Read tracks banks from a given event
	 * 
	 * @param event event to read
	 */
	public void readBanks(DataEvent event){
		//TODO use REC::Tracks when available
		if (event.hasBank("CVTRec::Tracks") == true) {
			DataBank bankRecTrack = event.getBank("CVTRec::Tracks");
			for (int iteratorRecTrack = 0; iteratorRecTrack < bankRecTrack.rows(); iteratorRecTrack++) {
				//if (bankRecTrack.getByte("detector", iteratorRecTrack) == DetectorType.CVT.getDetectorId()){
					CVTRecTrack newRecTrack = new CVTRecTrack();
					newRecTrack.readBankRow(bankRecTrack, iteratorRecTrack);
					this.addCVTTrack(newRecTrack);
				//}
			}
		}
	}
	

	/**
	 * Associate reconstructed tracks with a particle
	 * 
	 * @param particleEvent particle event containing particles to link with tracks
	 */
	public void linkBanks(ParticleEvent particleEvent){
		for (CVTRecTrack cvtTrack : cvtTracks){
			for (Particle particle : particleEvent.getParticles()){
				//TODO use particleID when available
				if (Math.abs(particle.getVx()-cvtTrack.getVertex().x())<0.001 && Math.abs(particle.getVy()-cvtTrack.getVertex().y())<0.001 && Math.abs(particle.getVz()-cvtTrack.getVertex().z())<0.001 && Math.abs(particle.getPx()-cvtTrack.getMomentum().x())<0.001 && Math.abs(particle.getPy()-cvtTrack.getMomentum().y())<0.001 && Math.abs(particle.getPz()-cvtTrack.getMomentum().z())<0.001){
					cvtTrack.setParticle(particle);
					particle.setCvtRecTrack(cvtTrack);
				}
			}
		}
	}
}
