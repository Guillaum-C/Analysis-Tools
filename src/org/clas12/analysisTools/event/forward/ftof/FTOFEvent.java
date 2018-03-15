package org.clas12.analysisTools.event.forward.ftof;

import java.util.ArrayList;

import org.clas12.analysisTools.event.particles.Particle;
import org.clas12.analysisTools.event.particles.ParticleEvent;
import org.jlab.detector.base.DetectorType;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;

public class FTOFEvent {

	/**
	 * List of clusters in the ftof
	 */
	private ArrayList<FTOFRecCluster> ftofClusters;
	
	
	
	
	
	/**
	 * Create new Ftof event
	 */
	public FTOFEvent() {
		super();
		this.ftofClusters = new ArrayList<>();
	}

	/**
	 * @param ftofClusters
	 */
	public FTOFEvent(ArrayList<FTOFRecCluster> ftofClusters) {
		super();
		this.ftofClusters = ftofClusters;
	}

	/**
	 * @return the ftofClusters
	 */
	public ArrayList<FTOFRecCluster> getFtofClusters() {
		return ftofClusters;
	}

	/**
	 * @param ftofClusters the ftofClusters to set
	 */
	public void setFtofClusters(ArrayList<FTOFRecCluster> ftofClusters) {
		this.ftofClusters = ftofClusters;
	}
	
	/**
	 * Add a FTOF cluster
	 * 
	 * @param ftofCluster cluster to add
	 */
	public void addFtofCluster(FTOFRecCluster ftofCluster){
		this.getFtofClusters().add(ftofCluster);
	}
	
	
	
	
	
	/**
	 * Read ftof banks from a given event
	 * 
	 * @param event event to read
	 */
	public void readBanks(DataEvent event){
		if (event.hasBank("REC::Scintillator") == true) {
			DataBank bankRecFtof = event.getBank("REC::Scintillator");
			for (int iteratorRecFtof = 0; iteratorRecFtof < bankRecFtof.rows(); iteratorRecFtof++) { /* For all cluster */
				if (bankRecFtof.getByte("detector", iteratorRecFtof) == DetectorType.FTOF.getDetectorId()){
					FTOFRecCluster newClusterRecFtof = new FTOFRecCluster();
					newClusterRecFtof.readBankRow(bankRecFtof, iteratorRecFtof);
					this.addFtofCluster(newClusterRecFtof);
				}
			}
		}
	}
	
	/**
	 * Associate reconstructed ftof clusters with a particle
	 * 
	 * @param particleEvent
	 */
	public void linkBanks(ParticleEvent particleEvent){
		for (FTOFRecCluster clusterRecFtof : ftofClusters){
			for (Particle particle : particleEvent.getParticles()){
				if (particle.getParticleId()==clusterRecFtof.getParticleId()){
					clusterRecFtof.setParticle(particle);
					particle.addFTOFCluster(clusterRecFtof);
				}
			}
		}
	}

}
