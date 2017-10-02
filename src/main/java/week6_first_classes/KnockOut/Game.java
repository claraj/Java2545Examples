package week6_first_classes.KnockOut;

import java.util.ArrayList;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;


public class Game {
    
    public static void main(String[] args) {
        new Game().playGame();
    }
    
    private DiceCup cup;
    
    private void playGame() {
        
        // Make a dice cup with 2 dice
        cup = new DiceCup(2);
        
        // How many players? Create player objects
        int numberOfPlayers = intInput("How many players?");
        ArrayList<Player> players = createPlayers(numberOfPlayers);
        
        // Get each player's knock-out number. Can only be 6, 7 or 8
        getKnockoutNumbers(players);
        
        // Play one round of the game; until all players but one are knocked out
        
        // All players take turns
        play(players);
        
        // Print winner
        printGameResults(players);
        
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
    
    
    // For all the players in the players ArrayList, get their knockout number.
    private void getKnockoutNumbers(ArrayList<Player> players) {
        
        for (Player p : players) {
            
            int knockOutNumber;
            
            do {
            
                knockOutNumber = intInput("Player " + p.getName() + ", please enter your knock-out number. It must be 6, 7, or 8");
            
            } while ( knockOutNumber < 6 || knockOutNumber > 8 );     // Validation
             
            p.setKnockOutNumber(knockOutNumber);    // Set this player's knockout number
        }
    }
    
    
    // Play the game for all of the players.
    
    private void play(ArrayList<Player> players) {
        
        int playerIndex = 0;
        int totalPlayers = players.size();
        
        while (moreThanOnePlayerInPlay(players)) {
            
            Player currentPlayer = players.get(playerIndex);
            System.out.println();
            
            if (currentPlayer.isKnockedOut()) {
                
                System.out.println("Player " + currentPlayer.getName() + " you are knocked out.");
                
            } else {
                
                stringInput("Player " + currentPlayer.getName() + ", press enter to roll:");
                
                String turnResult = currentPlayer.playTurn(cup);
                System.out.println(turnResult);
                
            }
            
            playerIndex = (playerIndex+1) % totalPlayers;
        }
    }
    
    
    private boolean moreThanOnePlayerInPlay(ArrayList<Player> players) {
        
        //Count how many players are still in play
        
        int totalInPlay = 0;
        for (Player p : players) {
            if (!p.isKnockedOut()) {
                totalInPlay++;
            }
        }
        
        System.out.println("There are " + totalInPlay + " player(s) in the game");
        
        return totalInPlay > 1;
    }
    
    
    private void printGameResults(ArrayList<Player> players) {
        
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
