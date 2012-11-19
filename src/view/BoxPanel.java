/**
 * Panel chua cac o sudoku
 */
package view;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.Constant;

/**
 * @author heroandtn3
 * @date Nov 19, 2012
 */
public class BoxPanel extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int SDK_SIZE = Constant.SIZE;
	private final int CELL_SIZE = Constant.BOX_PADDING + Constant.BOX_SIZE;
	private BoxLabel[][] boxs = new BoxLabel[SDK_SIZE][SDK_SIZE];
	private int rowSelected = -1; // hang va cot
	private int colSelected = -1; // dang duoc chon

	/**
	 * 
	 */
	public BoxPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(SDK_SIZE, SDK_SIZE, 
				Constant.BOX_PADDING, Constant.BOX_PADDING));
		initGUI();
		addKeyListener(this);
		setFocusable(true);
	}

	private void initGUI() {
		for (int i = 0; i < SDK_SIZE; i++) {
			for (int j = 0; j < SDK_SIZE; j++) {
				boxs[i][j] = new BoxLabel(i, j);
				boxs[i][j].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						// deselect box da chon
						if (rowSelected != -1) { // kiem tra xem da chon chua
							boxs[rowSelected][colSelected].deselect();
						}
						
						BoxLabel source = (BoxLabel) e.getSource();
						source.select(); // chon box moi
						// luu lai vet
						rowSelected = source.getRow();
						colSelected = source.getCol();
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

				});
				add(boxs[i][j]);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (rowSelected != -1)
		boxs[rowSelected][colSelected].setText("" + e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
