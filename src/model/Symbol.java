/**
 * 
 */
package model;

/**
 * @author heroandtn3
 *
 */
public enum Symbol {
	EMPTY (0),
	ONE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9);
	
	int value;
	
	Symbol(int value) {
		this.value = value;
	}
	
	public static Symbol fromInt(int value) {
		switch (value) {
			case 0:
				return EMPTY;
			case 1:
				return ONE;
			case 2:
				return TWO;
			case 3:
				return THREE;
			case 4:
				return FOUR;
			case 5:
				return FIVE;
			case 6:
				return SIX;
			case 7:
				return SEVEN;
			case 8:
				return EIGHT;
			case 9:
				return NINE;
			default:
				return EMPTY;
		}
	}
	
	public static int toInt(Symbol sb) {
		switch (sb) {
			case EMPTY:
				return 0;
			case ONE:
				return 1;
			case TWO:
				return 2;
			case THREE:
				return 3;
			case FOUR:
				return 4;
			case FIVE:
				return 5;
			case SIX:
				return 6;
			case SEVEN:
				return 7;
			case EIGHT:
				return 8;
			case NINE:
				return 9;
			default:
				return 0;
		}
	}
}
