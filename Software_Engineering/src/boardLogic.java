
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
    
    //Creates a dice roll and moves the player.
    public Die movePlayer(Player player)
    {
        int i = 0;
        Die die = new Die();
        die.getRoll();
        for(int j = 1; j <= die.returnRoll(); j++)
        {

            if(player.boardPosition() == board.getBoard().size() - 1)
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
                
    public void goToJail(Player player)
    {
        //Set player position to jail square without completing a cycle
        if(player.boardPosition() < 31)
        {
            while(player.boardPosition() < 31)
            {
                player.movePosition(1);
            }
        }
        //decrement if player position is further than jailed
        else if(player.boardPosition() > 31)
        {
            while(player.boardPosition() > 31)
            {
                player.movePosition(-1);
            }
        }       
        player.setJailed();
    }
    //Use the boolean return type when outputting, IE (if true  :  "House obtained"
    //if false : "Cannot buy house".
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

