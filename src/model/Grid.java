/**
 * 
 */
package model;

import java.util.Arrays;

/**
 * @author heroandtn3
 *
 */
public class Grid {

	private final static int SIZE = Constant.SIZE;
	private Symbol[][] symbols;
	/**
	 * 
	 */
	public Grid() {
		// TODO Auto-generated constructor stub
		symbols = new Symbol[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			Arrays.fill(symbols[i], Symbol.EMPTY);
		}
	}
	
	/**
	 * 
	 * @param mt: 2D array
	 */
	public Grid(int[][] mt) {
		symbols = new Symbol[SIZE][SIZE];
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				symbols[row][col] = Symbol.fromInt(mt[row][col]);
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Symbol[][] getSymbols() {
		return symbols;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[][] toMatrix() {
		int[][] matrix = new int[SIZE][SIZE];
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				matrix[row][col] = Symbol.toInt(symbols[row][col]);
			}
		}
		return matrix;
	}

}
