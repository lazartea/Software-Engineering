
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Pot_Luck {
    
    private String str;
    private List<String> potLuck = new ArrayList<>();
    private List<Card> allCards = new ArrayList<>();
    private Queue<Card> currentDeck = new LinkedList<>();
    
    public Pot_Luck()
    {
        try{
            BufferedReader read = new BufferedReader(new FileReader("draw_card/potluck.txt"));
            while((str = read.readLine()) != null){
                potLuck.add(str);
            }
        } catch(Exception e){System.out.println("Cannot Find Potluck File");} 
        
        for (String s: potLuck) {
            String[] splitString = s.split("; ");
            String text = splitString[0];
            PotLuckType p = PotLuckType.COLLECT; //initialize
            int value;
            String position;
            Card c;
            
            switch (splitString[1]) {
                case "COLLECT": p = PotLuckType.COLLECT;
                    value = Integer.parseInt(splitString[2]);
                    c = new Card(text, p, value);
                    allCards.add(c);
                    break;
                case "COLLECTFROM": p = PotLuckType.COLLECTFROM;
                    value = Integer.parseInt(splitString[2]);
                    c = new Card(text, p, value);
                    allCards.add(c);
                    break;
                case "PAY": p = PotLuckType.PAY;
                    value = Integer.parseInt(splitString[2]);
                    c = new Card(text, p, value);
                    allCards.add(c);
                    break;
                case "PAY_DRAW": p = PotLuckType.PAY_DRAW;
                    value = Integer.parseInt(splitString[2]);
                    c = new Card(text, p, value);
                    allCards.add(c);
                    break;
                case "FREE": p = PotLuckType.FREE;
                    c = new Card(text, p);
                    allCards.add(c);
                    break;
                case "MOVE": p = PotLuckType.MOVE;
                    position = splitString[2];
                    c = new Card(text, p, position);
                    allCards.add(c);
                    break;
            }
            
        }
        //once the cardlist has been generated, create the shuffled deck for the current game
        shuffleCards();
    }
    
    //DUMMY METHOD, used with a dummy unit test to test the potluck file is being read correctly
    public String checkCard(int i)
    {
        return allCards.get(i).getText();
    }
    
    //This can shuffle the cards
    private void shuffleCards()
    {
        List<Card> tempList = new ArrayList<>();
        
        for (Card c: allCards) {
            tempList.add(c);
        }
        
        Collections.shuffle(tempList);
        
        for (Card c: tempList) {
            currentDeck.add(c);
        }
    }
    
    public Card drawCard() {
        Card c = currentDeck.remove();
        currentDeck.add(c); //add to bottom of deck
        return c;
    }
}

    
    
   

