/**
 * 
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
	private JButton butSolve;
	private JButton butGen;
	private JButton butReset;
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
					// button for generate new sudoku grid
					butGen = new JButton();
					this.add(butGen);
					butGen.setText("Generate");
					butGen.setBounds(15, 12, 120, 30);
					butGen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							gamePanel.getGame().newPuzzle();
							gamePanel.getGame().initGame();
							gamePanel.resetView();
							gamePanel.requestFocusInWindow();
						}
					});
				}
				
				{
					// button for solver sudoku grid
					butSolve = new JButton();
					this.add(butSolve);
					butSolve.setText("Solve");
					butSolve.setBounds(150, 12, 80, 30);
					butSolve.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							// solve the sudoku grid
							if (gamePanel.getGame().solve() == true) {
								// successful solving
								gamePanel.resetView();
								gamePanel.drawBoxValue(false);
								gamePanel.validate();
							}
							gamePanel.requestFocusInWindow();
						}
					});
				}
				
				{
					butReset = new JButton();
					this.add(butReset);
					butReset.setText("Reset");
					butReset.setBounds(245, 12, 80, 30);
					butReset.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							gamePanel.resetView();
							gamePanel.requestFocusInWindow();
						}
					});
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
