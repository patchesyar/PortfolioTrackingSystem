import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * EquitySystem.java
 */

/**
 * Handles important functions relevant to Equities.
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class EquitySystem {

	ArrayList<String> indices; //An array of known market indices
	ArrayList<String> sector; //An array of known market sectors
	
	public EquitySystem(){
            
            indices = new ArrayList<String>();
            sector = new ArrayList<String>();
                indices.add("DOW");
		indices.add("NASDAQ100");
		sector.add("TECHNOLOGY");
		sector.add("FINANCE");
		sector.add("TRANSPORTATION");
		sector.add("HEALTH CARE");
	}
	
	public void importEquity(TrackingSystem tSys, File f){
        BufferedReader fileReader = null;
        String n;
        double v;
        String tick;
        String mark = null;
        String ind = null;
        String type = "Stock";
         
        //Delimiter used in CSV file
        final String DELIMITER = ",";
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(f));
             
            //Read the file line by line
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                tokens[0] = tokens[0].substring(1, tokens[0].length() - 1);
                tick = tokens[0];
                tokens[1] = tokens[1].substring(1, tokens[1].length() - 1);
                n = tokens[1];
                tokens[2] = tokens[2].substring(1, tokens[2].length() - 1);
                v = Double.parseDouble(tokens[2]);
                tokens[3] = tokens[3].substring(1, tokens[3].length()- 1);
                if(indices.contains(tokens[3])){
                	mark = tokens[3];
                }
                if(sector.contains(tokens[3])){
                	ind = tokens[3];
                }
                if(tokens.length == 5){
                    tokens[4] = tokens[4].substring(1, tokens[4].length() - 1);
                	if(indices.contains(tokens[4])){
                    	mark = tokens[4];
                    }
                    if(sector.contains(tokens[4])){
                    	ind = tokens[4];
                    }
                }
                
                Equity e = new Equity(n, v, tick, mark, ind, type);
                tSys.addEquity(e);
                
                tick = null;
                v = 0;
                n = null;
                mark = null;
                ind = null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
