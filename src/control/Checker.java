/**
 * Dam nhan viec kiem tra
 */
package control;

import view.BoxLabel;

/**
 * @author heroandtn3
 *
 */
public class Checker {
	
	public int getErrorType(final BoxLabel[][] boxs, final int row, final int col) {
		final int nrow = boxs.length;
		final int ncol = boxs[0].length;
		final int value = boxs[row][col].getValue(); // gia tri cua box kiem tra
		int result = 0; // gia tri tra ve
		
		// kiem tra hang
		for (int i = 0; i < ncol; i++) {
			// i != col de loai bo, khong so sanh box dang xet
			if (i != col && (boxs[row][i].getValue() == value)) {
				result += 1;
				System.out.println("row");
				break;
			}
		}
		
		// kiem tra cot
		for (int i = 0; i < nrow; i++) {
			if (i != row && (boxs[i][col].getValue() == value)) {
				result += 2;
				System.out.println("col");
				break;
			}
		}
		
		// kiem tra o 3x3
		int startRow = row - row % 3;
		int startCol = col - col % 3;
		//System.out.printf("Row: %d, cold: %d\n", startRow, startCol);
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if ((i != row || j != col) && // de khong trung lap voi col, row
					boxs[i][j].getValue() == value) {
					result += 4;
					System.out.println("3x3");
					break;
				}
			}
		}
		
		return result;
	}

}
