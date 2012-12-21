/**
 * 
 */
package control;

import model.Grid;

/**
 * @author heroandtn3
 *
 */
public interface Generator {
	
	/**
	 * 
	 * @param level: level of difficul
	 * @return: grid that has been generated
	 */
	public Grid generate(int level);
}