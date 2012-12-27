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
