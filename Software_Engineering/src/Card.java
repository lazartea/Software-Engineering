/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amylazarte
 */
public class Card {
    private String text;
    private PotLuckType type;
    private int amount;
    private int position;
    
    //pay/collect
    public Card(String text, PotLuckType type, int amount) {
        this.text = text;
        this.type = type;
        this.amount = amount;
    }
    //move player
    public Card(String text, PotLuckType type, String pos) {
        this.text = text;
        this.type = type;
        this.position = Integer.parseInt(pos);
    }
    //get out of jail free 
    public Card(String text, PotLuckType type) {
        this.text = text;
        this.type = type;
    }
    
    public String getText() {
        return this.text;
    }
    
    public PotLuckType getType() {
        return this.type;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
}
