/**
 * SimulationAlgorithm.java
 */

/**
 * An interface that takes advantage of the stratedgy design pattern
 *    To implement different simulation algorithms.
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public abstract interface SimulationAlgorithm {

	/**
	 * The algorithm method that finds the value of the Equity as it changes
	 *    over time.
	 * 
	 * @param steps - How many steps the algorithm must make
	 * @param eObj - A given equity object.
	 */
	public void simulate(int steps, Equity eObj);
}
