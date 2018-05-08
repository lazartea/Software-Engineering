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
    private CardType type;
    private int amount;
    private int position;
    private int house;
    private int hotel;
    
    //pay/collect
    public Card(String text, CardType type, int amount) {
        this.text = text;
        this.type = type;
        this.amount = amount;
    }
    
    public Card(String text, CardType type, int house, int hotel) {
        this.text = text;
        this.type = type;
        this.hotel = hotel;
        this.house = house;
    }
    //move player
    public Card(String text, CardType type, String pos) {
        this.text = text;
        this.type = type;
        this.position = Integer.parseInt(pos);
    }
    //get out of jail free, moveback
    public Card(String text, CardType type) {
        this.text = text;
        this.type = type;
    }
    
    public String getText() {
        return this.text;
    }
    
    public CardType getType() {
        return this.type;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public int getHotel() {
        return this.hotel;
    }
    
    public int getHouse() {
        return this.house;
    }
    
}
