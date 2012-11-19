/**
 * Su dung de tao cac o sudoku
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * @author heroandtn3
 * @date Nov 19, 2012
 */
public class BoxLabel extends JLabel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Color ORI_COLOR = Color.WHITE;
	private final Color HOVER_COLOR = Color.BLUE;
	private final Color CHOICE_COLOR = Color.CYAN;
	private int value; // gia tri cua box
	private boolean selected; // kiem tra xem o co duoc chon hay khong

	/**
	 * Ham khoi tao BoxLabel
	 * @param value: gia tri khoi tao
	 */
	public BoxLabel() {
		// TODO Auto-generated constructor stub
		initVar();
		setOpaque(true);
		setBackground(ORI_COLOR);
		setPreferredSize(new Dimension(30, 30));
		addMouseListener(this);
	}
	
	/**
	 * Khoi tao gia tri cac bien
	 */
	private void initVar() {
		selected = false;
	}
	
	/**
	 * Chon/bo chon box
	 * @param select: true neu chon, false neu bo chon
	 */
	public void select(boolean select) {
		if (select) {
			setBackground(CHOICE_COLOR);
			selected = true;
		}
			
		else {
			setBackground(ORI_COLOR);
			selected = false;
		} 
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		select(true);
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
		if (!selected)
			setBackground(HOVER_COLOR);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!selected)
			setBackground(ORI_COLOR);
		
	}
	
	

}
