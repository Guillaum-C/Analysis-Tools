package org.clas12.analysisTools.plots;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.jlab.groot.data.GraphErrors;
import org.jlab.groot.data.H1F;
import org.jlab.groot.data.H2F;
import org.jlab.groot.data.TDirectory;
import org.jlab.groot.ui.TBrowser;

public class WithoutCanvas {
	
	private static final long serialVersionUID = 950472131756327257L;

	/**
	 * List of created H1D
	 */
	private ArrayList<H1F> list1DHisto = new ArrayList<>();
	
	/**
	 * List of created H2D
	 */
	private ArrayList<H2F> list2DHisto = new ArrayList<>();
	
	/**
	 * List of created GraphErrors
	 */
	private ArrayList<GraphErrors> listGraph = new ArrayList<>();
	
	/**
	 * Create new frame with canvas
	 * 
	 * @param title title of the window
	 */
	public WithoutCanvas(){
//		super(true);
//		frame = new JFrame(title);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		panel = new JPanel();
//		panel.setLayout(new GridLayout(1, 1));
//		panel.add(this);
//		frame.add(panel);
		
//		frame.setSize(1400, 800);
//        frame.setVisible(true);
	}
	
	/**
	 * @return the list1DHisto
	 */
	private ArrayList<H1F> getList1DHisto() {
		return list1DHisto;
	}
	
	/**
	 * Get an histogram with a given name
	 * 
	 * @param histoName name of the histogram required
	 * @return the required histogram (null if it doesn't exist)
	 */
	public H1F get1DHisto(String histoName){
		H1F histoFound = null;
		boolean plotExist=false;
		for (H1F histoIterator : this.getList1DHisto()){
			if (histoIterator.getName().equals(histoName)){
				plotExist=true;
				histoFound=histoIterator;
			}
		}
		if (!plotExist){
			System.out.println("Plots error: Cannot fill histogram "+histoName+", no histogram with this name exist.");
			throw new IllegalArgumentException("Histogram with that name doesn't exists");
		}
		return histoFound;
	}
	
	/**
	 * Add an histogram to the list
	 * 
	 * @param histo histogram to add
	 * @throws IllegalArgumentException if an histogram with the same name already exists
	 */
	public void add1DHisto(H1F histo){
		if (this.has1DHisto(histo.getName())){
			System.out.println("Canvas error: Cannot create new histogram: "+histo.getName()+", an histogram with this name already exist.");
			throw new IllegalArgumentException("Histogram with that name already exists");
		}else{
			this.getList1DHisto().add(histo);
		}
	}
	
	/**
	 * Check if histo with given name exists
	 * @param histoName name of a graph to look for
	 * @return 1 if graph exists, 0 else
	 */
	private boolean has1DHisto(String histoName){
		boolean histoFound=false;
		for (H1F histoIterator : this.getList1DHisto()){
			if (histoIterator.getName().equals(histoName)){
				histoFound=true;
			}
		}
		return histoFound;
	}
	
	/**
	 * @return the list2DHisto
	 */
	private ArrayList<H2F> getList2DHisto() {
		return list2DHisto;
	}
	
	/**
	 * Get an histogram with a given name
	 * 
	 * @param histoName name of the histogram required
	 * @return the required histogram (null if it doesn't exist)
	 */
	public H2F get2DHisto(String histoName){
		H2F histoFound = null;
		boolean plotExist=false;
		for (H2F histoIterator : this.getList2DHisto()){
			if (histoIterator.getName().equals(histoName)){
				plotExist=true;
				histoFound=histoIterator;
			}
		}
		if (!plotExist){
			System.out.println("Plots error: Cannot fill histogram "+histoName+", no histogram with this name exist.");
			throw new IllegalArgumentException("Histogram with that name doesn't exists");
		}
		return histoFound;
	}
	
	/**
	 * Add an histogram to the list
	 * 
	 * @param histo histogram to add
	 * @throws IllegalArgumentException if an histogram with the same name already exists
	 */
	public void add2DHisto(H2F histo){
		if (this.has2DHisto(histo.getName())){
			System.out.println("Canvas error: Cannot create new histogram: "+histo.getName()+", an histogram with this name already exist.");
			throw new IllegalArgumentException("Histogram with that name already exists");
		}else{
			this.getList2DHisto().add(histo);
		}
	}
	
	/**
	 * Check if histo with given name exists
	 * @param histoName name of a graph to look for
	 * @return 1 if graph exists, 0 else
	 */
	private boolean has2DHisto(String histoName){
		boolean histoFound=false;
		for (H2F histoIterator : this.getList2DHisto()){
			if (histoIterator.getName().equals(histoName)){
				histoFound=true;
			}
		}
		return histoFound;
	}
	
	/**
	 * @return the listGraph
	 */
	private ArrayList<GraphErrors> getListGraph() {
		return listGraph;
	}
	
	/**
	 * Get a graph with a given name
	 * 
	 * @param graphName name of the graph required
	 * @return the required graph (null if it doesn't exist)
	 */
	public GraphErrors getGraph(String graphName){
		GraphErrors graphFound = null;
		boolean plotExist=false;
		for (GraphErrors graphIterator : listGraph){
			if (graphIterator.getName().equals(graphName)){
				plotExist=true;
				graphFound=graphIterator;
			}
		}
		if (!plotExist){
			System.out.println("Plots error: Cannot access graph "+graphName+", no graph with this name exist.");
			throw new IllegalArgumentException("Graph with that name doesn't exists");
		}
		return graphFound;
	}
	
	/**
	 * Add a graph to the list
	 * 
	 * @param graph graph to add
	 * @throws IllegalArgumentException if a graph with the same name already exists
	 */
	public void addGraph(GraphErrors graph){
		if (this.hasGraph(graph.getName())){
			System.out.println("Canvas error: Cannot add new graph: "+graph.getName()+", graph with this name already exist.");
			throw new IllegalArgumentException("Graph with that name already exists");
		}else{
			this.getListGraph().add(graph);
		}
	}
	
	/**
	 * Check if graph with given name exists
	 * @param graphName name of a graph to look for
	 * @return 1 if graph exists, 0 else
	 */
	private boolean hasGraph(String graphName){
		boolean graphFound=false;
		for (GraphErrors graphIterator : listGraph){
			if (graphIterator.getName().equals(graphName)){
				graphFound=true;
			}
		}
		return graphFound;
	}
	
	
	/**
	 * Create a new 1D histogram plot
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param histoName histogram name (not displayed)
	 * @param title histogram title
	 * @param titleX histogram X-axis title
	 * @param binX number of bins along X-axis
	 * @param minX minimum value for X-axis
	 * @param maxX maximum value for X-axis
	 * @param logY true to have logarithmic Y-axis, false else
	 */
	public void create1DHisto(String histoName, String title, String titleX, int binX, double minX, double maxX){
		H1F newHisto = new H1F(histoName, binX, minX, maxX);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		this.add1DHisto(newHisto);
		
//		this.cdPad(tabName, row, column);
//		this.getCanvas(tabName).draw(newHisto, "same");
	}
	
	/**
	 * Create a row of 1D histogram plots (create numberOfSectors+1 histograms since the first column is supposed to be the sum of all sectors)
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param numberOfColumns number of sectors
	 * @param histoName histogram name (not displayed)
	 * @param title histogram title
	 * @param titleX histogram X-axis title
	 * @param binX number of bins along X-axis
	 * @param minX minimum value for X-axis
	 * @param maxX maximum value for X-axis
	 * @param logY true to have logarithmic Y-axis, false else
	 */
	public void create1DHistoBySector(int numberOfColumns, String histoName, String title, String titleX, int binX, double minX, double maxX){
		for (int sector=0; sector<numberOfColumns; sector++){
			H1F newHisto = new H1F(histoName+" S"+sector, binX, minX, maxX);
			newHisto.setTitle(title+" S"+sector);
			newHisto.setTitleX(titleX);
			this.add1DHisto(newHisto);
			
//			this.cdPad(tabName, row, sector+1);
//			this.getCanvas(tabName).draw(newHisto, "same");
		}
		
	}
	
	/**
	 * Fill histogram with the given values
	 * @param histoName name of the histogram to fill
	 * @param valueX value along X-axis
	 * @param weight weight of the point
	 */
	public void fill1DHisto(String histoName, double valueX, double weight){
		this.get1DHisto(histoName).fill(valueX, weight);
	}

	/**
	 * Fill histogram with the given values
	 * @param histoName name of the histogram to fill
	 * @param sector sector to fill
	 * @param valueX value along X-axis
	 * @param weight weight of the point
	 */
	public void fill1DHistoBySector(String histoName, int sector, double valueX, double weight){
		this.fill1DHisto(histoName+" S"+sector, valueX, weight);
	}

	/**
	 * Fill histogram with the given values (will use weight = 1)
	 * @param histoName name of the histogram to fill
	 * @param valueX value along X-axis
	 */
	public void fill1DHisto(String histoName, double valueX){
		this.fill1DHisto(histoName,valueX, 1);
	}

	/**
	 * Fill histogram with the given values (will use weight = 1)
	 * @param histoName name of the histogram to fill
	 * @param sector sector to fill
	 * @param valueX value along X-axis
	 */
	public void fill1DHistoBySector(String histoName, int sector, double valueX){
		this.fill1DHisto(histoName+" S"+sector,valueX, 1);
	}

	/**
	 * Create a new 2D histogram plot
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param histoName histogram name (not displayed)
	 * @param title histogram title
	 * @param titleX histogram X-axis title
	 * @param titleY histogram Y-axis title
	 * @param binX number of bins along X-axis
	 * @param minX minimum value for X-axis
	 * @param maxX maximum value for X-axis
	 * @param binY number of bins along Y-axis
	 * @param minY minimum value for Y-axis
	 * @param maxY maximum value for Y-axis
	 * @param logZ true to have logarithmic Z-axis, false else
	 */
	public void create2DHisto(String histoName, String title, String titleX, String titleY, int binX, double minX, double maxX, int binY, double minY, double maxY){
		H2F newHisto = new H2F(histoName, binX, minX, maxX, binY, minY, maxY);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		newHisto.setTitleY(titleY);
		this.add2DHisto(newHisto);
		
//		this.cdPad(tabName, row, column);
//		this.getCanvas(tabName).draw(newHisto, "same");
	}
		
	/**
	 * Create a row of 2D histogram plots (create numberOfSectors+1 histograms since the first column is supposed to be the sum of all sectors)
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param numberOfColumns number of sectors
	 * @param histoName histogram name (not displayed)
	 * @param title histogram title
	 * @param titleX histogram X-axis title
	 * @param titleY histogram Y-axis title
	 * @param binX number of bins along X-axis
	 * @param minX minimum value for X-axis
	 * @param maxX maximum value for X-axis
	 * @param binY number of bins along Y-axis
	 * @param minY minimum value for Y-axis
	 * @param maxY maximum value for Y-axis
	 * @param logZ true to have logarithmic Z-axis, false else
	 */
	public void create2DHistoBySector(int numberOfColumns, String histoName, String title, String titleX, String titleY, int binX, double minX, double maxX, int binY, double minY, double maxY){
		for (int sector=0; sector<numberOfColumns; sector++){
			H2F newHisto = new H2F(histoName+" S"+sector, binX, minX, maxX, binY, minY, maxY);
			newHisto.setTitle(title+" S"+sector);
			newHisto.setTitleX(titleX);
			newHisto.setTitleY(titleY);
			this.add2DHisto(newHisto);
			
//			this.cdPad(tabName, row, sector+1);
//			this.getCanvas(tabName).draw(newHisto, "same");
		}
	}
		
	/**
	 * Fill histogram with the given values
	 * @param histoName name of the histogram to fill
	 * @param valueX value along X-axis
	 * @param valueY value along Y-axis
	 * @param weight weight of the point
	 */
	public void fill2DHisto(String histoName, double valueX, double valueY, double weight){
		this.get2DHisto(histoName).fill(valueX, valueY, weight);	
	}	
	
	/**
	 * Fill histogram with the given values
	 * @param histoName name of the histogram to fill
	 * @param sector sector to fill
	 * @param valueX value along X-axis
	 * @param valueY value along Y-axis
	 * @param weight weight of the point
	 */
	public void fill2DHistoBySector(String histoName, int sector, double valueX, double valueY, double weight){
		this.fill2DHisto(histoName+" S"+sector,valueX, valueY, weight);
	}	

	/**
	 * Fill histogram with the given values (will use weight = 1)
	 * @param histoName name of the histogram to fill
	 * @param valueX value along X-axis
	 * @param valueY value along Y-axis
	 */
	public void fill2DHisto(String histoName, double valueX, double valueY){
		this.fill2DHisto(histoName,valueX, valueY, 1);
	}
	
	/**
	 * Fill histogram with the given values (will use weight = 1)
	 * @param histoName name of the histogram to fill
	 * @param sector sector to fill
	 * @param valueX value along X-axis
	 * @param valueY value along Y-axis
	 */
	public void fill2DHistoBySector(String histoName, int sector, double valueX, double valueY){
		this.fill2DHisto(histoName+" S"+sector,valueX, valueY, 1);
	}	
	
	/**
	 * Create and plot a new graph
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param graphName graph name (not displayed)
	 * @param title graph title
	 * @param titleX graph X-axis title
	 * @param titleY graph Y-axis title
	 */
	public void createGraph( String graphName, String title, String titleX, String titleY){
		this.createGraph( graphName, title, titleX, titleY, new double[0], new double[0], new double[0], new double[0]);
	}
	
	/**
	 * Create and plot a new graph 
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param graphName graph name (not displayed)
	 * @param title graph title
	 * @param titleX graph X-axis title
	 * @param titleY graph Y-axis title
	 * @param valuesX graph X-axis value
	 * @param valuesY graph Y-axis value
	 */
	public void createGraph( String graphName, String title, String titleX, String titleY, double[] valuesX, double[] valuesY){
		this.createGraph(graphName, title, titleX, titleY, valuesX, valuesY, new double[valuesX.length], new double[valuesY.length]);
	}
	
	/**
	 * Create and plot a new graph
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param graphName graph name (not displayed)
	 * @param title graph title
	 * @param titleX graph X-axis title
	 * @param titleY graph Y-axis title
	 * @param valuesX graph X-axis value
	 * @param valuesY graph Y-axis value
	 * @param errorsX graph X-axis error
	 * @param errorsY graph Y-axis error
	 */
	public void createGraph(String graphName, String title, String titleX, String titleY, double[] valuesX, double[] valuesY, double[] errorsX, double[]errorsY){
		GraphErrors newHisto = new GraphErrors(graphName, valuesX, valuesY, errorsX, errorsY);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		newHisto.setTitleY(titleY);
		this.addGraph(newHisto);
		
//		this.cdPad(tabName, row, column);
//		this.getCanvas(tabName).draw(newHisto, "same");	
	}
	
	/**
	 * Create a new plot with existing graph
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param graphName name of the graph to plot (not displayed)
	 */
	public void createGraph(String tabName, int row, int column, String graphName){
		GraphErrors newHisto = this.getGraph(graphName);
//		this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
//		this.getCanvas(tabName).draw(newHisto, "same");	
	}
	
	/**
	 * Add a point to the given graph (errors will be 0)
	 * @param graphName graph to add a point
	 * @param valueX value along X-axis
	 * @param valueY value along Y-axis
	 */
	public void fillGraph(String graphName, double valueX, double valueY){
		this.fillGraph(graphName, valueX, valueY, 0, 0);
	}
	
	/**
	 * Add a point to the given graph
	 * @param graphName graphName graph to add a point
	 * @param valueX value along X-axis
	 * @param valueY value along Y-axis
	 * @param errorX error along X-axis
	 * @param errorY error along Y-axis
	 */
	public void fillGraph(String graphName, double valueX, double valueY, double errorX, double errorY){
		this.getGraph(graphName).addPoint(valueX, valueY, errorX, errorY);	
	}	

	/**
	 * Save a plot in a hipo file
	 * @param plotName name of the plot to save
	 * @param fileToWrite name of the file to write (use the following format: /path/file.hipo)
	 */
	public void save(String plotName, String fileToWrite){
		System.out.println(" ================== WRITE ====================");
		TDirectory dirSave = new TDirectory();
		H1F h1 = this.get1DHisto(plotName);
		dirSave.mkdir("/toAvoidBug/"+plotName);
		dirSave.cd("/toAvoidBug/"+plotName);
        dirSave.addDataSet(h1);
		
        dirSave.mkdir("/plots/"+plotName);
        dirSave.cd("/plots/"+plotName);
        dirSave.addDataSet(h1);
        
        dirSave.cd();
        
        dirSave.tree();
        
        dirSave.writeFile(fileToWrite);
        System.out.println(" ================== WRITE DONE ====================");
	}
	
	/**
	 * Save all plots into a hipo file
	 * @param fileToWrite name of the file to write (use the following format: /path/file.hipo)
	 */
	public void saveAll(String fileToWrite){
		System.out.println(" ================== WRITE ALL ====================");
		TDirectory dirSave = new TDirectory();
		
		//TODO remove these 3 lines when bug is solved
		H1F h1 = new H1F();
		dirSave.mkdir("/toAvoidBug/");
		dirSave.cd("/toAvoidBug/");
		dirSave.addDataSet(h1);
		
		for (H1F histo1D:list1DHisto){
			dirSave.mkdir("/H1F/"+histo1D.getName());
			dirSave.cd("/H1F/"+histo1D.getName());
			dirSave.addDataSet(histo1D);
		}
		for (H2F histo2D:list2DHisto){
			dirSave.mkdir("/H2F/"+histo2D.getName());
			dirSave.cd("/H2F/"+histo2D.getName());
			dirSave.addDataSet(histo2D);
		}
		for (GraphErrors graph:listGraph){
			dirSave.mkdir("/GRAPH/"+graph.getName());
			dirSave.cd("/GRAPH/"+graph.getName());
			dirSave.addDataSet(graph);
		}
		
		dirSave.cd();
        dirSave.tree();
        
        dirSave.writeFile(fileToWrite);
        System.out.println(" ================== WRITE ALL DONE ====================");
	}
	
	/**
	 * Read all plots contained in a hipo file
	 * @param fileToRead hipo file to read (use the following format: /path/file.hipo)
	 */
	public void readAll(String fileToRead){
		System.out.println(" ================== READ ALL ====================");
		TDirectory dirRead = new TDirectory();
		
		dirRead.readFile(fileToRead);
		
		dirRead.cd();
        dirRead.tree();
        
        TBrowser browser = new TBrowser(dirRead);
        System.out.println(" ================== READ ALL DONE ====================");
	}
}
