/**
 * TemplateAlgorithm
 */

/**
 * An abstract parent to the algorithm classes.
 * 
 * @author This team saved Olympic dreams with their beam routine
 */
public abstract class TemplateAlgorithm implements SimulationAlgorithm {

	double ValueArray[]; //The value of the equity over time
	
	TemplateAlgorithm(){
		
	}
	
	public double[] getValues(){
		return ValueArray;
	}
}
