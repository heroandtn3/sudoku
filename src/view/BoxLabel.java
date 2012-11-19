/**
 * Su dung de tao cac o sudoku
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Constant;

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
	private boolean fixedValue = false; // gia tri cua o co co dinh hay khong
	private int row, col; // hang va cot trong ma tran
	private boolean selected = false; // kiem tra xem o co duoc chon hay khong

	/**
	 * Ham khoi tao BoxLabel
	 * @param value: gia tri khoi tao
	 */
	public BoxLabel(int row, int col) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.col = col;
		setOpaque(true);
		setBackground(ORI_COLOR);
		setPreferredSize(new Dimension(Constant.BOX_SIZE, Constant.BOX_SIZE));
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new java.awt.Font("Segoe UI", Font.BOLD, 22));
		addMouseListener(this);
	}
	
	/**
	 * Chon box
	 */
	public void select() {
		setBackground(CHOICE_COLOR);
		selected = true;
		
	}
	
	/**
	 * Bo chon box
	 */
	public void deselect() {
		setBackground(ORI_COLOR);
		selected = false;
	}

	/**
	 * Set gia tri cho box
	 * @param value: gia tri so, nam trong khoang tu 1 den 9
	 */
	public void setValue(int value) {
		this.value = value;
		this.setText("" + value);
	}
	
	/**
	 * @param fixedValue the fixedValue to set
	 */
	public void setFixedValue(int value) {
		this.value = value;
		this.fixedValue = true;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
		if (!selected) {
				setBackground(HOVER_COLOR);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!selected) {
				setBackground(ORI_COLOR);
		}
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @return the fixedValue
	 */
	public boolean isFixedValue() {
		return fixedValue;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}


}
