/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Grid;
import control.Solver;
import control.SolverBacktracking;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * @author heroandtn3
 *
 */
public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;
	private Solver solver = new SolverBacktracking();
	private JButton butSolve;
	/**
	 * 
	 */
	public MenuPanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setPreferredSize(new Dimension(gamePanel.getWidth(), 50));
				this.setBackground(new Color(165,42,42));
				this.setLayout(null);
				{
					butSolve = new JButton();
					this.add(butSolve);
					butSolve.setText("Solve");
					butSolve.setBounds(128, 12, 100, 30);
					butSolve.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							// solve the sudoku grid
							Grid grid = solver.solve(gamePanel.getGrid());
							gamePanel.drawBoxValue(grid);
						}
					});
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
