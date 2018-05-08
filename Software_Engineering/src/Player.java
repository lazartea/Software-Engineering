
import java.util.ArrayList;



public class Player {
        
    private Cash cash;
    private int tempPiecePicker;
    private boardPiece piece;
    private Jailed jailStatus;
    private int boardPosition;
    private boolean firstCycle;  //Checks for whether first cycle has been completed
    private ArrayList<Property> properties;
    
    public enum boardPiece
    {
        BOOT, SMARTPHONE, GOBLET, HATSTAND, CAT, SPOON
    }
    
    public Player()
    {
        this.jailStatus = new Jailed();
        this.cash = new Cash(1500);
        this.properties = new ArrayList<Property>();
    }
    
    //Method assigns static pieces currently, with the intent to later allow
    //Each user to select which piece they want to use.
    public void setBoardPiece(int i)
    {
        switch(i)
        {
            case 0: this.piece = boardPiece.BOOT;
                    break;
                    
            case 1: this.piece = boardPiece.SMARTPHONE;
                    break;
                    
            case 2: this.piece = boardPiece.GOBLET;
                    break;
                    
            case 3: this.piece = boardPiece.HATSTAND;
                    break;
                  
            case 4: this.piece = boardPiece.CAT;
                    break;
                   
            case 5: this.piece = boardPiece.SPOON;
                    break;                              
        }
        tempPiecePicker++;
    }
    public Jailed getJailed()
    {
        return this.jailStatus;
    }
    public void setJailed()
    {
        jailStatus.changeJailed();
    }
    public Cash getPlayerCash()
    {
        return this.cash;
    }
    
    public int boardPosition()
    {
        return boardPosition;
    }
    
    public void movePosition(int a)
    {
        this.boardPosition += a;
    }
    public void wrapPosition()
    {
        this.boardPosition = 0;
    }   
    public void passGo()
    {
        this.cash.addCash(200);
        firstCycle = true;     
    }   
    public boolean doneCycle()
    {
        return firstCycle;
    }
    
    public void addProperty(Property property)
    {
        properties.add(property);
    }
    
    public void removeProperty(Property property)
    {
        properties.remove(property);
    }

}
