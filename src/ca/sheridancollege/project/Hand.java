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
import java.util.List;

public class Hand {

    private List<BlackjackCard> cards = new ArrayList<>();

    public void add(BlackjackCard c) {
        cards.add(c);
    }

    public void clear() {
        cards.clear();
    }

    public List<BlackjackCard> getCards() {
        return cards;
    }

    // Sum without Ace adjustment
    public int hardValue() {
        int total = 0;
        for (BlackjackCard c : cards) {
            total += c.getValue();
        }
        return total;
    }

    // Best value (Aces 11 or 1)
    public int bestValue() {
        int total = 0;
        int aces = 0;

        for (BlackjackCard c : cards) {
            total += c.getValue();
            if (c.getRank().isAce()) {
                aces++;
            }
        }

        // while we’re bust and still have Aces counted as 11 -> make them 1
        while (total > 21 && aces > 0) {
            total -= 10; // 11 → 1
            aces--;
        }

        return total;
    }

    public boolean isBust() {
        return bestValue() > 21;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && bestValue() == 21;
    }

    @Override
    public String toString() {
        return cards.toString() + " (" + bestValue() + ")";
    }
}