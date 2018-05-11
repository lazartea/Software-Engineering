
import java.util.List;

/*
* This class represents a single property's data. There are separate constructors for different types of properties
*/
public class Property {
    
    private boolean isOwned;
    private int hasHouse;
    private int hasHotel;
    
    private int cost;
    private int rentDue;
    private int house;
    private int house1;
    private int house2;
    private int house3;
    private int house4;
    private int hotel;
    
    private int id;
    private String space;
    
    private propertyAction action;
    private propertyGroup group = null;
    
    private Player buyHouse;

    //houses
    public Property(int id, String space, int cost, int rent, int house, int house1, int house2, int house3, int house4, int hotel, propertyGroup group){
        this.isOwned = false;
        this.hasHouse = 0;
        this.hasHotel = 0;
        
        this.id = id;
        this.space = space;
        this.cost = cost;
        this.rentDue = rent;
        this.house = house;
        this.house1 = house1;
        this.house2 = house2;
        this.house3 = house3;
        this.house4 = house4;
        this.hotel = hotel;
        this.group = group;
    }
    
    //jail
    public Property(int id, String space) {
        this.id = id;
        this.space = space;
        this.action = propertyAction.JAIL;
    }
    //ultilites/stations
    public Property(int id, String space, propertyGroup group, int cost) {

        this.isOwned = false;
        this.id = id;
        this.space = space;
        this.group = group;
        this.cost = cost;
    }
    
    //action spaces
    public Property(int id, String space, propertyAction action) {
        this.id = id;
        this.space = space;
        this.action = action;
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
    
    public int getHotelCount()
    {
        return hasHotel;
    }
    
    public void setOwned(boolean b) {
        this.isOwned = b;
    }
   
    public int getCost()
    {
        return cost;
    }
    
    public int getRent()
    {//this will only work for houses; the ultilites/stations will need special logic
        int rent = rentDue;
        if (hasHotel > 0) {
            rent = hotel;
        } else {
            switch(getHouseCount()) {
                case 1:
                    rent = house1;
                    break;
                case 2:
                    rent = house2;
                    break;
                case 3: 
                    rent = house3;
                    break;
                case 4:
                    rent = house4;
                    break;
            }     
        }
        return rent;
    }
    
    public void addHotel()
    {
        //Check to ensure no more than 1 hotel can be added
        if(hasHotel < 0 && hasHouse == 4)
        {
            hasHotel += 1;
        }
    }
    
    public void buyHouse(Player player)
    {
        this.buyHouse = player;
        this.isOwned = true;
    }
    
    public int getId(){
        return this.id;
    }        
    
    public propertyAction getAction() {
        return this.action;
    }
    
    public propertyGroup getGroup() {
        return this.group;
    }
    
    public Player owner() {
        return buyHouse;
    }
    
    
    public String printData() {
        String returnString;
        if (this.isOwned) {
            if (owner().getGameAgent()) {
                returnString = this.group + " #" + this.id + ": owned by Game Agent, " + getHouseCount() + " Houses, " + getHotelCount() + " Hotels \n";
            } else {
                returnString = this.group + " #" + this.id + ": owned by Player " + owner().getID()+", " + getHouseCount() + " Houses, " + getHotelCount() + " Hotels \n";
            }
        } else {
            returnString = this.group + " #" + this.id + ": unowned";
        }
        return returnString;
    }
}