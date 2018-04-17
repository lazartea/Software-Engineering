import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;


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
        player.getPlayerCash().subtractCash(200);
        assertEquals(player.getPlayerCash(), 1300);
        player.getPlayerCash().addCash(400);
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
        assertEquals(player.getJailed().isJailed(), false);
        player.getJailed().changeJailed();
        assertEquals(player.getJailed().isJailed(), true);
        player.getJailed().changeJailed();
        assertEquals(player.getJailed().isJailed(), false);     
    }
    
    @Test
    public void testDieRandom()
    {
        Die dice = new Die();
        for(int i = 0; i < 20; i++) //loop 20 times, ensure results are only between
        {                           //2 and 12 on each loop
            int x = dice.getRoll();
            assertTrue(x > 1);  
            assertTrue(x < 13);
        }
    }
    
    @Test
    public void testHouse()
    {
        Property property = new Property(2, "Fake Property", 200, 300, 350, 400, 450, 500, 550, 600, propertyGroup.BLUE);
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
    public void testExcel()
    {
        Property_Data data = new Property_Data();
         assertEquals(data.Excel.size(),40);
        List<String> expected = Arrays.asList("1.0", "Go", "Collect £200", "No");
        assertEquals(expected,data.getEntry(0));
        assertEquals(expected.size(),4);
    }
    
    @Test
    public void testBoard() {
        Board b = new Board();
        assertEquals(b.gameBoard.size(),40);
        assertEquals(b.gameBoard.get(0).getId(),1);
        assertEquals(b.gameBoard.get(39).getId(),40);
    }
            
    
}
