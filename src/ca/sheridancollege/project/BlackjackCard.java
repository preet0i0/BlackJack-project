/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * BlackjackGame
 * Author: Gurmukhtiar Singh,Shaanpreet Singh ,Harsh Paul , Manvir Singh
 */

public class BlackjackCard extends Card {

    private Rank rank;
    private Suit suit;

    public BlackjackCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}