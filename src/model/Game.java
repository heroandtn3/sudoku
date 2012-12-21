/**
 * 
 */
package model;

/**
 * @author heroandtn3
 *
 */
public class Game {
	
	private int rowSelected; // hang va cot
	private int colSelected; // dang duoc chon
	private boolean error;
	private int savedErrorType;
	
	// tao mang ma tran de test
	private final int[][] matrixTest = {
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
	private Grid grid = new Grid(matrixTest);
	/**
	 * 
	 */
	public Game() {
		initGame();
	}
	
	public void initGame() {
		rowSelected = -1; // hang va cot
		colSelected = -1; // dang duoc chon
		error = false;
		savedErrorType = 0;
	}

	public int getRowSelected() {
		return rowSelected;
	}

	public void setRowSelected(int rowSelected) {
		this.rowSelected = rowSelected;
	}

	public int getColSelected() {
		return colSelected;
	}

	public void setColSelected(int colSelected) {
		this.colSelected = colSelected;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public int getSavedErrorType() {
		return savedErrorType;
	}

	public void setSavedErrorType(int savedErrorType) {
		this.savedErrorType = savedErrorType;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public int[][] getMatrixTest() {
		return matrixTest;
	}

}
