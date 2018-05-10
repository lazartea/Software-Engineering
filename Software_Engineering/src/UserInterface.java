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
    * Sets the piece used for each player based on user input
    * @return int representing a piece
    */
    public int getPiece(int i);
    
    /**
     * Gets the selected option for each player's turn
     * @return 
     */
    public int getTurnOption();
    
    /**
     * Gets the user's choice when selected a Pay/Draw card 
     * @return 
     */
    public int getPayDraw();
    
}
