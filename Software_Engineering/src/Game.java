
/**
 *
 * @author amylazarte
 * @author harry
 */

import java.util.List;
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
        Pot_Luck potluck = new Pot_Luck();
        OpportunityKnocks opportunityKnocks = new OpportunityKnocks();
        CommandLineInterface cl = new CommandLineInterface();
        ArrayList<Player> playerList = new ArrayList<Player>();
        boardLogic bl = new boardLogic(playerCount);
        Board board = new Board();
        boolean continueGame = true;

        for (int i = 0; i < playerCount; i++) {
            Player p = new Player();
            p.setId(i+1);
            p.setGameAgent(false);
            playerList.add(p);
            p.setBoardPiece(cl.getPiece(i));
        }

        if (gameAgent) {
            Player p = new Player();
            p.setGameAgent(true);
            p.setId(playerCount+1);
            playerList.add(p);
            playerCount++;
        }
        
        do
            for(int i  = 0; i < playerCount; i++)
            {if (playerList.get(i).getIsPlaying()) { //bankrupted players don't play
                if (playerList.get(i).getGameAgent()) {
                     System.out.println("\n\nGame Agent's turn");
                } else {
                    System.out.println("\n\nPlayer " + (i+1) + "'s turn.");
                }
                System.out.println("Money available: " + playerList.get(i).getPlayerCash().getCash());
                boolean turn = true;
                boolean reroll = true;
                while(turn)
                {
                    Die die = bl.movePlayer(playerList.get(i));
                    System.out.println("You have rolled:" + die.returnRoll());
                    if(die.isDouble())
                    {
                        System.out.println("Double Roll!");
                    }
                    cl.displayLocation(playerList.get(i).boardPosition()+1); //properties start at 1, board position starts at 0
                    System.out.println("\n");
                    Property currentPosition = board.getBoard().get(playerList.get(i).boardPosition());
                    if (currentPosition.getAction() != null) {
                        switch (currentPosition.getAction()) {
                            case TAKE:
                                Card c;
                                if ((currentPosition.getId() == 3) || (currentPosition.getId() == 18) || (currentPosition.getId() == 34)) { //potLuck
                                    c = potluck.drawCard();
                                } else { //opportunity knocks
                                    c = opportunityKnocks.drawCard();
                                }
                                System.out.println(c.getText());
                                switch (c.getType()) {
                                    case FREE:
                                        playerList.get(i).setGetOut(true);
                                        break;
                                    case COLLECT:
                                        playerList.get(i).getPlayerCash().addCash(c.getAmount());
                                        break;
                                    case COLLECTFROM:
                                        int size = playerList.size();
                                        int total = c.getAmount() * size;
                                        playerList.get(i).getPlayerCash().addCash(total);

                                        for (Player p : playerList) {
                                            if (p != playerList.get(i)) {
                                                p.getPlayerCash().subtractCash(c.getAmount());
                                            }
                                        }
                                        break;
                                    case PAY:
                                        playerList.get(i).getPlayerCash().subtractCash(c.getAmount());
                                        board.getFreeParking().addCash(c.getAmount());
                                        break;
                                    case MOVE:
                                        if (c.getPosition() == 31) {
                                            bl.goToJail(playerList.get(i));
                                        } else {
                                            playerList.get(i).setBoardPosition(c.getPosition()-1);
                                        }
                                        cl.displayLocation(playerList.get(i).boardPosition()+1);
                                        break;
                                    case PAY_DRAW:
                                        if (playerList.get(i).getGameAgent()) {
                                            playerList.get(i).getPlayerCash().subtractCash(c.getAmount());
                                            board.getFreeParking().addCash(c.getAmount());
                                        } else {
                                            int payDraw = cl.getPayDraw();
                                            if (payDraw == 1) {
                                                c = opportunityKnocks.drawCard();
                                                //this isn't working yet, since there's no way to recall the loop atm
                                            } else {
                                                playerList.get(i).getPlayerCash().subtractCash(c.getAmount());
                                                board.getFreeParking().addCash(c.getAmount());
                                            }
                                        }
                                        break;
                                    case MOVEBACK:
                                        int space = c.getAmount();
                                        playerList.get(i).movePosition(space);
                                        cl.displayLocation(playerList.get(i).boardPosition()+1);
                                        break;
                                    case PAYPER:
                                        int hotelCount = 0;
                                        int houseCount = 0;
                                        int hotelAmount = c.getHotel();
                                        int houseAmount = c.getHouse();
                                        for (Property p : playerList.get(i).getProperties()) {
                                            houseCount += p.getHouseCount();
                                            hotelCount += p.getHotelCount();
                                        }
                                        int totalpay = (hotelCount * hotelAmount) + (houseCount * houseAmount);
                                        playerList.get(i).getPlayerCash().subtractCash(totalpay);
                                        board.getFreeParking().addCash(totalpay);
                                        break;
                                }
                                break;
                            case INCOME:
                                playerList.get(i).getPlayerCash().subtractCash(200);
                                board.getFreeParking().addCash(200);
                                System.out.println("Income Tax! You pay £200.");
                                break;
                            case SUPER:
                                playerList.get(i).getPlayerCash().subtractCash(100);
                                playerList.get(i).getPlayerCash().subtractCash(100);
                                System.out.println("Super Tax! You pay £100.");
                                break;
                            case FINES:
                                playerList.get(i).getPlayerCash().addCash(board.getFreeParking().getCash());
                                System.out.println("You've landed on free parking! You collect " + board.getFreeParking().getCash() + " in fines.");
                                board.getFreeParking().subtractCash(board.getFreeParking().getCash());
                                break;
                            default:
                                break;
                        }
                    }
                    //Checks the board position and pays rent if owned by another player
                    if (board.getBoard().get(playerList.get(i).boardPosition()+1).isOwned()
                            && board.getBoard().get(playerList.get(i).boardPosition()+1).owner() != playerList.get(i)) {
                        int payable = board.getBoard().get(playerList.get(i).boardPosition()+1).getRent();
                        int amountPaid = 0;
                        System.out.println("This property is already owned, you need to pay £" + payable + " to player "
                                + board.getBoard().get(playerList.get(i).boardPosition()+1).owner().getID());
                        //Check player cash
                        if (playerList.get(i).getPlayerCash().getCash() > payable) {
                            playerList.get(i).getPlayerCash().subtractCash(payable);
                            amountPaid = payable;
                        } else {
                            while (playerList.get(i).getPlayerCash().getCash() < payable) {
                                if (playerList.get(i).getProperties().size() > 1) {
                                    Property p = playerList.get(i).getProperties().get(0);
                                    playerList.get(i).removeProperty(p);
                                    playerList.get(i).getPlayerCash().addCash(p.getCost());
                                    amountPaid+=p.getCost();
                                    System.out.println("Selling " + p.getGroup()+" #" + p.getId() + "to pay rent.");
                                } else {
                                    System.out.println("You have been bankrupted! You lose!");
                                    playerList.get(i).lostGame();
                                    turn = false;
                                }
                            }
                        }
                        System.out.println("Player "+ board.getBoard().get(playerList.get(i).boardPosition()+1).owner().getID()+ "receives £" + amountPaid);
                        board.getBoard().get(playerList.get(i).boardPosition()+1).owner().getPlayerCash().addCash(amountPaid);

                        
                    }
                    if (playerList.get(i).getGameAgent()) {
                        if ((board.getBoard().get(playerList.get(i).boardPosition()+1).getGroup() != null) && (playerList.get(i).doneCycle())) {
                            bl.buyHouse(playerList.get(i), board.getBoard().get(playerList.get(i).boardPosition()+1));
                            System.out.println("Game agent buys property.");
                            System.out.println("Game Agent ends turn.");
                            turn = false;
                        } else {
                            turn = false;
                            System.out.println("Game Agent ends turn.");
                        }
                    }
                    //Choose a turn option
                    while (turn) {
                        int option = cl.getTurnOption();
                        switch (option) {
                            case 1:
                                System.out.println("Ending Turn");
                                turn = false;
                                break;
                            case 2:
                                if (playerList.get(i).doneCycle()) {
                                    bl.buyHouse(playerList.get(i), board.getBoard().get(playerList.get(i).boardPosition()+1));
                                } else {
                                    System.out.println("You need to complete your first cycle around the board before buying a property!");
                                }
                                break;
                            case 3: 
                                System.out.println(board.printProperties());
                                break;
                            case 4:
                                {
                                   if(die.isDouble())
                                   {
                                       option = 1;
                                   }
                                   else
                                   {
                                       System.out.println("You can only roll again if you have doubles");
                                   }
                                }
                                break;
                            case 5: playerList.get(i).lostGame();
                                    turn = false;
                                    System.out.println("You have quit the game.");
                                    break;
                        }
                    }
                    //Creates bidding process
                    if(board.getBoard().get(playerList.get(i).boardPosition()+1).isOwned() == false && playerList.get(i).doneCycle() &&
                            playerList.size() > 2 && board.getBoard().get(playerList.get(i).boardPosition()+1).getRent() > 0)
                    {
                        ArrayList<Player> bidList = new ArrayList<Player>();
                        int bid = 0;
                        int temp = 0;
                        int previousBid = 0;
                        Player currentWinner = null;
                        do
                        for(int j = 0; j < playerList.size(); j++)
                        {
                            if(playerList.get(j).equals(playerList.get(i)))
                            {
                                //do nothing if current player
                            }
                            else if (playerList.get(j).getGameAgent()) {
                                //do nothing if game agent
                            }
                            else
                            {
                                System.out.println("\nPlayer " + (j+1) + " Please enter your bid, or 0 if you do not want to bid.");                                
                                bid = cl.getBid();
                                previousBid = temp;
                                //Creates statements for bidding, ensuring the highest bid is kept only
                                if(bid == 0)
                                {
                                    System.out.println("Passing to next player");
                                    bidList.remove(playerList.get(j));
                                }
                                else if(bid <= previousBid)
                                {
                                    System.out.println("Bid to low, passing to next player");
                                    bidList.remove(playerList.get(j));
                                    board.getBoard().get(playerList.get(i).boardPosition()+1).setCost(bid);
                                }
                                else
                                {
                                    System.out.println("New Highest Bid!");
                                    if(bidList.contains(playerList.get(j)) == false)
                                    {
                                        bidList.add(playerList.get(j));
                                    }
                                    board.getBoard().get(playerList.get(i).boardPosition()+1).setCost(bid);
                                    currentWinner = playerList.get(j);
                                }
                                temp = bid;
                            }
                        }
                        while(bidList.size() > 1);
                        //if bidlist is size 1, that player buys the pieces, otherwise no one bidded
                        if(bidList.size() > 0)
                        {
                            bl.buyHouse(currentWinner, board.getBoard().get(playerList.get(i).boardPosition()+1));
                        }
                        else
                        {
                            System.out.println("No one wants the house, passing!");
                        }
                    }
                    //Checking for doubles, replay turn if double unless for the third time, then go to jail
                    if(die.isDouble())
                    {
                        int j = 0;                      
                        if(j >= 3)
                        {
                            System.out.println("3 Doubles in a row, Go to jail!");
                            bl.goToJail(playerList.get(i));
                            turn = false;
                        }
                        else
                        {    
                            turn  = true;
                        }                      
                    }
                    int lostPlayers = 0;
                    
                    for (Player p: playerList) {
                        if (!p.getIsPlaying()) {
                          lostPlayers++;  
                        }
                    }
                    if (lostPlayers == playerList.size()-1) {
                        continueGame = false;
                        for (Player p: playerList) { 
                            if (p.getIsPlaying()) {
                                Player winner = p;
                                System.out.println("All players have bankrupted! The winner is player " + winner.getID());
                            }   
                        }
                        
                    }
                }
            }
        } while (continueGame);
    }
    /*
    * Main method: calls cli to grab game set up data, creates game
     */
    public static void main(String[] args) {
        int playerCount;
        boolean gameAgent, gameType;
        CommandLineInterface cl = new CommandLineInterface();

        playerCount = cl.getPlayerNumber();

        if (playerCount != 5) {
            gameAgent = cl.getGameAgent();
        } else {
            gameAgent = false;
        }

        gameType = cl.getFull();

        Game g = new Game(playerCount, gameAgent, gameType);

    }

}
