
public class Banker {
    
    private int bankerCash;
    
    public Banker()
    {
        this.bankerCash = 50000; //Value to be changed
    }
    
    public int getBankerCash()
    {
        return bankerCash;
    }
    
    public void changeBankerCash(int changeBy)
    {
        bankerCash += changeBy;
    }
}
