package org.clas12.analysisTools.event.forward.htcc;

import java.util.ArrayList;

import org.clas12.analysisTools.event.particles.Particle;
import org.clas12.analysisTools.event.particles.ParticleEvent;
import org.jlab.detector.base.DetectorType;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;

public class HTCCEvent {

	/**
	 * List of clusters in the FTOF
	 */
	private ArrayList<HTCCRecCluster> htccClusters;
	
	
	
	
	
	/**
	 * Create new HTCC event
	 */
	public HTCCEvent() {
		super();
		this.htccClusters  = new ArrayList<>();
	}
	

	/**
	 * @param htccClusters
	 */
	public HTCCEvent(ArrayList<HTCCRecCluster> htccClusters) {
		super();
		this.htccClusters = htccClusters;
	}
	
	/**
	 * Copy constructor
	 * @param htccEvent create a new htcc event with the same clusters as the given event
	 */
	public HTCCEvent(HTCCEvent htccEvent){
		this.htccClusters  = new ArrayList<>();
		this.htccClusters.addAll(htccEvent.getHtccClusters());
	}
	
	/**
	 * @return the htccClusters
	 */
	public ArrayList<HTCCRecCluster> getHtccClusters() {
		return htccClusters;
	}

	/**
	 * @param htccClusters the htccClusters to set
	 */
	public void setHtccClusters(ArrayList<HTCCRecCluster> htccClusters) {
		this.htccClusters = htccClusters;
	}
	
	/**
	 * Add a HTCC cluster
	 * 
	 * @param htccCluster cluster to add
	 */
	public void addHtccCluster(HTCCRecCluster htccCluster){
		this.getHtccClusters().add(htccCluster);
	}
	
	
	
	
	
	/** 
	 * Read htcc banks from a given event
	 * 
	 * @param event event to read
	 */
	public void readBanks(DataEvent event){
		if (event.hasBank("REC::Cherenkov") == true) {
			DataBank bankRecHtcc = event.getBank("REC::Cherenkov");
			for (int iteratorRecHtcc = 0; iteratorRecHtcc < bankRecHtcc.rows(); iteratorRecHtcc++) { /* For all cluster */
				if (bankRecHtcc.getByte("detector", iteratorRecHtcc) == DetectorType.HTCC.getDetectorId()){
					HTCCRecCluster newClusterRecHtcc = new HTCCRecCluster();
					newClusterRecHtcc.readBankRow(bankRecHtcc, iteratorRecHtcc);
					this.addHtccCluster(newClusterRecHtcc);
				}
			}
		}
	}
	
	/**
	 * Associate reconstructed htcc clusters with a particle
	 * 
	 * @param particleEvent
	 */
	public void linkBanks(ParticleEvent particleEvent){
		for (HTCCRecCluster clusterRecHtcc : htccClusters){
			for (Particle particle : particleEvent.getParticles()){
				if (particle.getParticleId()==clusterRecHtcc.getParticleId()){
					clusterRecHtcc.setParticle(particle);
					particle.addHTCCCluster(clusterRecHtcc);
				}
			}
		}
	}

}
