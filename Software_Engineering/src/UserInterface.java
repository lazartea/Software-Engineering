/**
 *
 * @author amylazarte
 */
public interface UserInterface {
    
    /*
    * Displays current player's location on the board 
    * @params int p, current player's location on the board
    */       
    public void displayLocation(int p);
    
    /*
    * Sets the number of players in a game based on user input
    * @return number of players
    */
    public int getPlayerNumber();
    /*
    * Sets whether or not a game agent is used based on user input
    * @return true if a game agent is wanted, false otherwise
    */
    public boolean getGameAgent();
    
    /*
    * Sets whether the game is full or abridged based on user input
    * @return true if game is full, false otherwise
    */
    public boolean getFull();
    
    /*
    * Takes in user input for each turn
    * stub code at the moment
    */
    public void getTurn();
    
    /*
    * Sets the piece used for each player based on user input
    * @return int representing a piece
    */
    public int getPiece(int i);
    
}
