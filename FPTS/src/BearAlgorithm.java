/**
 * BearAlgorithm.java
 */

/**
 * A algorithm representing the change in price in a bear market
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class BearAlgorithm extends TemplateAlgorithm{

	private double pChange;
	private double sChange;
	
	/**
	 * A constructor
	 * 
	 * @param priceChange - The given per annum price change
	 */
	public BearAlgorithm(double priceChange){
		double temp = priceChange;
		pChange = temp;
	}
	
	public void simulate(int steps, Equity eObj, char type) {
		Equity temp = eObj;
		valueArray[0] = temp.getValue();//In case steps is set to zero
		resolveSChange(type);
		
		for(int i = 0; i < steps; i++){
			valueArray[i] = temp.getValue() - (temp.getValue() * sChange);
			temp.setValue(valueArray[i]);
		}
	}

	/**
	 * A function that marks the difference between the yearly change and 
	 *    step change. 
	 * 
	 * @param type - A char representing the time between steps
	 */
	private void resolveSChange(char type) {
		if(type == 'D'){
			sChange = pChange/356;
		}
		if(type == 'M'){
			sChange = pChange/12;
		}
		if(type == 'Y'){
			sChange = pChange;
		}
	}

}
