/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * BlackjackGame
 * Author: Gurmukhtiar Singh,Shaanpreet Singh ,Harsh Paul , Manvir Singh
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends GroupOfCards {

    // Deck's own card list
    private ArrayList<Card> cards;

    public Deck() {
        super(52);

        cards = new ArrayList<>();

        // build a standard 52-card deck
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new BlackjackCard(r, s));
            }
        }

        shuffle();
    }

    // make GroupOfCards methods use THIS list
    @Override
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public BlackjackCard drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return (BlackjackCard) cards.remove(0);
    }

    public int cardsRemaining() {
        return cards.size();
    }
}