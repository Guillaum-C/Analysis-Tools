package org.clas12.analysisTools.event.central;

import org.clas12.analysisTools.event.central.cvt.CVTEvent;
import org.clas12.analysisTools.event.particles.ParticleEvent;
import org.jlab.io.base.DataEvent;

public class CentralEvent {

	/**
	 * Central tracker event containing central tracks
	 */
	private CVTEvent cvtEvent;
	
	
	
	
	
	/**
	 * Create new central event
	 */
	public CentralEvent() {
		super();
		this.cvtEvent = new CVTEvent();
	}
	

	/**
	 * Create new Forward event
	 * @param cvtEvent cvt event
	 */
	public CentralEvent(CVTEvent cvtEvent) {
		super();
		this.cvtEvent = cvtEvent;
	}

	/**
	 * Copy constructor
	 * @param centralEvent create a new central event with the same trakcs/clusters as the given event
	 */
	public CentralEvent(CentralEvent centralEvent){
		this.cvtEvent = new CVTEvent(centralEvent.getCvtEvent());
	}
	
	/**
	 * @return the cvtEvent
	 */
	public CVTEvent getCvtEvent() {
		return cvtEvent;
	}

	
	/**
	 * @param cvtEvent the cvtEvent to set
	 */
	public void setCvtEvent(CVTEvent cvtEvent) {
		this.cvtEvent = cvtEvent;
	}
	
	
	
	

	/**
	 * Read banks from all central detectors
	 * 
	 * @param event event to read
	 */
	public void readCentralBanks(DataEvent event){
		cvtEvent.readBanks(event);
	}
	
	
	/**
	 * Link detector banks to particles
	 * 
	 * @param particleEvent particles to link
	 */
	public void linkBanks(ParticleEvent particleEvent){
		cvtEvent.linkBanks(particleEvent);
	}
	
}
