/**
 *
 * @author amylazarte
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    
    /* Game Constructor-- create an instance of the current game
    * @params playerCount, gameAgent, gameType
    *
    */
    private Game(int playerCount, boolean gameAgent, boolean gameType) {
        Board b = new Board();
        CommandLineInterface cl = new CommandLineInterface();
        ArrayList<Player> playerList = new ArrayList<Player>();
        boardLogic bl = new boardLogic(playerCount);
        Board board = new Board();
        
        for (int i = 0; i < playerCount; i++) {
            Player p = new Player();
            playerList.add(p);
            p.setBoardPiece(cl.getPiece(i));           
        }
        
        if (gameAgent) {
            //create gameAgent, assign piece randomly 
        }
        
        for(int i  = 0; i < playerCount; i++)
        {
            System.out.println("Player " + i+1 + "'s turn.");
            boolean turn = true;
            System.out.println(board.getBoard().size());
            while(turn)
            {
               bl.movePlayer(playerList.get(i));
               cl.displayLocation(i);
               System.out.println("1:End Turn  2:Buy property"); //More to be added
               Scanner scanner = new Scanner(System.in);
               int option = scanner.nextInt();
               switch(option)
               {
                   case 1:
                       System.out.println("Ending Turn");
                       turn = false;
                   case 2:
                       bl.buyHouse(playerList.get(i), board.getBoard().get(playerList.get(i).boardPosition()));
               }
            }            
        }
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

