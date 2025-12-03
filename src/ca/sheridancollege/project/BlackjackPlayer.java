/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * BlackjackGame
 * Author: Gurmukhtiar Singh,Shaanpreet Singh ,Harsh Paul , Manvir Singh
 */
public class BlackjackPlayer extends Player {

    private Hand hand = new Hand();

    public BlackjackPlayer(String name) {
        super(name);
    }

    public Hand getHand() {
        return hand;
    }

    public void resetHand() {
        hand.clear();
    }

    @Override
    public void play() {
        // decisions handled in BlackjackGame
    }
}
