//Class for dice
import java.util.Random;

public class Die {
    
    public int getRoll()
    {
        //Creating a random number between 2 and 12. The dice rolls can be
        //Individually generated later by the GUI. IE, getRoll() returns 7,
        //At the GUI stage 2 dice can be generated to display either 1 + 6, 2 + 5
        //or 3 + 4.     
        Random dice = new Random();
        return 2 + dice.nextInt(11);
                              
    }
    
}
