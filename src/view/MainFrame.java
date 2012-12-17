/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * @author heroandtn3
 * @date Nov 10, 2012
 */
public class MainFrame extends JFrame {

	GamePanel gamePanel;
	MenuPanel menuPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		setTitle("Sudoku");
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		gamePanel = new GamePanel();
		cp.add(gamePanel, BorderLayout.CENTER);
		
		menuPanel = new MenuPanel(gamePanel);
		cp.add(menuPanel, BorderLayout.SOUTH);
		
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
