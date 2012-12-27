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
package model;

import control.Generator;
import control.GeneratorStraighForward;
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
	private Generator generator = new GeneratorStraighForward();
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
	 * @return: true if successful solving, or false if unsuccessful solving
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
