/**
 * BullAlgorithm.java
 */

/**
 * A simulation of a bull market change over time.
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class BullAlgorithm extends TemplateAlgorithm {

	private double pChange; //A per annum price change
	private double sChange; //The change at each step, depends on the time between steps.
	
	/**
	 * A constructor for the BullAlgorithm
	 * 
	 * @param priceChange - The given per annum price change
	 */
	public BullAlgorithm(double priceChange){
		double temp = priceChange;
		pChange = temp;
	}
	
	public void simulate(int steps, Equity eObj, char type) {
		Equity temp = eObj;
		valueArray[0] = temp.getValue();//In case steps is set to zero
		resolveSChange(type);
		
		for(int i = 0; i < steps; i++){
			valueArray[i] = temp.getValue() + (temp.getValue() * sChange);
			temp.setValue(valueArray[i]);
		}
	}

	/**
	 * A function that marks the difference between the yearly change and 
	 *    step change. 
	 * 
	 * @param type - A char representing the time between steps
	 */
	private void resolveSChange(char type){
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
