package org.clas12.analysisTools.event.forward.calorimeter;

import java.util.ArrayList;

import org.jlab.detector.base.DetectorType;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;
import org.clas12.analysisTools.event.particles.Particle;
import org.clas12.analysisTools.event.particles.ParticleEvent;

public class CalorimeterEvent {

	/**
	 * List of clusters in the calorimeter
	 */
	private ArrayList<CalorimeterRecCluster> calorimeterClusters;
	
	
	
	
	
	/**
	 * Create new calorimeter event
	 */
	public CalorimeterEvent() {
		super();                                                        
		calorimeterClusters = new ArrayList<>();
	}                                                                                             

	/**
	 * Create new calorimeter event                                                                                                                                                                                                                             
	 * @param calorimeterClusters list of calorimeter clusters
	 */
	public CalorimeterEvent(ArrayList<CalorimeterRecCluster> calorimeterClusters) {
		super();
		this.calorimeterClusters = calorimeterClusters;
	}
	
	/**
	 * Copy constructor 
	 * @param calorimeterEvent create a new calo event with the same clusters as the given event
	 */
	public CalorimeterEvent(CalorimeterEvent calorimeterEvent){
		this.calorimeterClusters = new ArrayList<>();
		this.calorimeterClusters.addAll(calorimeterEvent.getCalorimeterClusters());
	}
	
	/**
	 * @return the calorimeterClusters
	 */
	public ArrayList<CalorimeterRecCluster> getCalorimeterClusters() {
		return calorimeterClusters;
	}

	/**
	 * @param calorimeterClusters the calorimeterClusters to set
	 */
	public void setCalorimeterClusters(ArrayList<CalorimeterRecCluster> calorimeterClusters) {
		this.calorimeterClusters = calorimeterClusters;
	}
	
	/**
	 * Add a calorimeter cluster
	 * 
	 * @param calorimeterRecCluster cluster to add
	 */
	public void addCalorimeterCluster(CalorimeterRecCluster calorimeterRecCluster){
		this.getCalorimeterClusters().add(calorimeterRecCluster);
	}
	
	
	
	
	
	/**
	 * Read calorimeter banks from a given event
	 * 
	 * @param event event to read
	 */
	public void readBanks(DataEvent event){
		if (event.hasBank("REC::Calorimeter") == true) {
			DataBank bankRecCalo = event.getBank("REC::Calorimeter");
			for (int iteratorRecCalo = 0; iteratorRecCalo < bankRecCalo.rows(); iteratorRecCalo++) { /* For all cluster */
				if (bankRecCalo.getByte("detector", iteratorRecCalo) == DetectorType.ECAL.getDetectorId()){
					CalorimeterRecCluster newClusterRecCalo = new CalorimeterRecCluster();
					newClusterRecCalo.readBankRow(bankRecCalo, iteratorRecCalo);
					this.addCalorimeterCluster(newClusterRecCalo);
				}
			}
		}
	}
	
	/**
	 * Associate reconstructed calorimeter clusters with a particle
	 * 
	 * @param particleEvent particle event containing particles to associate with calorimeter clusters
	 */
	public void linkBanks(ParticleEvent particleEvent){
		for (CalorimeterRecCluster clusterRecCalo : this.getCalorimeterClusters()){
			for (Particle particle : particleEvent.getParticles()){
				if (particle.getParticleId()==clusterRecCalo.getParticleId()){
					clusterRecCalo.setParticle(particle);
					particle.addCalorimeterCluster(clusterRecCalo);
				}
			}
		}
	}

}
