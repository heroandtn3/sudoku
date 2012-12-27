/**
 * interface for solving sudoku
 */
/*
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
