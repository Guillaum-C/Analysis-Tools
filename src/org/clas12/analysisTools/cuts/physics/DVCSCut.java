package org.clas12.analysisTools.cuts.physics;

import org.clas12.analysisTools.event.Event;
import org.clas12.analysisTools.event.particles.Particle;
import org.clas12.analysisTools.event.particles.ParticleEvent;

public class DVCSCut {

	public Event Cut(Event oldParticleEvent) {
		Event newEvent = null;
		ParticleEvent newParticleEvent = null;

		if (oldParticleEvent.getParticleEvent().hasNumberOfElectrons() > 0 && oldParticleEvent.getParticleEvent().hasNumberOfProtons() > 0
				&& oldParticleEvent.getParticleEvent().hasNumberOfPhotons() > 0) {
			newParticleEvent = new ParticleEvent();
			for (Particle particleIterator : oldParticleEvent.getParticleEvent().getParticles()) {
				newParticleEvent.addParticle(particleIterator);
			}
		}

		return newEvent;
	}
}
