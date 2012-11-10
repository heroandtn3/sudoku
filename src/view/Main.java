/**
 * 
 */
package view;

import javax.swing.SwingUtilities;

/**
 * @author heroandtn3
 * @date Nov 10, 2012
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();
			}
		});
	}

}
