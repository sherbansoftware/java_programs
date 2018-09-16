
package com.sherbansoftware.cards.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.sherbansoftware.cards.Card;
import com.sherbansoftware.cards.CardCollection;
import com.sherbansoftware.cards.CardRank;
import com.sherbansoftware.cards.CardSuit;

/**
 * Test the List of cards
 *
 * @author Mihai Serban
 *
 */
public class CardCollectionTest extends JUnitCore {

	@Test
	public void testInitCount() {
		Card cards[] = { new Card(CardRank.ACE, CardSuit.CLUBS), new Card(CardRank.TWO, CardSuit.CLUBS),
				new Card(CardRank.THREE, CardSuit.HEARTS) };
		CardCollection cardCollection = new CardCollection(cards);
		assertEquals(3, cardCollection.elements());
	}

	@Test
	public void testInitFromString() {
		CardCollection cardCollection = new CardCollection("AS QH 10C 5D");
		Card cards[] = { new Card(CardRank.ACE, CardSuit.SPADES), new Card(CardRank.QUEEN, CardSuit.HEARTS),
				new Card(CardRank.TEN, CardSuit.CLUBS), new Card(CardRank.FIVE, CardSuit.DIAMONDS) };

		for (int i = 0; i < cards.length; i++) {
			assertEquals(cards[i], cardCollection.getAtIndex(i));
		}
	}

	@Test
	public void testInitAndAddCard() {
		CardCollection cardCollection = new CardCollection();
		cardCollection.addCard(new Card(CardRank.THREE, CardSuit.HEARTS));
		cardCollection.addCard(new Card(CardRank.SIX, CardSuit.HEARTS));
		cardCollection.addCard(new Card(CardRank.JACK, CardSuit.HEARTS));
		cardCollection.addCard(new Card(CardRank.EIGHT, CardSuit.SPADES));

		//assert that count of elements in list is 4
		assertEquals(4, cardCollection.elements());
	}

	@Test
	public void testToString() {
		Card cards[] = { new Card(CardRank.ACE, CardSuit.CLUBS), new Card(CardRank.TWO, CardSuit.CLUBS),
				new Card(CardRank.THREE, CardSuit.HEARTS) };
		CardCollection cardCollection = new CardCollection(cards);
		assertEquals("AC 2C 3H", cardCollection.toString());
	}

	// test sorting methods
	@Test
	public void testSortByRank() {
		Card cards[] = { new Card(CardRank.KING, CardSuit.CLUBS), new Card(CardRank.FOUR, CardSuit.CLUBS),
				new Card(CardRank.SIX, CardSuit.HEARTS) };
		CardCollection cardCollection = new CardCollection(cards);
		cardCollection.sortByRank();

		assertEquals("4C 6H KC", cardCollection.toString());
	}

	@Test
	public void testSortBySuit() {
		Card cards[] = { new Card(CardRank.KING, CardSuit.DIAMONDS), new Card(CardRank.FOUR, CardSuit.SPADES),
				new Card(CardRank.SIX, CardSuit.HEARTS) };
		CardCollection cardCollection = new CardCollection(cards);
		cardCollection.sortBySuit();

		assertEquals("KD 6H 4S", cardCollection.toString());
	}

	@Test
	public void testGetAtIndex() {
		Card cards[] = { new Card(CardRank.KING, CardSuit.DIAMONDS), new Card(CardRank.FIVE, CardSuit.SPADES),
				new Card(CardRank.SIX, CardSuit.HEARTS) };
		CardCollection cardCollection = new CardCollection(cards);
		Card fourOfSpades = new Card(CardRank.FIVE, CardSuit.SPADES);

		assertEquals(fourOfSpades, cardCollection.getAtIndex(1));
	}

	@Test
	public void testCardCollectionIterable() {
		HashMap<CardRank, CardCollection> cardRankMap = new HashMap<CardRank, CardCollection>();
		Card cards[] = { new Card(CardRank.KING, CardSuit.SPADES), new Card(CardRank.SIX, CardSuit.SPADES),
				new Card(CardRank.SIX, CardSuit.HEARTS) };
		CardCollection cardCollection = new CardCollection(cards);

		for (CardRank cardRank : CardRank.values()) {
			cardRankMap.put(cardRank, new CardCollection());
		}
		for (Card card : cardCollection) {
			cardRankMap.get(card.rank).addCard(card);
		}
		assertEquals(2, cardRankMap.get(CardRank.SIX).elements());
	}
}
