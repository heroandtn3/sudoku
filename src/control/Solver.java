/**
 * interface for solving sudoku
 */
package control;

import model.Grid;

/**
 * @author heroandtn3
 *
 */
public interface Solver {
	/**
	 * 
	 * @param grid: grid to be solved
	 * @return: grid that has been solved
	 * null if can not be solved
	 */
	public Grid solve(final Grid grid); 
}
