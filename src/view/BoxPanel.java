/**
 * Panel chua cac o sudoku
 */
package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Constant;

/**
 * @author heroandtn3
 * @date Nov 19, 2012
 */
public class BoxPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int SDK_SIZE = Constant.SIZE;
	private BoxLabel[][] boxs = new BoxLabel[SDK_SIZE][SDK_SIZE];

	/**
	 * 
	 */
	public BoxPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(SDK_SIZE, SDK_SIZE, 1, 1));
		initGUI();
	}

	private void initGUI() {
		for (int i = 0; i < SDK_SIZE; i++) {
			for (int j = 0; j < SDK_SIZE; j++) {
				boxs[i][j] = new BoxLabel();
				add(boxs[i][j]);
			}
		}
	}
}
