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
	private BoxLabel[][] boxs = new BoxLabel[SDK_SIZE][SDK_SIZE];
	private int rowSelected = -1; // hang va cot
	private int colSelected = -1; // dang duoc chon
	private boolean error = false;
	private int savedErrorType = 0;
	
	// tao mang ma tran de test
	private int[][] matrix = {
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

	/**
	 * 
	 */
	public GamePanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(SDK_SIZE, SDK_SIZE, 
				Constant.BOX_PADDING, Constant.BOX_PADDING));
		initGUI();
		setBackground(Color.GRAY);
		addKeyListener(this);
		setFocusable(true);
		validate();
	}

	private void initGUI() {
		for (int i = 0; i < SDK_SIZE; i++) {
			for (int j = 0; j < SDK_SIZE; j++) {
				BoxLabel box = new BoxLabel(i, j);
				boxs[i][j] = box;
				add(box);
				if (matrix[i][j] != 0) {
					box.setFixedValue(matrix[i][j]);
				}
				
				// ve cac duong ngang
				if (i == 3 || i == 6)
					box.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
				// ve cac duong doc
				if (j == 3 || j == 6) {
					box.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
					if (i == 3 || i == 6) {
						// fix lai cac diem giao nhau
						box.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY));
					}
				}
				box.addMouseListener(boxClickEvent);	
			}
		}
	}
	
	
	private MouseListener boxClickEvent = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (error == true) {
				System.out.println("Ban phai sua loi da roi moi duoc dien tiep");
			} else {
				// deselect box da chon
				if (rowSelected != -1) { 
					// kiem tra xem da co o nao chon chua
					// neu co thi deselect no de chon cai khac
					boxs[rowSelected][colSelected].deselect();
				}
				
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
			case KeyEvent.VK_UP:
				if (rowSelected != -1) {
					// da co box duoc chon truoc do
					int tmp = rowSelected - 1;
					if (tmp < 0) tmp = 8;
					selectBox(boxs[tmp][colSelected]);
				} else {
					// chua co box nao duoc chon
					// thi chon box duoi cung ben trai
					selectBox(boxs[8][0]);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (rowSelected != -1) {
					// da co box duoc chon truoc do
					int tmp = colSelected + 1;
					if (tmp > 8) tmp = 0;
					selectBox(boxs[rowSelected][tmp]);
				} else {
					// chua co box nao duoc chon
					// thi chon box tren cung ben trai
					selectBox(boxs[0][0]);
				}
				break;
			case KeyEvent.VK_DOWN:
				if (rowSelected != -1) {
					// da co box duoc chon truoc do
					int tmp = rowSelected + 1;
					if (tmp > 8) tmp = 0;
					selectBox(boxs[tmp][colSelected]);
				} else {
					// chua co box nao duoc chon
					// thi chon box tren cung ben trai
					selectBox(boxs[0][0]);
				}
				break;
			case KeyEvent.VK_LEFT:
				if (rowSelected != -1) {
					// da co box duoc chon truoc do
					int tmp = colSelected - 1;
					if (tmp < 0) tmp = 8;
					selectBox(boxs[rowSelected][tmp]);
				} else {
					// chua co box nao duoc chon
					// thi chon box duoi cung ben phai
					selectBox(boxs[8][8]);
				}
				break;
			default:
			{
				if (rowSelected != -1) { // neu da co o chon
					if (e.getKeyCode() == KeyEvent.VK_DELETE ||
						e.getKeyCode() == KeyEvent.VK_SPACE) {
						boxs[rowSelected][colSelected].setValue(-1);
						if (error) {
							hightLightError(rowSelected, colSelected, savedErrorType, false);
							error = false;
						}
					} else {
						Character c = e.getKeyChar();
						if (c >= '1' && c <= '9') { // khong che gia tri trong khoang tu 1 den 9
							if (error) {
								hightLightError(rowSelected, colSelected, savedErrorType, false);
								error = false;
							}
							boxs[rowSelected][colSelected].setValue(Integer.parseInt(c.toString()));
							Checker checker = new Checker();
							int errorType = checker.getErrorType(boxs, rowSelected, colSelected);
							if (errorType != 0) {
								hightLightError(rowSelected, colSelected, errorType, true);
								error = true;
								savedErrorType = errorType;
							} else {
								error = false;
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
		if (rowSelected != -1) { 
			// kiem tra xem da co o nao chon chua
			// neu co thi deselect no de chon cai khac
			boxs[rowSelected][colSelected].deselect();
		}
		
		box.select(); // chon box moi
		// luu lai vet
		rowSelected = box.getRow();
		colSelected = box.getCol();
	}
	
	/**
	 * Hilight error boxs
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

}
