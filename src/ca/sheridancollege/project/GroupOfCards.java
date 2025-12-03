/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * BlackjackGame
 * Author: Gurmukhtiar Singh,Shaanpreet Singh ,Harsh Paul , Manvir Singh
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
