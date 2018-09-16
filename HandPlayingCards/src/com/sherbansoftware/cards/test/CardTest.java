package com.sherbansoftware.cards.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.sherbansoftware.cards.Card;
import com.sherbansoftware.cards.CardRank;
import com.sherbansoftware.cards.CardSuit;

public class CardTest extends JUnitCore {

	// deterministic methods
	@Test
	public void testToString() {
		Card ac = new Card(CardRank.ACE, CardSuit.CLUBS);
		assertEquals("AC", ac.toString());
	}
 
	//test - create cards from input strings
	@Test
	public void testFromStrings() {
		Card ah1 = Card.fromStrings("A", "H");
		Card ah2 = new Card(CardRank.ACE, CardSuit.HEARTS);

		assertEquals(ah1, ah2);
	}
}
