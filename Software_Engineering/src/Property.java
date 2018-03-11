
public class Property {
    
    private boolean isOwned;
    private int hasHouse;
    private int hasHotel;
    private int cost;
    private int rentDue;
    private Player buyHouse;
    
    
    public Property()
    {
        this.isOwned = false;
        this.hasHouse = 0;
        this.hasHotel = 0;
        this.rentDue = 0;
        this.cost = 0; //Default values for now
    }
    
    public boolean isOwned()
    {
        return isOwned;
    }
    
    public void addHouse()
    {
        //Check to ensure no more than 4 houses have been bought
        if(hasHouse < 4)
        {
            hasHouse += 1;
        }
    }
    
    public int getHouseCount()
    {
        return hasHouse;
    }
    
    private int getCost()
    {
        return cost;
    }
    
    private int getRent()
    {
        return rentDue;
    }
    
    public void addHotel()
    {
        //Check to ensure no more than 1 hotel can be added
        if(hasHotel < 0)
        {
            hasHotel += 1;
        }
    }
    
    public void buyHouse(Player player)
    {
        this.buyHouse = player;
    }
    
    
    
}
