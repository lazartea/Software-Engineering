

import org.junit.Test;
import static org.junit.Assert.*;


public class Unit_Test {
    
    public Unit_Test() {
    }

    
    //Test for correct starting cash
    @Test
    public void testStartingCash()
    {
        Player player =  new Player(); //Extra parameters to be added when                                           
        assertEquals(player.getPlayerCash(), 1500); //class  has been fully created
    }
    
    
    //Testing changing the players cash amounts
    @Test
    public void testChangePlayerCash()
    {
        Player player = new Player();
        player.changePlayerCash(-200);
        assertEquals(player.getPlayerCash(), 1300);
        player.changePlayerCash(400);
        assertEquals(player.getPlayerCash(), 1700);
    }
    
    //Banker starting cash 50000 (to be changed)
    @Test
    public void testBankerCash()
    {
        Banker banker = new Banker();
        assertEquals(banker.getBankerCash(), 50000);
    }
    
    @Test
    public void testChangeBankerCash()
    {
        Banker banker = new Banker();
        banker.changeBankerCash(-2000);
        assertEquals(banker.getBankerCash(), 48000);
        banker.changeBankerCash(6000);
        assertEquals(banker.getBankerCash(), 54000);
    }
    
    @Test
    public void testJail()
    {
        Player player = new Player();
        assertEquals(player.isJailed(), false);
        player.changeJailedStatus();
        assertEquals(player.isJailed(), true);
        player.changeJailedStatus();
        assertEquals(player.isJailed(), false);
        
    }
    
}
