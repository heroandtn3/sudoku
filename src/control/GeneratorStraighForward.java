package control;

import java.util.ArrayList;

import model.Constant;
import model.Grid;

public class GeneratorStraighForward implements Generator {

	private final static int SIZE = Constant.SIZE;
	private int[][] matrix;
	private ArrayList<Grid> results = null;
	private int lastK;

	@Override
	public Grid generate(int level) {
		return makeGrid();
	}

	private Grid makeGrid() {
		return solve(new Grid(), true).get(0);
	}

	public ArrayList<Grid> solve(final Grid grid, boolean isNeedOne) {
		matrix = grid.toMatrix();
		lastK = SIZE * SIZE - 1;
		results = new ArrayList<Grid>();
		trySearch(0, isNeedOne);
		if (results.size() > 0) {
			return (results);

		} else {
			System.out.println("Khong co ket qua...");
			return null;
		}
	}
	private void trySearch(int k, boolean isNeedOne) {
		// loai bo cac o de bai
		while (matrix[k / SIZE][k % SIZE] != 0) {
			k++;
		}
		int row = k / SIZE, col = k % SIZE;

		int[] random = initRandom(SIZE);

		for (int x : random) { // duyet cac TH
			if (isOK(row, col, x)) {
				matrix[row][col] = x;
				if (k == lastK) {
					int[][] rs = new int[SIZE][SIZE];
					// copy ket qua sang 1 array khac
					for (int i = 0; i < SIZE; i++) {
						for (int j = 0; j < SIZE; j++) {
							rs[i][j] = matrix[i][j];
						}
					}
					results.add(new Grid(rs)); // them vao list
				} else {
					if (isNeedOne && (results.size() != 0))
						break;
					else
						trySearch(k + 1, isNeedOne);
				}
				matrix[row][col] = 0;
			}
		}
	}

	private int[] initRandom(int size) {
		int[] random = new int[size];

		for (int i = 1; i <= size; i++) {
			random[i - 1] = i;
		}

		for (int i = size; i > 0; i--) {
			int index = (int) (Math.random() * size);
			int temp = random[i - 1];
			random[i - 1] = random[index];
			random[index] = temp;
		}

		return random;
	}
	private boolean isOK(int row, int col, int x) {

		for (int i = 0; i < SIZE; i++) {
			if (matrix[row][i] == x || // kiem tra hang
					matrix[i][col] == x) { // kiem tra cot
				return false;
			}
		}

		for (int i = row - row % 3; i < row - row % 3 + 3; i++) {
			for (int j = col - col % 3; j < col - col % 3 + 3; j++) {
				if (matrix[i][j] == x) {
					return false;
				}
			}
		}
		return true;
	}

}
