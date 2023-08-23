package com.learning.hello.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
	List<Card> cards = new ArrayList<Card>();
	public static int Max_cards = 13;
	public static int Max_suits = 4;
	
	public Deck() {
		for (int suit=1; suit<=Max_suits;suit++ ){
			for(int rank=1; rank<=Max_cards; rank++){
			cards.add(new Card(rank,suit));
			}
		
		}
	}
	
	public int getLen() {
		return cards.size();
	}
	
	public Card removeTop() {
		if (cards.isEmpty()) {
			System.out.println("No more cards left!");
			return null;
		}
		return cards.remove(0);
	}
	
	public Card removeBottom() {
		return cards.remove(cards.size() - 1);
	}
	
	public void addToTop(Card c) {
		cards.add(0,c);
	}
	
	public void addToBottom(Card c) {
		cards.add(52,c);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public String toString() {
		return cards.toString();
	
	}
}

