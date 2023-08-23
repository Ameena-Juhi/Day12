package com.learning.hello.controller;

import java.util.ArrayList;
import java.util.List;

public class CardGame {

	        
	        private static List<Card> InPile = new ArrayList<>();
	        private static List<Card> OutPile = new ArrayList<>();
	        
	        public String distributeCards() {
		        Deck deck = new Deck();
		        deck.shuffle();

		        while (deck.getLen()>0) {
		            InPile.add(deck.removeTop());
		            if (deck.getLen()>0) {
		                OutPile.add(deck.removeTop());
		            }
		        }

		        return("InPile: " + InPile + "OutPile: " + OutPile);
		       
		    }
	        
	        public List<Card> getInPile() {
	        	return InPile;
	        }
	        
	        public List<Card> getOutPile() {
	        	return OutPile;
	        }
	        
	        public String verifyCardPosition(String inputCard, String pile) {
	        	if(pile == "InPile") {
	            for (int i = 0; i < InPile.size(); i++) {
	                if (InPile.get(i).toString().equals(inputCard)) {
	                    System.out.println("The input card " + inputCard + " matches the card at position " + i);
	                    return "Game Won :) ";
	                	}
	                }
	            }
	        	else {
	        		for (int i = 0; i < OutPile.size(); i++) {
		                if (OutPile.get(i).toString().equals(inputCard)) {
		                    System.out.println("The input card " + inputCard + " matches the card at position " + i);
		                    return "Game Won :) ";
		                }
	        		}
	        	}
	            System.out.println("The input card " + inputCard + " does not match any card in the pile.");
	            return "Lost the game :( ";
	        }
	        
	        public static void main(String[] args) {
	        	CardGame c = new  CardGame();
	       
	        	c.distributeCards();
	        	c.verifyCardPosition("AH", "InPile");
	        	c.verifyCardPosition("AH", "OutPile");
	        	
	        }

	 }

	 


