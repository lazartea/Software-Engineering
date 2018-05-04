/**
 *
 * @author amylazarte
 */
import java.util.List;
import java.util.Scanner;
public class Game {
    
    /* Game Constructor-- create an instance of the current game
    * @params playerCount, gameAgent, gameType
    *
    */
    private Game(int playerCount, boolean gameAgent, boolean gameType) {
        Board b = new Board();
        List<Property> gameBoard = b.getBoard();
        
        CommandLineInterface cl = new CommandLineInterface();
        
        for (int i = 1; i <= playerCount; i++) {
            Player p = new Player();
            p.setBoardPiece(cl.getPiece(i));
           
        }
        
        if (gameAgent) {
            //create gameAgent, assign piece randomly 
        }
        
        
        //do some logic?
    }
    /*
    * Main method: calls cli to grab game set up data, creates game
    */
    public static void main(String [] args) {
        int playerCount;
        boolean gameAgent,gameType;
        CommandLineInterface cl = new CommandLineInterface();
        
        playerCount = cl.getPlayerNumber();
       
        if (playerCount != 5) {
            gameAgent = cl.getGameAgent();
        } else {
            gameAgent = false;
        }     
        
        gameType = cl.getFull();
        
        //call game creation method?
        Game g = new Game(playerCount, gameAgent, gameType);
        
        }
     
    }

