
public class Banker {
    
    private int bankerCash;
    
    public Banker()
    {
        this.bankerCash = 50000;
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
