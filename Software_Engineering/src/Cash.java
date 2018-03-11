
public class Cash {

    private int cash;
    
    public Cash(int setCash)
    {
        this.cash = setCash;
    }
    
    public void addCash(int cash)
    {
        this.cash += cash;
    }
    
    public void subtractCash(int cash)
    {
        this.cash -= cash;
    }
    
    public int getCash()
    {
        return cash;
    }
    
    
    
}
