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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * PortfolioSystem.java
 */

/**
 * Handles important functions relevant to portfolio systems.
 * 
 * @author User
 *
 */
public class PortfolioSystem {

	public PortfolioSystem(){
		
	}
	
	/**
	 * Imports a Portfolio into the system
	 * 
	 * @param toP
	 * @param fromP
	 */
	public void ImportPortfolio(Portfolio toP, File f){
		BufferedReader reader = null;
		SimpleDateFormat dateF = new SimpleDateFormat("YYYY-MM-DD");
		Date date = new Date();
		
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
                if(tokens[0].equals("B")){
                	BankAccount b = new BankAccount(tokens[1], 
                			Double.parseDouble(tokens[2]),
                			dateF.format(date));
                	toP.addHoldings(b);
                }
                if(tokens[0].equals("C")){
                	CashAccount c = new CashAccount(tokens[1], 
                			Double.parseDouble(tokens[2]),
                			dateF.format(date));
                	toP.addHoldings(c);
                }
                if(tokens[0].equals("E")){
                	//To implement using importEquity function
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
	public void ExportPortfolio(Portfolio p){
		
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
			    		writer.write(((Equity) h).getIndex() + ",");
			    		writer.write(((Equity) h).getSector() + "\n");
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
}
