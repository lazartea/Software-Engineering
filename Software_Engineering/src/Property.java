
public class Property {
    
    private boolean isOwned;
    private int hasHouse;
    private int hasHotel;
    
    public Property()
    {
        this.isOwned = false;
        this.hasHouse = 0;
        this.hasHotel = 0;
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
    
    public void addHotel()
    {
        //Check to ensure no more than 1 hotel can be added
        if(hasHotel < 0 && hasHouse == 4)
        {
            hasHotel += 1;
        }
    }
    
    
    
}
