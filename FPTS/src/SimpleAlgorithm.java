/**
 * 
 */

/**
 * A algorithm in which the price of the equity remains the same.
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class SimpleAlgorithm extends TemplateAlgorithm{

	
	public void simulate(int steps, Equity eObj) {
		Equity temp = eObj;
		
		for(int i = 0; i < steps; i++){
			ValueArray[i] = temp.getValue();
		}
	}

}
