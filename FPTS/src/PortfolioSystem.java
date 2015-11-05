import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * PortfolioSystem.java
 */

/**
 * Handles important functions relevant to portfolio systems. 
 *    Such as importing, exporting, buying holdings and simulations
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class PortfolioSystem {

	ArrayList<String> indices; //An array of known market indices
	ArrayList<String> sector; //An array of known market sectors
	
	public PortfolioSystem(){
            indices = new ArrayList<String>();
            sector = new ArrayList<String>();
		indices.add("DOW");
		indices.add("NASDAQ100");
		
		sector.add("TECHNOLOGY");
		sector.add("FINANCE");
		sector.add("TRANSPORTATION");
		sector.add("HEALTH CARE");
	}
	

	/**
	 * Import portfolio information from a file
	 * 
	 * @param toP - The portfolio to import information to
	 * @param f - A file that holds information
	 */
	public void importPortfolio(Portfolio toP, File f){
		BufferedReader reader = null;
		SimpleDateFormat dateF = new SimpleDateFormat("YYYY-MM-DD");
		Date date = new Date();
		
		//Equity variables
		String n;
        double v;
        String tick;
        String mark = null;
        String ind = null;
        String type = "Stock";
		
		final String DELIMITER = ",";
		try
        {
            String line = "";
            //Create the file reader
            reader = new BufferedReader(new FileReader(f));
             
            //Read the file line by line
            while ((line = reader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                
                //create Holding from the tokens
                //BankAccounts
                if(tokens[0].equals("B")){
                	BankAccount b = new BankAccount(tokens[1], 
                			Double.parseDouble(tokens[2]),
                			dateF.format(date));
                	toP.addHoldings(b);
                }
                
                //CashAccounts
                if(tokens[0].equals("C")){
                	CashAccount c = new CashAccount(tokens[1], 
                			Double.parseDouble(tokens[2]),
                			dateF.format(date));
                	toP.addHoldings(c);
                }
                
                //Equities
                if(tokens[0].equals("E")){
                	tick = tokens[0];
                	n = tokens[1];
                	v = Double.parseDouble(tokens[2]);
                	if(indices.contains(tokens[3])){
                    	mark = tokens[3];
                    }
                    if(sector.contains(tokens[3])){
                    	ind = tokens[3];
                    }
                    if(tokens[4] != null){
                    	if(indices.contains(tokens[4])){
                        	mark = tokens[4];
                        }
                        if(sector.contains(tokens[4])){
                        	ind = tokens[4];
                        }
                    }
                    
                    Equity e = new Equity(n, v, tick, mark, ind, type);
                    toP.addHoldings(e);
                    
                    tick = null;
                    v = 0;
                    n = null;
                    mark = null;
                    ind = null;
                    
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	/**
	 * Exports Portfolio data to a file
	 * 
	 * @param p - The portfolio
	 */
	public void exportPortfolio(Portfolio p){
		
		ArrayList<Holding> hList = p.getHoldings();
		
	    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	    	new FileOutputStream(p.getOwnerID() + "Portfolio.txt"), "utf-8"))) {
		        writer.write("//" + p.getOwnerID() + "Portfolio\n");
			    for(Holding h : hList){
			    	if(h.getType() == 'C'){
			    		writer.write("C," + h.getName() + ",");
			    		writer.write(Double.toString(h.getValue()));
			    		writer.write("\n");
			    	}
			    	if(h.getType() == 'B'){
			    		writer.write("B, " + h.getName() + ",");
			    		writer.write(Double.toString(h.getValue()));
			    		writer.write("\n");
			    	}
			    	if(h.getType() == 'E'){
			    		writer.write(((Equity) h).getTicker() + ",");
			    		writer.write("E," + h.getName() + ",");
			    		writer.write(Double.toString(h.getValue()));
			    		writer.write(",");
			    		if(((Equity) h).getIndex() != null){
			    			writer.write(((Equity) h).getIndex() + ",");
			    		}
			    		if(((Equity) h).getSector() != null){
			    			writer.write(((Equity) h).getSector());
			    		}
			    		writer.write("\n");
			    	}
			    }
	    } catch (UnsupportedEncodingException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    } catch (FileNotFoundException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	}
	

	/**
	 * Simulates a portfolios equities over time
	 * 
	 * @param p - The portfolio
	 * @param steps - Time steps
	 * @param time - What the time steps are(Years, Months or Days)
	 * @param tA - An algorithm object
	 * @return - An array of double arrays, representing the 
	 *     values of the equities over time in the order they appear
	 *     in the portfolio
	 */
	public double[][] simulate(Portfolio p, int steps, char time, TemplateAlgorithm tA){
		double[][] ret = null;
		int aPos = 0;
		ArrayList<Holding> hList = p.getHoldings();
		
		for(int i = 0; i < hList.size(); i++){
			if(hList.get(i).isEquity()){
				tA.simulate(steps, (Equity) hList.get(i), time);
				ret[aPos] = tA.getValues();
				aPos++;
			}
		}
		
		return ret;
	}
}
