

public class Player {
    
    
    private int playerCash;
    
    public Player()
    {
        this.playerCash = 1500;
    }
    
    public int getCash()
    {
        return playerCash;
    }
    
    public void changePlayerCash(int changeBy)
    {
        playerCash += changeBy;
        if(playerCash <= 0)
        {
            //Check if player can sell assets, otherwise player loses.
        }
    }    
}
