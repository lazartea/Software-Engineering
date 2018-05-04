
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pot_Luck {
    
    private String str;
    private List<String> potLuck = new ArrayList<String>();
    
    public Pot_Luck()
    {
        try{
            BufferedReader read = new BufferedReader(new FileReader("draw_card/potluck.txt"));
            while((str = read.readLine()) != null){
                potLuck.add(str);
            }
        } catch(Exception e){System.out.println("Cannot Find Potluck File");} 
    }
    
    //DUMMY METHOD, used with a dummy unit test to test the potluck file is being read correctly
    public String checkCard()
    {
        return potLuck.get(0);
    }
    //This can shuffle the cards
    public void shuffleCards()
    {
        Collections.shuffle(potLuck);
    }
}

    
    
   

