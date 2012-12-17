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
	public Grid solve(final Grid grid); 
}
