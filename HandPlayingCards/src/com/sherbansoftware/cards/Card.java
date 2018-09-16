package com.sherbansoftware.cards;

import java.util.Comparator;

/**
 * represents a playing hand card, stores a suit and a rank.
 * 
 * @author Mihai Serban
 */
public class Card implements Comparable<Card> {
	public CardSuit suit;
	public CardRank rank;

	/**
	 * constructor with params that creates the card object
	 */
	public Card(CardRank rank, CardSuit suit) {
		this.rank = rank;
		this.suit = suit;

	}

	/**
	 * default constructor randomly generates a rank and a suit due to assignments
	 */
	public Card() {
		rank = CardRank.ACE;
		suit = CardSuit.CLUBS;
	}

	// create new card object from input strings
	public static Card fromStrings(String rank, String suit) {
		return new Card(CardRank.fromString(rank), CardSuit.fromString(suit));
	}

	@Override
	public String toString() {
		return String.format("%s%s", rank.toString(), suit.toString());
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Card) {
			Card othercard = (Card) other;
			return this.rank == othercard.rank && this.suit == othercard.suit;
		}
		return false;
	}

	@Override
	/**
	 * by default sort by card rank
	 */
	public int compareTo(Card card2) {
		CardRank rank2 = card2.rank;

		return this.rank.compareTo(rank2);
	}

	// old way
	public static Comparator<Card> cardRankComparator = new Comparator<Card>() {
		public int compare(Card card1, Card card2) {
			CardRank rank1 = card1.rank;
			CardRank rank2 = card2.rank;

			return rank1.compareTo(rank2);
		}
	};

	// Comparator using lambda expression java 8
	public static Comparator<Card> cardSuitComparator = (Card card1, Card card2) -> {
		CardSuit suit1 = card1.suit;
		CardSuit suit2 = card2.suit;

		return suit1.compareTo(suit2);
	};
	
}
