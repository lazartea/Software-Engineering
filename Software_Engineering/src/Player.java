

public class Player {
    
    
    private int playerCash;
    private int tempPiecePicker;
    boardPiece piece;
    boolean isJailed;
    
    public enum boardPiece
    {
        BOOT, SMARTPHONE, GOBLET, HATSTAND, CAT, SPOON
    }
    
    public Player()
    {
        this.playerCash = 1500;
        this.tempPiecePicker = 0;
        this.isJailed = false;
    }
    
    public int getCash()
    {
        return playerCash;
    }
    
    public void changePlayerCash(int changeBy)
    {
        playerCash += changeBy;
        if(playerCash <= 0)
        {
            //Check if player can sell assets, otherwise player loses.
        }
    }

    //Method assigns static pieces currently, with the intent to later allow
    //Each user to select which piece they want to use.
    public void setBoardPiece()
    {
        switch(tempPiecePicker)
        {
            case 0: this.piece = boardPiece.BOOT;
                    break;
                    
            case 1: this.piece = boardPiece.SMARTPHONE;
                    break;
                    
            case 2: this.piece = boardPiece.GOBLET;
                    break;
                    
            case 3: this.piece = boardPiece.HATSTAND;
                    break;
                  
            case 4: this.piece = boardPiece.CAT;
                    break;
                   
            case 5: this.piece = boardPiece.SPOON;
                    break;                              
        }
        tempPiecePicker++;
    }
    
    public boolean isJailed()
    {
        return isJailed;
    }
    
    
    //Changes status from true to false, or vice-versa
    public void changeJailedStatus()
    {
        if(isJailed == true)
        {
            isJailed = false;
        }
        else
        {
            isJailed = true;
        }
    }
        
    
}
