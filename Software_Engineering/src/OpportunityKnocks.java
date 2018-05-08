/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amylazarte
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class OpportunityKnocks {
    private String str;
    private List<String> oppKnocks = new ArrayList<>();
    private List<Card> allCards = new ArrayList<>();
    private Queue<Card> currentDeck = new LinkedList<>();
    
    public OpportunityKnocks() {
        try{
            BufferedReader read = new BufferedReader(new FileReader("draw_card/OpportunityKnocks.txt"));
            while((str = read.readLine()) != null){
                oppKnocks.add(str);
            }
        } catch(Exception e){System.out.println("Cannot Find Opportunity Knocks File");} 
        
        for (String s: oppKnocks) {
            String[] splitString = s.split("; ");
            String text = splitString[0];
            CardType p = CardType.COLLECT; //initialize
            int value;
            String position;
            Card c;
            
            switch (splitString[1]) {
                case "COLLECT": p = CardType.COLLECT;
                    value = Integer.parseInt(splitString[2]);
                    c = new Card(text, p, value);
                    allCards.add(c);
                    break;
                
                case "PAY": p = CardType.PAY;
                    value = Integer.parseInt(splitString[2]);
                    c = new Card(text, p, value);
                    allCards.add(c);
                    break;
                case "FREE": p = CardType.FREE;
                    c = new Card(text, p);
                    allCards.add(c);
                    break;
                case "MOVE": p = CardType.MOVE;
                    position = splitString[2];
                    c = new Card(text, p, position);
                    allCards.add(c);
                    break;
                case "MOVEBACK":
                    int spaces = Integer.parseInt(splitString[2]);
                    c = new Card(text, p, spaces);
                    allCards.add(c);
                    break;
                case "PAYPER":
                    int house = Integer.parseInt(splitString[2]);
                    int hotel = Integer.parseInt(splitString[3]);
                    c = new Card(text, p, house, hotel);
                    break;
            }
            
        }
        //once the cardlist has been generated, create the shuffled deck for the current game
        shuffleCards();
    }
    
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
