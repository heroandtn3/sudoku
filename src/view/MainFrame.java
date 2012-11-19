/**
 * 
 */
package view;

import javax.swing.JFrame;

/**
 * @author heroandtn3
 * @date Nov 10, 2012
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		setTitle("Sudoku");
		getContentPane().add(new BoxPanel());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
