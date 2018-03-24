package org.clas12.analysisTools.constants;

public class GeometryConstants {
	
	public static final int NUMBER_OF_SECTORS = 6;
	
	public static int getSector(double phi){
		double phi_reg_min[] = {-178, - 117, -57, 3, 63, 123};   /* narrow fiducial fit cut! */
		double phi_reg_max[] = {-145, -88, -28, 32, 92, 154};    /* narrow fiducial fit cut! */
		int sector = 0;
		for(int sectorIterator=0; sectorIterator < GeometryConstants.NUMBER_OF_SECTORS ;sectorIterator++){
			if( phi > phi_reg_min[sectorIterator] && phi < phi_reg_max[sectorIterator]){
				sector = sectorIterator+1;
			}
		}
		return sector;
	}
	
}
