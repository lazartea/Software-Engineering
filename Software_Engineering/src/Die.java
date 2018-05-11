//Class for dice
import java.util.Random;

public class Die {
    
    private boolean isDouble;
    private int firstRoll;
    private int secondRoll;
    
    public Die()
    {
        this.isDouble = false;
        this.firstRoll = 0;
        this.secondRoll  = 0;
    }
   /**
    * Creates dice roll and moves player
    * @return representing the dice roll
    */
    public int getRoll()
    {     
        Random firstDie = new Random();
        Random secondDie = new Random();
        firstRoll =  firstDie.nextInt(6) + 1;
        secondRoll =  secondDie.nextInt(6) + 1;
        if(firstRoll == secondRoll)
        {
            this.isDouble = true;
        }   
        return firstRoll + secondRoll;
    }
    
    public int returnRoll()
    {
        return firstRoll + secondRoll;
    }
    
    public boolean isDouble()
    {
        return isDouble;
    }
            
        
    
}
