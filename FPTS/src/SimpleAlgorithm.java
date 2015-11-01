/**
 * SimpleAlgorithm.java
 */

/**
 * A algorithm in which the price of the equity remains the same.
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class SimpleAlgorithm extends TemplateAlgorithm{

	public SimpleAlgorithm(){
		
	}
	
	public void simulate(int steps, Equity eObj, char type) {
		Equity temp = eObj;
		valueArray[0] = temp.getValue();//In case steps is set to zero
		
		for(int i = 0; i < steps; i++){
			valueArray[i] = temp.getValue();
		}
	}

}
