package com.learning.hello.controller;

import java.util.ArrayList;
import java.util.List;

public class CardGame {

	        
	        private static List<Card> InPile = new ArrayList<>();
	        private static List<Card> OutPile = new ArrayList<>();
	        
	        public void distributeCards() {
		        Deck deck = new Deck();
		        deck.shuffle();

		      List<Card> InPile = new ArrayList<>();
		        List<Card> OutPile = new ArrayList<>();

		        while (deck.getLen()>0) {
		            InPile.add(deck.removeTop());
		            if (deck.getLen()>0) {
		                OutPile.add(deck.removeTop());
		            }
		        }

		        System.out.println("InPile: " + InPile);
		        System.out.println("OutPile: " + OutPile);
		    }
	        
	        public boolean verifyCardPosition(String inputCard, List<Card> pile) {
	            for (int i = 0; i < pile.size(); i++) {
	                if (pile.get(i).toString().equals(inputCard)) {
	                    System.out.println("The input card " + inputCard + " matches the card at position " + i);
	                    return true;
	                }
	            }
	            System.out.println("The input card " + inputCard + " does not match any card in the pile.");
	            return false;
	        }
	        
	        public static void main(String[] args) {
	        	CardGame c = new  CardGame();
	        	
	        	c.distributeCards();
	        	c.verifyCardPosition("QC", InPile);
	        	c.verifyCardPosition("9S", OutPile);
	        	
	        }

	 }

	 


