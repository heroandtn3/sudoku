/**
 * Su dung de tao cac o sudoku
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
	private final Color ERR_COLOR = Color.PINK;
	private int value; // gia tri cua box
	private boolean fixedValue; // gia tri cua o co co dinh hay khong
	private boolean err;
	private int row, col; // hang va cot trong ma tran
	private boolean selected; // kiem tra xem o co duoc chon hay khong

	/**
	 * Ham khoi tao BoxLabel
	 * 
	 */
	public BoxLabel(int row, int col) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.col = col;
		reset();
		setOpaque(true);
		setOriColor();
		setPreferredSize(new Dimension(Constant.BOX_SIZE, Constant.BOX_SIZE));
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new java.awt.Font("Segoe UI", Font.BOLD, 22));
		addMouseListener(this);
	}
	
	public void reset() {
		setValue(0); // mac dinh bang 0
		fixedValue = false;
		err = false;
		selected = false;
		setOriColor();
		setFixedValue(false);
	}
	
	private void setOriColor() {
		if (!err && !selected) {
			setBackground(ORI_COLOR);
			this.validate();
		}
	}
	
	private void setChoiceColor() {
		setBackground(CHOICE_COLOR);
		this.validate();
	}
	
	private void setHoverColor() {
		if (!selected) {
			setBackground(HOVER_COLOR);
			this.validate();
		}
	}
	
	private void setErrColor() {
		if (!selected) {
			setBackground(ERR_COLOR);
			this.validate();
		}
	}
	
	/**
	 * Chon box
	 */
	public void select() {
		this.setChoiceColor();
		selected = true;
		
	}
	
	/**
	 * Bo chon box
	 */
	public void deselect() {
		selected = false;
		if (err) {
			this.setErrColor();
		} else {
			this.setOriColor();
		}
	}

	/**
	 * Set gia tri cho box
	 * @param value: gia tri so, nam trong khoang tu 1 den 9
	 * - neu la 0 thi tuc la xoa o
	 */
	public void setValue(int value) {
		if (fixedValue == false) {
			this.value = value;
			if (value == 0) {
				this.setText("");
			} else {
				this.setText("" + value);
			}
		}
		
	}

	public void setFixedValue(boolean fixed) {
		this.fixedValue = fixed;
		if (fixed) {
			this.setForeground(Color.RED);
		} else {
			this.setForeground(Color.BLACK);
		}
	}
	
	/**
	 * 
	 * @param error
	 */
	public void setError(boolean error) {
		if (error == true) {
			this.setErrColor();
			setErr(true);
		}
		else {
			setErr(false);
			this.setOriColor();
		}	
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
		this.setHoverColor();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!selected) {
			if (err) {
				this.setErrColor();
			} else {
				this.setOriColor();
			}
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

	public boolean isErr() {
		return err;
	}

	public void setErr(boolean err) {
		this.err = err;
	}


}
