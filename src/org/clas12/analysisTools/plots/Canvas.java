package org.clas12.analysisTools.plots;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jlab.groot.data.GraphErrors;
import org.jlab.groot.data.H1F;
import org.jlab.groot.data.H2F;
import org.jlab.groot.graphics.EmbeddedCanvasTabbed;

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
	public ArrayList<H1F> getList1DHisto() {
		return list1DHisto;
	}
	
	/**
	 * @param list1dHisto the list1DHisto to set
	 */
	public void setList1DHisto(ArrayList<H1F> list1dHisto) {
		list1DHisto = list1dHisto;
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
		for (H1F histoIterator : list1DHisto){
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
		boolean plotExist=false;
		for (H1F histoIterator : list1DHisto){
			if (histoIterator.getName().equals(histo.getName())){
				plotExist=true;
			}
		}
		if (plotExist){
			System.out.println("Canvas error: Cannot create new histogram: "+histo.getName()+", an histogram with this name already exist.");
			throw new IllegalArgumentException("Histogram with that name already exists");
		}else{
			this.getList1DHisto().add(histo);
		}
	}
	
	/**
	 * @return the list2DHisto
	 */
	public ArrayList<H2F> getList2DHisto() {
		return list2DHisto;
	}
	
	/**
	 * @param list2dHisto the list2DHisto to set
	 */
	public void setList2DHisto(ArrayList<H2F> list2dHisto) {
		list2DHisto = list2dHisto;
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
		for (H2F histoIterator : list2DHisto){
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
		boolean plotExist=false;
		for (H2F histoIterator : list2DHisto){
			if (histoIterator.getName().equals(histo.getName())){
				plotExist=true;
			}
		}
		if (plotExist){
			System.out.println("Canvas error: Cannot create new histogram: "+histo.getName()+", an histogram with this name already exist.");
			throw new IllegalArgumentException("Histogram with that name already exists");
		}else{
			this.getList2DHisto().add(histo);
		}
	}
	
	/**
	 * @return the listGraph
	 */
	public ArrayList<GraphErrors> getListGraph() {
		return listGraph;
	}
	
	/**
	 * @param listGraph the listGraph to set
	 */
	public void setListGraph(ArrayList<GraphErrors> listGraph) {
		this.listGraph = listGraph;
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
			System.out.println("Plots error: Cannot fill graph "+graphName+", no graph with this name exist.");
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
		boolean graphFound=false;
		for (GraphErrors graphIterator : listGraph){
			if (graphIterator.getName().equals(graph.getName())){
				graphFound=true;
			}
		}
		if (graphFound){
			System.out.println("Canvas error: Cannot create new graph: "+graph.getName()+", graph with this name already exist.");
			throw new IllegalArgumentException("Graph with that name already exists");
		}else{
			this.getListGraph().add(graph);
		}
	}
	
	
	
	
	
	/**
	 * Add a tab to the frame
	 * 
	 * @param tabName name of the new tab
	 * @param numberOfColumns number of columns of the new tab
	 * @param numberOfRows number of rows of the new tab
	 */
	public void addTab(String tabName, int numberOfColumns, int numberOfRows){
		this.addCanvas(tabName);
		this.getCanvas(tabName).divide(numberOfRows,  numberOfColumns);
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
	 * Create a new 2D histogram
	 * @param tabName name of the tab
	 * @param rowrow of the tab
	 * @param column column of the tab
	 * @param histoName histogram name (not displayed)
	 * @param title histogram title
	 * @param titleX histogram X-axis title
	 * @param binXnumber of bins along X-axis
	 * @param minX minimum value for X-axis
	 * @param maxX maximum value for X-axis
	 * @param logY true to have logarithmic Y-axis, false else
	 */
	public void create1DHisto(String tabName, int row, int column, String histoName, String title, String titleX, int binX, double minX, double maxX, boolean logY){
		H1F newHisto = new H1F(histoName, binX, minX, maxX);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		this.add1DHisto(newHisto);
		
		this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		this.getCanvas(tabName).draw(newHisto, "same");
		if (logY){
			this.getCanvas(tabName).getPad().getAxisY().setLog(true);
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
	 * Create a new 2D histogram
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
	public void create2DHisto(String tabName, int row, int column, String histoName, String title, String titleX, String titleY, int binX, double minX, double maxX, int binY, double minY, double maxY, boolean logZ){
		H2F newHisto = new H2F(histoName, binX, minX, maxX, binY, minY, maxY);
		newHisto.setTitle(title);
		newHisto.setTitleX(titleX);
		newHisto.setTitleY(titleY);
		this.add2DHisto(newHisto);
		
		this.getCanvas(tabName).cd( (column-1)+this.getCanvas(tabName).getNColumns() *(row-1) );
		this.getCanvas(tabName).draw(newHisto, "same");
		if (logZ){
			this.getCanvas(tabName).getPad().getAxisZ().setLog(true);
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
	 * Create a new graph
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
	 * Create a new graph
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
	 * Create a new graph
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

}
