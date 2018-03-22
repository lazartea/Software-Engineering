
public class Jailed {
    
    private Boolean isJailed;
    private int turnsJailed;
    
    public Jailed()
    {
        this.isJailed = false;
        this.turnsJailed = 0;
    }
    
    public boolean isJailed()
    {
        return isJailed;
    }
    
    //Toggles jailed status without need 2 methods
    public void changeJailed()
    {
        if(this.isJailed() == true)
        {
            isJailed = false;
        }
        else
        {
            isJailed = true;
            turnsJailed = 0;   
        }  
    }
    
    public void addTurn()
    {
        turnsJailed++;
    }
    
}
