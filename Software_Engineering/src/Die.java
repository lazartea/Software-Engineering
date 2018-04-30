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
    //Create 2 random numbers to simulate 2 dice rolls and check whether they
    //are Doubles. (Can be changed to return a list of 2 ints if both values are needed independently)
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
    
    public boolean isDouble()
    {
        return isDouble;
    }
            
        
    
}
