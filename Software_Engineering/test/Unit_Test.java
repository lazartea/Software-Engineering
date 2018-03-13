

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;



public class Unit_Test {
    
    public Unit_Test() {
    }

    
    //Test for correct starting cash
    @Test
    public void testStartingCash()
    {
        Player player =  new Player(); //Extra parameters to be added when                                           
        assertEquals(player.getPlayerCash().getCash(), 1500); //class  has been fully created
    }
    
    
    //Testing changing the players cash amounts
    @Test
    public void testChangePlayerCash()
    {
        Player player = new Player();
        player.getPlayerCash().subtractCash(200);
        assertEquals(player.getPlayerCash().getCash(), 1300);
        player.getPlayerCash().addCash(400);
        assertEquals(player.getPlayerCash().getCash(), 1700);
    }
    
    //Banker starting cash 50000 (to be changed)
    @Test
    public void testBankerCash()
    {
        Banker banker = new Banker();
        assertEquals(banker.getBankerCash().getCash(), 50000);
    }
    
    @Test
    public void testChangeBankerCash()
    {
        Banker banker = new Banker();
        banker.getBankerCash().subtractCash(2000);
        assertEquals(banker.getBankerCash().getCash(), 48000);
        banker.getBankerCash().addCash(6000);
        assertEquals(banker.getBankerCash().getCash(), 54000);
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
    
    @Test
    public void testDieRandom()
    {
        Die dice = new Die();
        for(int i = 0; i < 20; i++) //loop 20 times, ensure results are only between
        {                           //2 and 12 on each loop (20 loops to limit compilation time,
            int x = dice.getRoll(); //and should be enough to almost always give an error if there
            assertTrue(x > 1);      //is an error with the function
            assertTrue(x < 13);
        }
    }
    
    @Test
    public void testAddHouse()
    {
        Property property = new Property();
        property.addHouse();
        assertEquals(property.getHouseCount(), 1);
        property.addHouse();
        assertEquals(property.getHouseCount(), 2);
        property.addHouse();
        assertEquals(property.getHouseCount(), 3);
        property.addHouse();
        assertEquals(property.getHouseCount(), 4);
        property.addHouse();
        assertEquals(property.getHouseCount(), 4);
        
    }
    @Test
    public void testPotLuck()
    {
        Pot_Luck potluck = new Pot_Luck();
        assertEquals("You inherit £100", potluck.checkCard());       
    }
    
}
