package com.sherbansoftware.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CardCollection is a collection of Cards it allows iteration by: 
 * - rank
 * - suit 
 * - random
 *
 * @author Mihai Serban
 *
 */
public class CardCollection implements Iterable<Card> {
	private ArrayList<Card> cards;

	/**
	 * Default constructor initializes an empty collection of cards
	 */
	public CardCollection() {
		this.cards = new ArrayList<Card>();
	}

	/**
	 * Parses a string and instantiates a CardCollection with the corresponding
	 * cards.
	 * 
	 * @param cardsStr - a string of cards such E.g "2C 3H JD"
	 */
	public CardCollection(String cardsStr) {
		this.cards = new ArrayList<Card>();
		Matcher m = Pattern.compile("([2-9]|10|[AJKQ])([CDHS]) ?").matcher(cardsStr);

		String rankStr, suitStr;
		// attempts to find the next subsequence of the input sequence that matches the
		// pattern.
		while (m.find()) {
			rankStr = m.group(1);
			suitStr = m.group(2);
			cards.add(Card.fromStrings(rankStr, suitStr));
		}
	}

	public CardCollection(Card cards[]) {
		this.cards = new ArrayList<Card>();

		for (Card c : cards) {
			this.cards.add(c);
		}
	}

	public int elements() {
		return cards.size();
	}
	
	@Override
	public String toString() {
		StringBuffer cardCollectionStrBuf = new StringBuffer();

		for (int i = 0; i < cards.size(); i++) {
			cardCollectionStrBuf.append(cards.get(i).toString());
			if (i < cards.size() - 1) {
				cardCollectionStrBuf.append(" ");
			}
		}

		return cardCollectionStrBuf.toString();
	}

	public void sortByRank() {
		Collections.sort(cards, Card.cardRankComparator);
	}

	public void sortBySuit() {
		Collections.sort(cards, Card.cardSuitComparator);
	}

	public Card getAtIndex(int index) {
		return cards.get(index);
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}
}
