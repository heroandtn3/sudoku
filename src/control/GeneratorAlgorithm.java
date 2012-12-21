/**
 * 
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
