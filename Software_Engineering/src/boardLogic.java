
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
    public void movePlayer(Player player)
    {
        int i = 0;
        Die die = new Die();
        do{                     
            for(int j = 1; j <= die.getRoll(); j++)
            {
                if(die.isDouble())
                {
                    i++;
                }
                //Wraps position and pass go
                if(player.boardPosition() == board.getBoard().size())
                {
                    player.wrapPosition();
                    player.passGo();
                }
                if(i < 3)
                {                   
                    player.movePosition(1);
                }
                //Set jailed if 3 doubles are rolled
                else
                {
                    player.setJailed();
                    break;
                }
            }         
        }while(i < 3 && die.isDouble());             
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

