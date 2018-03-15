package org.clas12.analysisTools.event.forward;

import org.clas12.analysisTools.event.forward.calorimeter.CalorimeterEvent;
import org.clas12.analysisTools.event.forward.forwardTracker.ForwardTrackerEvent;
import org.clas12.analysisTools.event.forward.ftof.FTOFEvent;
import org.clas12.analysisTools.event.forward.htcc.HTCCEvent;
import org.clas12.analysisTools.event.particles.ParticleEvent;
import org.jlab.io.base.DataEvent;

public class ForwardEvent {
	
	/**
	 * Calorimeter event containing all calorimeter clusters
	 */
	private CalorimeterEvent calorimeterEvent;
	
	/**
	 * FTOF event containing all FTOF clusters
	 */
	private FTOFEvent ftofEvent;
	
	/**
	 * HTCC event containing all HTCC clusters
	 */
	private HTCCEvent htccEvent;
	
	/**
	 * Forward tracker event containing forward tracks
	 */
	private ForwardTrackerEvent forwardTrackerEvent;
	
	
	
	
	
	/**
	 * Create new Forward event
	 */
	public ForwardEvent() {
		super();
		this.calorimeterEvent = new CalorimeterEvent();
		this.htccEvent = new HTCCEvent();
		this.ftofEvent = new FTOFEvent();
		this.forwardTrackerEvent = new ForwardTrackerEvent();
	}
	
	/**
	 * Create new forward event
	 * 
	 * @param calorimeterEvent calorimeter event
	 * @param htccEvent htcc event
	 * @param ftofEvent ftof event
	 */
	public ForwardEvent(CalorimeterEvent calorimeterEvent, HTCCEvent htccEvent, FTOFEvent ftofEvent, ForwardTrackerEvent forwardTrackerEvent) {
		super();
		this.calorimeterEvent = calorimeterEvent;
		this.htccEvent = htccEvent;
		this.ftofEvent = ftofEvent;
		this.forwardTrackerEvent = forwardTrackerEvent;
	}

	/**
	 * @return the calorimeterEvent
	 */
	public CalorimeterEvent getCalorimeterEvent() {
		return calorimeterEvent;
	}

	/**
	 * @param calorimeterEvent the calorimeterEvent to set
	 */
	public void setCalorimeterEvent(CalorimeterEvent calorimeterEvent) {
		this.calorimeterEvent = calorimeterEvent;
	}

	/**
	 * @return the htccEvent
	 */
	public HTCCEvent getHtccEvent() {
		return htccEvent;
	}

	/**
	 * @param htccEvent the htccEvent to set
	 */
	public void setHtccEvent(HTCCEvent htccEvent) {
		this.htccEvent = htccEvent;
	}

	/**
	 * @return the ftofEvent
	 */
	public FTOFEvent getFtofEvent() {
		return ftofEvent;
	}

	/**
	 * @param ftofEvent the ftofEvent to set
	 */
	public void setFtofEvent(FTOFEvent ftofEvent) {
		this.ftofEvent = ftofEvent;
	}
	
	/**
	 * @return the forwardTrackerEvent
	 */
	public ForwardTrackerEvent getForwardTrackerEvent() {
		return forwardTrackerEvent;
	}

	/**
	 * @param forwardTrackerEvent the forwardTrackerEvent to set
	 */
	public void setForwardTrackerEvent(ForwardTrackerEvent forwardTrackerEvent) {
		this.forwardTrackerEvent = forwardTrackerEvent;
	}

	
	
	
	
	/**
	 * Read banks from all forward detectors
	 * 
	 * @param event event to read
	 */
	public void readForwardBanks(DataEvent event){
		calorimeterEvent.readBanks(event);
		ftofEvent.readBanks(event);
		htccEvent.readBanks(event);
		forwardTrackerEvent.readBanks(event);
	}
	
	/**
	 * Link detector banks to particles
	 * 
	 * @param particleEvent particles to link
	 */
	public void linkBanks(ParticleEvent particleEvent){
		calorimeterEvent.linkBanks(particleEvent);
		ftofEvent.linkBanks(particleEvent);
		htccEvent.linkBanks(particleEvent);
		forwardTrackerEvent.linkBanks(particleEvent);
	}
	
}
