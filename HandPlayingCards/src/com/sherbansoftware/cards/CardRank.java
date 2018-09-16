package com.sherbansoftware.cards;

/**
 * Card ranks that can be used
 * 
 * @author Mihai Serban
 *
 */
public enum CardRank {
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(
			13);

	private final int rankIndex;

	CardRank(int cardRank) {
		rankIndex = cardRank;
	}

	public String toString() {
		String rankString;

		switch (this) {
		case ACE:
			rankString = "A";
			break;
		case JACK:
			rankString = "J";
			break;
		case QUEEN:
			rankString = "Q";
			break;
		case KING:
			rankString = "K";
			break;
		default:
			rankString = String.format("%d", rankIndex);
		}
		return rankString;
	}

	/**
	 * 
	 * @param rankString
	 *            Rank as string, one of {"A","2",...,"Q","K"}
	 * @return
	 */
	public static CardRank fromString(String rankString) {
		CardRank rank;
		if (rankString.equalsIgnoreCase("A")) {
			rank = ACE;
		} else if (rankString.equalsIgnoreCase("2")) {
			rank = TWO;
		} else if (rankString.equalsIgnoreCase("3")) {
			rank = THREE;
		} else if (rankString.equalsIgnoreCase("4")) {
			rank = FOUR;
		} else if (rankString.equalsIgnoreCase("5")) {
			rank = FIVE;
		} else if (rankString.equalsIgnoreCase("6")) {
			rank = SIX;
		} else if (rankString.equalsIgnoreCase("7")) {
			rank = SEVEN;
		} else if (rankString.equalsIgnoreCase("8")) {
			rank = EIGHT;
		} else if (rankString.equalsIgnoreCase("9")) {
			rank = NINE;
		} else if (rankString.equalsIgnoreCase("10")) {
			rank = TEN;
		} else if (rankString.equalsIgnoreCase("J")) {
			rank = JACK;
		} else if (rankString.equalsIgnoreCase("Q")) {
			rank = QUEEN;
		} else {
			rank = KING;
		}
		return rank;
	}

	public int rankIndex() {
		return rankIndex;
	}
}
