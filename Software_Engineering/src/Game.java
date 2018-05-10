
/**
 *
 * @author amylazarte
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
            playerList.add(p);
            p.setBoardPiece(cl.getPiece(i));
        }

        if (gameAgent) {
                   
        }
        do {
            for (int i = 0; i < playerCount; i++) {
                System.out.println("Player " + (i + 1) + "'s turn.");
                System.out.println("Money available: " + playerList.get(i).getPlayerCash().getCash());
                boolean turn = true;
                while (turn) {
                    Die dice = bl.movePlayer(playerList.get(i));
                    cl.displayLocation(playerList.get(i).boardPosition()+1); //properties start at 1, board position starts at 0
                    System.out.println("You have rolled:" + dice.returnRoll());
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
                                        playerList.get(i).setBoardPosition(c.getPosition()-1);
                                        if (c.getPosition() == 31) {
                                            playerList.get(i).setJailed();
                                        }
                                        break;
                                    case PAY_DRAW:
                                        int payDraw = cl.getPayDraw();
                                        if (payDraw == 1) {
                                            c = opportunityKnocks.drawCard();
                                            //this isn't working yet, since there's no way to recall the loop atm
                                        } else {
                                            playerList.get(i).getPlayerCash().subtractCash(c.getAmount());
                                            board.getFreeParking().addCash(c.getAmount());
                                        }
                                        
                                        break;
                                    case MOVEBACK:
                                        int space = c.getAmount();
                                        playerList.get(i).movePosition(space);
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
                    if (board.getBoard().get(playerList.get(i).boardPosition()).isOwned()
                            && board.getBoard().get(playerList.get(i).boardPosition()).owner() != playerList.get(i)) {

                        int payable = board.getBoard().get(playerList.get(i).boardPosition()).getRent();
                        playerList.get(i).getPlayerCash().subtractCash(payable);
                        board.getBoard().get(playerList.get(i).boardPosition()).owner().getPlayerCash().addCash(payable);
                        System.out.println("This property is already owned, you need to pay £" + payable + " to player "
                                + board.getBoard().get(playerList.get(i).boardPosition()).owner().getID());
                    }

                    while (turn) {
                        int option = cl.getTurnOption();
                        switch (option) {
                            case 1:
                                System.out.println("Ending Turn");
                                turn = false;
                                break;
                            case 2:
                                if (playerList.get(i).doneCycle()) {
                                    bl.buyHouse(playerList.get(i), board.getBoard().get(playerList.get(i).boardPosition()));
                                } else {
                                    System.out.println("You need to complete your first cycle around the board before buying a property!");
                                }
                                break;
                            case 3: 
                                System.out.println(board.printProperties());
                                break;
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

        //call game creation method?
        Game g = new Game(playerCount, gameAgent, gameType);

    }

}
