
public class Cash {

    private int cash;
    
    public Cash(int setCash)
    {
        this.cash = setCash;
    }
    
    private void addCash(int cash)
    {
        this.cash += cash;
    }
    
    private void subractCash(int cash)
    {
        this.cash -= cash;
    }
    
    private int getCash()
    {
        return cash;
    }
    
    
    
}
