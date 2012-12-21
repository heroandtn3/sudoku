/**
 * 
 */
package model;

import control.Generator;
import control.GeneratorAlgorithm;
import control.Solver;
import control.SolverBacktracking;

/**
 * @author heroandtn3
 *
 */
public class Game {
	
	private int rowSelected; // hang va cot
	private int colSelected; // dang duoc chon
	private boolean error;
	private int savedErrorType;
	
	private Grid gridOri;
	private Grid gridSolving;
	private Solver solver = new SolverBacktracking();
	private Generator generator = new GeneratorAlgorithm();
	/**
	 * 
	 */
	public Game() {
		initGame();
	}
	
	public Game(int level) {
		generate(level);
		initGame();
	}
	
	public void initGame() {
		rowSelected = -1; // hang va cot
		colSelected = -1; // dang duoc chon
		error = false;
		savedErrorType = 0;
		if (gridOri != null) {
			gridSolving = new Grid(gridOri.toMatrix());
		}
	}
	
	public void generate(int level) {
		gridOri = generator.generate(level);
	}
	
	/**
	 * 
	 * @return: true if successful solving, or false if
	 * unsuccessful solving
	 */
	public boolean solve() {
		Grid result = solver.solve(gridOri);
		if (result != null) {
			gridSolving = result;
			return true;
		} else {
			return false;
		}
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

	public Grid getGridSolving() {
		return gridSolving;
	}

	public void setGridSolving(Grid grid) {
		this.gridSolving = grid;
	}

	public Grid getGridOri() {
		return gridOri;
	}

}
