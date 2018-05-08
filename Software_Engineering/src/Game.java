/**
 *
 * @author amylazarte
 */
import java.util.ArrayList;
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
        ArrayList<Player> playerList = new ArrayList<Player>();
        boardLogic bl = new boardLogic(playerCount);
        Board board = new Board();
        boolean continueGame = true;
        
        for (int i = 0; i < playerCount; i++) {
            Player p = new Player();
            playerList.add(p);
            p.setBoardPiece(cl.getPiece(i));           
        }
        
        if (gameAgent) {
            //create gameAgent, assign piece randomly 
        }
        do
            for(int i  = 0; i < playerCount; i++)
            {
                System.out.println("Player " + (i+1) + "'s turn.");
                System.out.println("Money available: " + playerList.get(i).getPlayerCash().getCash());
                boolean turn = true;
                while(turn)
                {
                   bl.movePlayer(playerList.get(i));
                   cl.displayLocation(playerList.get(i).boardPosition());
                   //Checks the board position and pays rent if owned by another player
                   if(board.getBoard().get(playerList.get(i).boardPosition()).isOwned()
                           && board.getBoard().get(playerList.get(i).boardPosition()).owner() != playerList.get(i))
                   {

                       int payable = board.getBoard().get(playerList.get(i).boardPosition()).getRent();
                       playerList.get(i).getPlayerCash().subtractCash(payable);
                       board.getBoard().get(playerList.get(i).boardPosition()).owner().getPlayerCash().addCash(payable);
                       System.out.println("This property is already owned, you need to pay £" + payable + " to player " 
                               + board.getBoard().get(playerList.get(i).boardPosition()).owner().getID());
                   }
                   int option = 0;
                   while(option != 1)
                   {                      
                        System.out.println("1:End Turn  2:Buy property"); //More to be added
                        Scanner scanner = new Scanner(System.in);
                        option = scanner.nextInt();                  
                        switch(option)
                        {
                            case 1:
                                System.out.println("Ending Turn");
                                turn = false;
                            case 2:
                                if(playerList.get(i).doneCycle())
                                {
                                   bl.buyHouse(playerList.get(i), board.getBoard().get(playerList.get(i).boardPosition())); 
                                }
                                else
                                {
                                    System.out.println("You need to complete your first cycle around the board before buying a property!");
                                }
                        }
                   }
                }            
            }
        while(continueGame);
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

