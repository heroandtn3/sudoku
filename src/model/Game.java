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

import control.Checker;
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
	private boolean error; // co dang trong tinh trang loi hay khong
	
	/**
	 * neu loi thi kieu loi duoc luu lai
	 * la 1 so nguyen 3 bit:
	 * - bit thu 0 neu hang dang chon gay loi
	 * - bit thu 1 neu cot dang chon gay loi
	 * - bit thu 2 neu o 3x3 chua o dang chon gay loi
	 */
	private int errorType;
	private int level = 0;
	private Grid gridOri;
	private Grid gridSolving;
	private Checker checker = new Checker();
	private Solver solver = new SolverBacktracking();
	private Generator generator = new GeneratorStraighForward();
	private Thread genThread = new Thread(new GenerateRun());
	
	/**
	 * 
	 */
	public Game() {
		initGame();
		genThread.start();
	}

	public Game(int level) {
		this.level = level;
		newPuzzle();
		initGame();
		genThread.start();
	}

	public void initGame() {
		rowSelected = -1; // hang va cot
		colSelected = -1; // dang duoc chon
		error = false;
		errorType = 0;
		if (gridOri == null) {
			gridOri = new Grid();
		}
		gridSolving = new Grid(gridOri.getMatrix());
		
	}

	public void newPuzzle() {
		synchronized (gridOri) {
			System.out.println("Before Resuming...");
			gridOri.notifyAll();
			System.out.println("After Resuming...");
		}
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
	
	public boolean fillBoxByValue(int value) {
		if (gridOri.getMatrix()[rowSelected][colSelected] != 0) { 
			// khong cho sua o de bai
			return false;
		}
		
		if (0 <= value && value <= 9) { // kiem tra gia tri hop le
			gridSolving.getMatrix()[rowSelected][colSelected] = value;
			
			if (value == 0) { // neu la xoa o
				// thi loai bo loi
				errorType = 0;
				setError(false);
			} else {
				// kiem tra loi
				errorType = checker.getErrorType(
						gridSolving, 
						rowSelected, 
						colSelected);
				setError(errorType != 0); // danh dau (loi neu co)
			}
			
			return true;
		}
		return false;
	}
	
	public boolean fillBoxByValue(int row, int col, int value) {
		if (row < 0 || row > 8 || col < 0 || col > 8) {
			return false;
		}
		
		if (gridOri.getMatrix()[row][col] != 0) { // khong cho sua o de bai
			return false;
		}
		
		if (0 <= value && value <= 9) { // kiem tra gia tri hop le
			gridSolving.getMatrix()[row][col] = value;
			
			// kiem tra loi
			errorType = checker.getErrorType(gridSolving, row, col);
			if (errorType != 0) { // neu co loi
				setError(true);			// thi danh dau la co loi
			}
			return true;
		}
		return false;
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

	public Grid getGridSolving() {
		return gridSolving;
	}

	public void setGridSolving(Grid grid) {
		this.gridSolving = grid;
	}

	public Grid getGridOri() {
		return gridOri;
	}

	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	class GenerateRun implements Runnable {
		public volatile boolean stopped = false;
		@Override
		public void run() {
			
			while (!stopped) {
				synchronized (gridOri) {
					try {
						System.out.println("Waiting...");
						gridOri.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Running...");
					gridOri = generator.generate(level);
					System.out.println("Finish!");
				}
			}
		}
	}

}
