package org.clas12.analysisTools.plots;

import java.awt.GridLayout;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jlab.groot.data.GraphErrors;
import org.jlab.groot.data.H1F;
import org.jlab.groot.data.H2F;
import org.jlab.groot.data.TDirectory;
import org.jlab.groot.graphics.EmbeddedCanvas;
import org.jlab.groot.graphics.EmbeddedCanvasTabbed;
import org.jlab.groot.graphics.EmbeddedPad;
import org.jlab.groot.ui.TBrowser;

public class Canvas extends EmbeddedCanvasTabbed {
	
	private static final long serialVersionUID = 950472131756327257L;

	/**
	 * Frame that will contain plots
	 */
	private JFrame frame ;
	
	/**
	 * Main panel inside the frame
	 */
	private JPanel panel ;
	
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
	 * Size of the axis/title (false for normal size, true for big size)
	 */
	private boolean largeSize = false;
	
	
	
	
	
	/**
	 * Create new frame with canvas
	 * 
	 * @param title title of the window
	 */
	public Canvas(String title){
		super(true);
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		panel.add(this);
		frame.add(panel);
		
		frame.setSize(1400, 800);
        frame.setVisible(true);
	}
	
	/**
	 * Create new frame with canvas
	 * 
	 * @param title title of the frame
	 * @param largeSize size of the axis/titles (false (default) for normal, true for big size)
	 */
	public Canvas(String title, boolean largeSize){
		this(title);
        this.largeSize = largeSize;
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
	 * Get a specific pad (in position (row, column))
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @return the required pad
	 */
	private EmbeddedPad getPad(String tabName, int row, int column){
		if ( (row < 0) || (row > this.getCanvas(tabName).getNRows()) ){
			throw new InvalidParameterException("Cannot access row: "+row+". Row value must be between 1 and "+this.getCanvas(tabName).getNRows()+".");
		}else if  ( (column < 0) || (column > this.getCanvas(tabName).getNColumns()) ){
			throw new InvalidParameterException("Cannot access column: "+column+". Column value must be between 1 and "+this.getCanvas(tabName).getNColumns()+".");
		}else{
			return this.getCanvas(tabName).getPad( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		}
	}
	
	/**
	 * Go to a specific pad (in position (row, column))
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 */
	private void cdPad(String tabName, int row, int column){
		System.out.println("Nb Column: "+this.getCanvas(tabName).getNColumns());
		if ( (row < 0) || (row > this.getCanvas(tabName).getNRows()) ){
			throw new InvalidParameterException("Cannot access row: "+row+". Row value must be between 1 and "+this.getCanvas(tabName).getNRows()+".");
		}else if  ( (column < 0) || (column > this.getCanvas(tabName).getNColumns()) ){
			throw new InvalidParameterException("Cannot access column: "+column+". Column value must be between 1 and "+this.getCanvas(tabName).getNColumns()+".");
		}else{
			this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		}
	}
	
	/**
	 * Get a specific canvas
	 * @param tabName
	 */
	public EmbeddedCanvas getCanvas(String tabName){
		EmbeddedCanvas canvas;
		try {
			canvas = super.getCanvas(tabName);
		} catch (NullPointerException e) {
			throw new InvalidParameterException("Cannot access tab: "+tabName+". Required tab doesn't exist");
		}
		return canvas;
		
	}
	
	
	
	
	
	/**
	 * Add a tab to the frame
	 * 
	 * @param tabName name of the new tab
	 * @param numberOfRows number of columns of the new tab
	 * @param numberOfColumns number of rows of the new tab
	 */
	public void addTab(String tabName, int numberOfRows, int numberOfColumns){
		this.addCanvas(tabName);
		this.getCanvas(tabName).divide(numberOfColumns, numberOfRows);
		this.getCanvas(tabName).setGridX(true);
		this.getCanvas(tabName).setGridY(true);
		
		if(largeSize){
			this.getCanvas(tabName).setTitleSize(20);
			this.getCanvas(tabName).setAxisTitleSize(18);
			this.getCanvas(tabName).setAxisLabelSize(18);
		}else{
			this.getCanvas(tabName).setTitleSize(12);
			this.getCanvas(tabName).setAxisTitleSize(10);
			this.getCanvas(tabName).setAxisLabelSize(10);
		}
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
	public void create1DHisto(String tabName, int row, int column, String histoName, String title, String titleX, int binX, double minX, double maxX){
		H1F newHisto = new H1F(histoName, binX, minX, maxX);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		this.add1DHisto(newHisto);
		
		this.cdPad(tabName, row, column);
		this.getCanvas(tabName).draw(newHisto, "same");
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
	public void create2DHisto(String tabName, int row, int column, String histoName, String title, String titleX, String titleY, int binX, double minX, double maxX, int binY, double minY, double maxY){
		H2F newHisto = new H2F(histoName, binX, minX, maxX, binY, minY, maxY);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		newHisto.setTitleY(titleY);
		this.add2DHisto(newHisto);
		
		this.cdPad(tabName, row, column);
		this.getCanvas(tabName).draw(newHisto, "same");
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
	 * Create and plot a new graph
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param graphName graph name (not displayed)
	 * @param title graph title
	 * @param titleX graph X-axis title
	 * @param titleY graph Y-axis title
	 */
	public void createGraph(String tabName, int row, int column, String graphName, String title, String titleX, String titleY){
		this.createGraph(tabName, row, column, graphName, title, titleX, titleY, new double[0], new double[0], new double[0], new double[0]);
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
	public void createGraph(String tabName, int row, int column, String graphName, String title, String titleX, String titleY, double[] valuesX, double[] valuesY){
		this.createGraph(tabName, row, column, graphName, title, titleX, titleY, valuesX, valuesY, new double[valuesX.length], new double[valuesY.length]);
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
	public void createGraph(String tabName, int row, int column, String graphName, String title, String titleX, String titleY, double[] valuesX, double[] valuesY, double[] errorsX, double[]errorsY){
		GraphErrors newHisto = new GraphErrors(graphName, valuesX, valuesY, errorsX, errorsY);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		newHisto.setTitleY(titleY);
		this.addGraph(newHisto);
		
		this.cdPad(tabName, row, column);
		this.getCanvas(tabName).draw(newHisto, "same");	
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
		this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		this.getCanvas(tabName).draw(newHisto, "same");	
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
	 * Change title of a pad
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param newTitle new title to use
	 */
	public void setPadTitle(String tabName, int row, int column, String newTitle){
		this.getPad(tabName, row, column).setTitle(newTitle);
	}
	
	/**
	 * Add a stat box for a given pad
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param statBoxValue elements to display in the stat box (binary mask representing Integral/ Overflow/ Underflow/ RMS/ Mean/ Entries/ Name). For instance : 1110 will display RMS/ Mean/ Entries and 1001111 will display Integral/ RMS/ Mean/ Entries/ Title)
	 */
	public void addStatBox(String tabName, int row, int column, int statBoxValue){
		this.getPad(tabName, row, column).setOptStat(statBoxValue);
	}
	
	/**
	 * Add a stat box for a given pad
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param title 1 to display title, 0 else
	 * @param entries 1 to display entries, 0 else
	 * @param mean 1 to display mean, 0 else
	 * @param rms 1 to display rms, 0 else
	 * @param underflow 1 to display underflow, 0 else
	 * @param overflow 1 to display overflow, 0 else
	 * @param integral 1 to display integral, 0 else
	 */
	public void addStatBox(String tabName, int row, int column, int title, int entries, int mean, int rms, int underflow, int overflow, int integral){
		if ( (title!=0&&title!=1)||(entries!=0&&entries!=1)||(mean!=0&&mean!=1)||(rms!=0&&rms!=1)||(underflow!=0&&underflow!=1)||(overflow!=0&&overflow!=1)||(integral!=0&&integral!=1)){
			 throw new InvalidParameterException("Parameters have to be 0 or 1");
		}else{
			int statBoxValue = title + 10 * entries + 100 * mean + 1000 * rms + 10000 * underflow + 100000 * overflow + 1000000 * integral;
			this.getPad(tabName, row, column).setOptStat(statBoxValue);
		}
	}
	
	/**
	 * Set X-axis to log
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param logX true to set X-axis to log, false else
	 */
	public void setLogX(String tabName, int row, int column, boolean logX){
		this.getPad(tabName, row, column).getAxisY().setLog(logX);
	}
	
	/**
	 * Set Y-axis to log
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param logY true to set Y-axis to log, false else
	 */
	public void setLogY(String tabName, int row, int column, boolean logY){
		this.getPad(tabName, row, column).getAxisY().setLog(logY);
	}
	
	/**
	 * Set Z-axis to log
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 * @param logZ true to set Z-axis to log, false else
	 */
	public void setLogZ(String tabName, int row, int column, boolean logZ){
		this.getPad(tabName, row, column).getAxisY().setLog(logZ);
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
	
	/**
	 * Read and plot an histo from a hipo file
	 * @param histoName name of the histo to look for
	 * @param fileToRead hipo file to read (use the following format: /path/file.hipo)
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 */
	public void readAndPlot1D(String histoName, String fileToRead, String tabName, int row, int column){
		System.out.println(" ================== READ ====================");
		TDirectory dirRead = new TDirectory();
		
		dirRead.readFile(fileToRead);
		H1F readHisto = (H1F) dirRead.getObject("/H1F/"+histoName);
		
		this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		this.getCanvas(tabName).draw(readHisto, "same");
		System.out.println(" ================== READ DONE ====================");
	}
	
	/**
	 * Read and plot an histo from a hipo file
	 * @param histoName name of the histo to look for
	 * @param fileToRead hipo file to read (use the following format: /path/file.hipo)
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 */
	public void readAndPlot2D(String histoName, String fileToRead, String tabName, int row, int column){
		System.out.println(" ================== READ ====================");
		TDirectory dirRead = new TDirectory();
		
		dirRead.readFile(fileToRead);
		H2F readHisto = (H2F) dirRead.getObject("/H2F/"+histoName);
		
		this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		this.getCanvas(tabName).draw(readHisto, "same");
		System.out.println(" ================== READ DONE ====================");
	}
	
	/**
	 * Read and plot an histo from a hipo file
	 * @param graphName name of the graph to look for
	 * @param fileToRead hipo file to read (use the following format: /path/file.hipo)
	 * @param tabName name of the tab
	 * @param row row of the tab
	 * @param column column of the tab
	 */
	public void readAndPlotGraph(String graphName, String fileToRead, String tabName, int row, int column){
		System.out.println(" ================== READ ====================");
		TDirectory dirRead = new TDirectory();
		
		dirRead.readFile(fileToRead);
		GraphErrors readHisto = (GraphErrors) dirRead.getObject("/GRAPH/"+graphName);
		
		this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		this.getCanvas(tabName).draw(readHisto, "same");
		System.out.println(" ================== READ DONE ====================");
	}
	
}
