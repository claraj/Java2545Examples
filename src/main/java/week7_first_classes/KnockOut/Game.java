package week7_first_classes.KnockOut;

import java.util.ArrayList;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;


/**
 *
 * Simple Knockout dice game.  For small children learning to add up :)
 *
 * Players: 2 or more
 * Equipment: 2 dice
 *
 * Game play:
 *
 * Each player picks their own knockout number: 6, 7, 8 or 9.
 *
 * Each player takes turns rolling two dice. If the total of their dice is their knockout number,
 * they are knocked out of the game.
 *
 * Play continues until only one player is left. The last player not knocked out is the winner.
 *
 * */

public class Game {

    public static void main(String[] args) {
        new Game().playGame();
    }

    private DiceCup cup;
    private ArrayList<Player> players;

    private void playGame() {

        // Make a dice cup with 2 dice
        cup = new DiceCup(2);

        // How many players? Create player objects
        int numberOfPlayers = intInput("How many players?");
        players = createPlayers(numberOfPlayers);

        // Get each player's knock-out number. Can only be 6, 7, 8 or 9
        setKnockoutNumbers();

        // Play the game.
        play();

        // Print winner
        printGameResults();

    }


    // Create and return an ArrayList of players.
    private ArrayList<Player> createPlayers(int numberOfPlayers) {

        ArrayList<Player> players = new ArrayList<>();

        for (int p = 1 ; p <= numberOfPlayers ; p++) {

            String name = stringInput("Enter player " + p + "'s name:");
            Player player = new Player(name);
            players.add(player);

        }

        return players;
    }


    // For all the players in the players ArrayList, set their knockout number.
    private void setKnockoutNumbers() {

        for (Player p : players) {

            int knockOutNumber;

            do {
                knockOutNumber = intInput("Player " + p.getName() + ", " +
                        "please enter your knock-out number. It must be 6, 7, 8, or 9");
            } while (knockOutNumber < 6 || knockOutNumber > 9);     // Validation

            p.setKnockOutNumber(knockOutNumber);    // Set this player's knockout number

            // Nothing to return! Java objects are passed by reference, which means that there's only
            // one copy of the ArrayList<Player> players. This players object is the same object as the
            // players ArrayList<Player> in the playGame() method. So if this method modifies it,
            // then it's changed in the calling method.
        }
    }


    // Play the game for all of the players.
    private void play() {

        int playerIndex = 0;
        int totalPlayers = players.size();

        // Loop until there is only one player left.
        while (moreThanOnePlayerInPlay()) {

            Player currentPlayer = players.get(playerIndex);
            System.out.println();

            if (currentPlayer.isKnockedOut()) {
                System.out.println("Sorry player " + currentPlayer.getName() + ", you are knocked out.");

            } else {
                stringInput("Player " + currentPlayer.getName() + ", press enter to roll:");

                // Give the player the cup of dice, for them to roll the dice for their turn.
                String turnResult = currentPlayer.playTurn(cup);
                System.out.println(turnResult);

            }

            playerIndex = (playerIndex+1) % totalPlayers;  // For looping around the ArrayList
        }
    }


    //Count how many players are still in play
    private boolean moreThanOnePlayerInPlay() {

        int totalInPlay = 0;
        for (Player p : players) {
            if (!p.isKnockedOut()) {
                totalInPlay++;
            }
        }

        System.out.println("There are " + totalInPlay + " player(s) in the game");

        return totalInPlay > 1;
    }


    // Display the names of the players and who the winner is
    private void printGameResults() {

        System.out.println("\n**** GAME RESULTS ****\n");

        for (Player player : players) {

            if (player.isKnockedOut()) {
                System.out.println(player.getName() + " was knocked out");
            } else {
                System.out.println(player.getName() + " IS THE WINNER!!!!");

            }
        }
    }
}
