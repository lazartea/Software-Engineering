
public class Banker {
    
    private Cash cash;
    
    public Banker()
    {
        this.cash = new Cash(50000);
    }
    
    public Cash getBankerCash()
    {
        return cash;
    }
}
