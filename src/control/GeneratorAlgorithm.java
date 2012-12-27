/**
 * 
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
public class GeneratorAlgorithm implements Generator {

	/**
	 * 
	 */
	public GeneratorAlgorithm() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see control.Generator#generate(int)
	 */
	@Override
	public Grid generate(int level) {
		// tao mang ma tran de test
		final int[][] matrixTest = {
				{3, 0, 0, 0, 0, 0, 5, 0, 0},
				{0, 0, 0, 8, 0, 6, 0, 0, 0},
				{0, 2, 5, 0, 0, 0, 6, 0, 1},
				{7, 0, 9, 0, 3, 8, 0, 0, 4},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 9, 4, 0, 3, 0, 6},
				{8, 0, 3, 0, 0, 0, 7, 6, 0},
				{0, 0, 0, 3, 0, 4, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 9}
		};
		return (new Grid(matrixTest));
	}

}
