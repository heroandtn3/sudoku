/**
 * Dam nhan viec kiem tra
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
public class Checker {
	
	/**
	 * Kiem tra xem o (row, col) trong grid gay ra loi gi va tra lai type cua
	 * loi do (la 1 so nguyen)
	 * @param grid: grid de kiem tra
	 * @param row, col: hang va cot cua o can kiem tra 
	 * @return: 1 so nguyen 3 bit
	 * - bit thu 0 neu hang do gay loi
	 * - bit thu 1 neu cot do gay loi
	 * - bit thu 2 neu o 3x3 chua o do bi loi
	 */
	public int getErrorType(final Grid grid, int row, int col) {
		int[][] matrix = grid.getMatrix();
		final int nrow = matrix.length;
		final int ncol = matrix[0].length;
		final int value = matrix[row][col]; // gia tri cua o can kiem tra
		int result = 0; // gia tri tra ve
		
		// kiem tra hang
		for (int i = 0; i < ncol; i++) {
			// i != col de loai bo, khong so sanh box dang xet
			if (i != col && (matrix[row][i] == value)) {
				result += 1;
				System.out.println("row error");
				break;
			}
		}
		
		// kiem tra cot
		for (int i = 0; i < nrow; i++) {
			if (i != row && (matrix[i][col] == value)) {
				result += 2;
				System.out.println("col error");
				break;
			}
		}
		
		// kiem tra o 3x3
		int startRow = row - row % 3;
		int startCol = col - col % 3;
		//System.out.printf("Row: %d, cold: %d\n", startRow, startCol);
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if ((i != row || j != col) && //de khong trung lap voi col, row
					matrix[i][j] == value) {
					result += 4;
					System.out.println("3x3 error");
					break;
				}
			}
		}
		
		return result;
	}

}
