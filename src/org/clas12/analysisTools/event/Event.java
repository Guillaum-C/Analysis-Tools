package org.clas12.analysisTools.event;

import org.clas12.analysisTools.event.forward.ForwardEvent;
import org.clas12.analysisTools.event.particles.ParticleEvent;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;

public class Event {

	/**
	 * ParticleEvent containing all particles of the event
	 */
	private ParticleEvent particleEvent;
	
	private ForwardEvent forwardEvent;
	
	private int numberOfTriggerBits = 32;
	
	/**
	 * Trigger bits (1 if the trigger bit is "on"
	 */
	private boolean[] trigger_bits = new boolean[numberOfTriggerBits];
	
	/**
	 * Helicity (can take values +1 or -1)
	 */
	private int helicity;
	
	
	
	
	
	/**
	 * Create a new event
	 */
	public Event(){
		particleEvent = new ParticleEvent();
	}
	
	/**
	 * Get the ParticleEvent containing all particles of the event
	 * 
	 * @return  ParticleEvent
	 */
	public ParticleEvent getParticleEvent() {
		return particleEvent;
	}

	/**
	 * Set ParticleEvent
	 * 
	 * @param particleEvent  particleEvent 
	 */
	public void setParticleEvent(ParticleEvent particleEvent) {
		this.particleEvent = particleEvent;
	}

	/**
	 * Get the value of a specific trigger bit
	 * 
	 * @param triggerBit  index of the trigger bit
	 * @return value of the trigger bit (true if "ON" false if "OFF")
	 */
	public boolean getTrigger_bit(int triggerBit){
		if (triggerBit >= 0 && triggerBit < numberOfTriggerBits){
			return trigger_bits[triggerBit];
		}else{
			throw new IllegalArgumentException("Trigger bit has to be between 0 and "+numberOfTriggerBits);
		}
	}
	
	/**
	 * Get the trigger bits table
	 * 
	 * @return the trigger bits table
	 */
	public boolean[] getTrigger_bits() {
		return trigger_bits;
	}

	/**
	 * Set the trigger bits table
	 * 
	 * @param trigger_bits trigger bit table
	 */
	public void setTrigger_bits(boolean[] trigger_bits) {
		this.trigger_bits = trigger_bits;
	}
	
	/**
	 * Get helicity
	 * 
	 * @return helicity value (-1 or +1)
	 */
	public int getHelicity() {
		return helicity;
	}

	/**
	 * Set helicity
	 * 
	 * @param helicity  Helicity (can take only values +1 or -1)
	 */
	public void setHelicity(int helicity) {
		if ( helicity==-1 || helicity==1 ){
			this.helicity = helicity;
		}else{
			throw new IllegalArgumentException("Helicity can only take values 1 and -1");
		}
	}
	
	/**
	 * Read general event parameters (helicity, trigger bits, ...)
	 * 
	 * @param event  event to analyze
	 */
	public void readEventParametersBanks(DataEvent event){
		
		if (event.hasBank("RUN::config")) {
			DataBank bank = event.getBank("RUN::config");
			long TriggerWord = bank.getLong("trigger", 0);
			for (int i = 31; i >= 0; i--) {
				trigger_bits[i] = (TriggerWord & (1 << i)) != 0;
			}
			this.setTrigger_bits(trigger_bits);
		}
		
		if (event.hasBank("HEL::adc") == true) {
			DataBank bankParticle = event.getBank("HEL::adc");
			int pedestal = bankParticle.getShort("ped", 0);
			if (pedestal>1000){
				this.setHelicity(1);
			}else{
				this.setHelicity(-1);
			}
		}		
	}
	
	/**
	 * Read event banks (event parameters, particles, detectors ...)
	 * 
	 * @param event  event to analyze
	 */
	public void readBanks(DataEvent event){
		this.readEventParametersBanks(event);
		this.particleEvent.readParticleBanks(event);
		//this.forwardEvent.readForwardBanks(event);
		//this.forwardEvent.linkBanks(particleEvent);
	}
	
	
}
