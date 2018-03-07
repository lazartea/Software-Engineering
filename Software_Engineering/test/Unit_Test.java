

import org.junit.Test;
import static org.junit.Assert.*;


public class Unit_Test {
    
    public Unit_Test() {
    }

    
    //Test for correct starting cash
    @Test
    public void testStartingCash()
    {
        Player player =  new Player(1500); //Extra parameters to be added when 
                                           //class  has been fully created
        AssertEquals(player.getCash(), 1500); 
    }
    
    
    //Testing changing the players cash amounts (can be refactored to 1 method)
    @Test
    public void testChangingCash()
    {
        Player player = new Player(1500);
        player.subtractCash(200);
        AssertEquals(player.getCash, 1300);
        player.addCash(400);
        AssertEquals(player.getCash, 1700);
    }
    
}
