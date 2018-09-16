package com.sherbansoftware.cards;

/**
 * Card suit that can be used
 * 
 * @author Mihai Serban
 *
 */
public enum CardSuit {
	CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

	private String suitValue;

	CardSuit(String suit) {
		suitValue = suit;
	}

	public String toString() {
		return suitValue;
	}

	public static CardSuit fromString(String suitString) {
		CardSuit suit;
		if (suitString.equalsIgnoreCase("C")) {
			suit = CLUBS;
		} else if (suitString.equalsIgnoreCase("D")) {
			suit = DIAMONDS;
		} else if (suitString.equalsIgnoreCase("H")) {
			suit = HEARTS;
		} else {
			suit = SPADES;
		}
		return suit;
	}
}