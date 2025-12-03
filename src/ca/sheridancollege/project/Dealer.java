/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * BlackjackGame
 * Author: Gurmukhtiar Singh,Shaanpreet Singh ,Harsh Paul , Manvir Singh
 */
public class Dealer extends Player {

    private Hand hand = new Hand();

    public Dealer(String name) {
        super(name);
    }

    public Hand getHand() {
        return hand;
    }

    public void resetHand() {
        hand.clear();
    }

    public boolean mustHit() {
        // standard simple rule: hit on 16 or less
        return hand.bestValue() < 17;
    }

    @Override
    public void play() {
        // automated turn in BlackjackGame
    }
}
