
import java.util.ArrayList;


/**
 *
 * @author Harry
 */
public class boardLogic {
    
    private int currentTurn; //This can track for abridged version
    private Board board;
    private int playerCount;
    
    public boardLogic(int playerCount)
    {
        this.board = new Board();
        this.currentTurn =  0;
        this.playerCount = playerCount;
    }
    
    /**
     * Rolls dice, then moves player
     * @param player represents player moving
     * @return dice used to roll
     */
    public Die movePlayer(Player player)
    {
        int i = 0;
        Die die = new Die();
        die.getRoll();
        for(int j = 1; j <= die.returnRoll(); j++)
        {

            if(player.boardPosition() == board.getBoard().size()-1)
            {
                player.wrapPosition();
                player.passGo();
            }
            else
            {
                player.movePosition(1);
            }
        }
        return die;
    }
    /**
     * @param player represents player going to jail
     */            
    public void goToJail(Player player)
    {
        //Set player position to jail square without completing a cycle
        if(player.boardPosition()+1 < 31)
        {
            while(player.boardPosition()+1 < 31)
            {
                player.movePosition(1);
            }
        }
        //decrement if player position is further than jailed
        else if(player.boardPosition()+1 > 31)
        {
            while(player.boardPosition()+1 > 31)
            {
                player.movePosition(-1);
            }
        }       
        player.setJailed();
    }
    /**
     * @param player player buying the house
     * @param property represents a house being bought
     * @return 
     */
    public boolean buyHouse(Player player, Property property)
    {
        if(player.getPlayerCash().getCash() < property.getCost())
        {
            return false;
        }
        else if(property.isOwned())
        {
            return false;
        }
        else
        {
            player.addProperty(property);
            property.buyHouse(player);
            player.getPlayerCash().subtractCash(property.getCost());
            return true;
        }      
    }
}

