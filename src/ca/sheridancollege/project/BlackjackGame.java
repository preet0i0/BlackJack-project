/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * BlackjackGame
 * Author: Gurmukhtiar Singh,Shaanpreet Singh ,Harsh Paul , Manvir Singh
 */
import java.util.Scanner;

public class BlackjackGame extends Game {

    private Deck deck;
    private BlackjackPlayer player;
    private Dealer dealer;
    private Scanner scanner;

    public BlackjackGame() {
        super("Blackjack");

        this.deck = new Deck();
        this.player = new BlackjackPlayer("Player");
        this.dealer = new Dealer("Dealer");
        this.scanner = new Scanner(System.in);

        // keep Game's player list in sync
        getPlayers().add(player);
        getPlayers().add(dealer);
    }

    private void dealInitial() {
        player.resetHand();
        dealer.resetHand();

        if (deck.cardsRemaining() < 15) {
            deck = new Deck();
        }

        player.getHand().add(deck.drawCard());
        dealer.getHand().add(deck.drawCard());
        player.getHand().add(deck.drawCard());
        dealer.getHand().add(deck.drawCard());
    }

    @Override
    public void play() {
        System.out.println("=== Welcome to Blackjack ===");
        boolean again = true;

        while (again) {
            dealInitial();
            showHands(false);

            playerTurn();

            if (!player.getHand().isBust()) {
                dealerTurn();
            }

            declareWinner();

            System.out.print("Play again? (y/n): ");
            String ans = scanner.nextLine().trim().toLowerCase();
            again = ans.startsWith("y");
        }

        System.out.println("Thanks for playing!");
    }

    private void playerTurn() {
        while (true) {
            System.out.println("\nYour hand: " + player.getHand());
            System.out.println("Dealer shows: " +
                    dealer.getHand().getCards().get(0));

            if (player.getHand().isBlackjack()) {
                System.out.println("Blackjack!");
                break;
            }
            if (player.getHand().isBust()) {
                System.out.println("You bust!");
                break;
            }

            System.out.print("Hit or stand? (h/s): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.startsWith("h")) {
                player.getHand().add(deck.drawCard());
            } else if (choice.startsWith("s")) {
                break;
            } else {
                System.out.println("Please enter h or s.");
            }
        }
    }

    private void dealerTurn() {
        System.out.println("\nDealer's turn...");
        showHands(true);

        while (dealer.mustHit()) {
            System.out.println("Dealer hits.");
            dealer.getHand().add(deck.drawCard());
            showHands(true);

            if (dealer.getHand().isBust()) {
                System.out.println("Dealer busts!");
                return;
            }
        }

        System.out.println("Dealer stands.");
    }

    private void showHands(boolean showDealerFullHand) {
        System.out.println("\nYour hand: " + player.getHand());
        if (showDealerFullHand) {
            System.out.println("Dealer hand: " + dealer.getHand());
        } else {
            System.out.println("Dealer shows: " +
                    dealer.getHand().getCards().get(0) + " and [hidden]");
        }
    }

    @Override
    public void declareWinner() {
        int playerValue = player.getHand().bestValue();
        int dealerValue = dealer.getHand().bestValue();

        System.out.println("\n=== Final Hands ===");
        System.out.println("Your hand: " + player.getHand());
        System.out.println("Dealer hand: " + dealer.getHand());

        if (player.getHand().isBust()) {
            System.out.println("Dealer wins (you bust).");
        } else if (dealer.getHand().isBust()) {
            System.out.println("You win (dealer busts).");
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie (push).");
        }
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.play();
    }
}