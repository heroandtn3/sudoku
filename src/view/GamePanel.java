/**
 * Panel chua cac o sudoku
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Constant;
import model.Game;
import model.Grid;
import control.Checker;

/**
 * @author heroandtn3
 * @date Nov 19, 2012
 */
public class GamePanel extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int SDK_SIZE = Constant.SIZE;
	private BoxLabel[][] boxs;
	private Game game = new Game();

	/**
	 * 
	 */
	public GamePanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(SDK_SIZE, SDK_SIZE, Constant.BOX_PADDING,
				Constant.BOX_PADDING));
		initGUI();
		resetView();
		setBackground(Color.GRAY);
		addKeyListener(this);
		setFocusable(true);
		validate();
	}

	private void initGUI() {
		boxs = new BoxLabel[SDK_SIZE][SDK_SIZE];
		for (int i = 0; i < SDK_SIZE; i++) {
			for (int j = 0; j < SDK_SIZE; j++) {
				BoxLabel box = new BoxLabel(i, j);
				// ve cac duong ngang
				if (i == 3 || i == 6)
					box.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
							Color.GRAY));
				// ve cac duong doc
				if (j == 3 || j == 6) {
					box.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0,
							Color.GRAY));
					if (i == 3 || i == 6) {
						// fix lai cac diem giao nhau
						box.setBorder(BorderFactory.createMatteBorder(1, 1, 0,
								0, Color.GRAY));
					}
				}
				box.addMouseListener(boxClickEvent);
				add(box);
				boxs[i][j] = box;
			}
		}
	}

	public void resetView() {
		for (int i = 0; i < SDK_SIZE; i++) {
			for (int j = 0; j < SDK_SIZE; j++) {
				boxs[i][j].reset();
			}
		}
		drawBoxValue(game.getGridOri(), true);
	}

	public void drawBoxValue(Grid grid, boolean fixed) {
		if (grid == null)
			return; // kiem tra tinh hop le cua grid
		int[][] mt = grid.toMatrix();
		for (int i = 0; i < SDK_SIZE; i++) {
			for (int j = 0; j < SDK_SIZE; j++) {
				if (mt[i][j] != 0) {
					boxs[i][j].setValue(mt[i][j]);
					if (fixed) {
						boxs[i][j].setFixedValue(true); // co dinh gia tri
					}
				}
			}
		}
	}

	public void drawBoxValue(boolean fixed) {
		drawBoxValue(game.getGridSolving(), fixed);
	}

	private MouseListener boxClickEvent = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (game.isError() == true) {
				System.out
						.println("Ban phai sua loi da roi moi duoc dien tiep");
			} else {
				BoxLabel source = (BoxLabel) e.getSource();
				selectBox(source);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	};

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP :
				if (game.getRowSelected() != -1) {
					// da co box duoc chon truoc do
					int tmp = game.getRowSelected() - 1;
					if (tmp < 0)
						tmp = 8;
					selectBox(boxs[tmp][game.getColSelected()]);
				} else {
					// chua co box nao duoc chon
					// thi chon box duoi cung ben trai
					selectBox(boxs[8][0]);
				}
				break;
			case KeyEvent.VK_RIGHT :
				if (game.getRowSelected() != -1) {
					// da co box duoc chon truoc do
					int tmp = game.getColSelected() + 1;
					if (tmp > 8)
						tmp = 0;
					selectBox(boxs[game.getRowSelected()][tmp]);
				} else {
					// chua co box nao duoc chon
					// thi chon box tren cung ben trai
					selectBox(boxs[0][0]);
				}
				break;
			case KeyEvent.VK_DOWN :
				if (game.getRowSelected() != -1) {
					// da co box duoc chon truoc do
					int tmp = game.getRowSelected() + 1;
					if (tmp > 8)
						tmp = 0;
					selectBox(boxs[tmp][game.getColSelected()]);
				} else {
					// chua co box nao duoc chon
					// thi chon box tren cung ben trai
					selectBox(boxs[0][0]);
				}
				break;
			case KeyEvent.VK_LEFT :
				if (game.getRowSelected() != -1) {
					// da co box duoc chon truoc do
					int tmp = game.getColSelected() - 1;
					if (tmp < 0)
						tmp = 8;
					selectBox(boxs[game.getRowSelected()][tmp]);
				} else {
					// chua co box nao duoc chon
					// thi chon box duoi cung ben phai
					selectBox(boxs[8][8]);
				}
				break;
			default : {
				if (game.getRowSelected() != -1) { // neu da co o chon
					if (e.getKeyCode() == KeyEvent.VK_DELETE
							|| e.getKeyCode() == KeyEvent.VK_SPACE) {
						boxs[game.getRowSelected()][game.getColSelected()]
								.setValue(-1);
						if (game.isError()) {
							hightLightError(game.getRowSelected(),
									game.getColSelected(),
									game.getSavedErrorType(), false);
							game.setError(false);
						}
					} else {
						Character c = e.getKeyChar();
						if (c >= '1' && c <= '9') { // khong che gia tri trong
													// khoang tu 1 den 9
							if (game.isError()) {
								hightLightError(game.getRowSelected(),
										game.getColSelected(),
										game.getSavedErrorType(), false);
								game.setError(false);
							}
							boxs[game.getRowSelected()][game.getColSelected()]
									.setValue(Integer.parseInt(c.toString()));
							Checker checker = new Checker();
							int errorType = checker.getErrorType(boxs,
									game.getRowSelected(),
									game.getColSelected());
							if (errorType != 0) {
								hightLightError(game.getRowSelected(),
										game.getColSelected(), errorType, true);
								game.setError(true);
								game.setSavedErrorType(errorType);
							} else {
								game.setError(false);
							}
						}
					}
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param box
	 */
	private void selectBox(BoxLabel box) {
		// deselect box da chon
		if (game.getRowSelected() != -1) {
			// kiem tra xem da co o nao chon chua
			// neu co thi deselect no de chon cai khac
			boxs[game.getRowSelected()][game.getColSelected()].deselect();
		}

		box.select(); // chon box moi
		// luu lai vet
		game.setRowSelected(box.getRow());
		game.setColSelected(box.getCol());
	}

	/**
	 * Hilight error boxs
	 * 
	 * @param row
	 * @param col
	 * @param type
	 * @param status
	 */
	private void hightLightError(int row, int col, int type, boolean status) {
		final int nrow = boxs.length;
		final int ncol = boxs[0].length;
		if ((type & 1) == 1) {
			// row error
			for (int i = 0; i < ncol; i++) {
				boxs[row][i].setError(status);
			}
		}

		if ((type & 2) == 2) {
			// col error
			for (int i = 0; i < nrow; i++) {
				boxs[i][col].setError(status);
			}
		}

		if ((type & 4) == 4) {
			// 3x3 error
			int startRow = row - row % 3;
			int startCol = col - col % 3;
			for (int i = startRow; i < startRow + 3; i++) {
				for (int j = startCol; j < startCol + 3; j++) {
					boxs[i][j].setError(status);
				}
			}
		}
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
