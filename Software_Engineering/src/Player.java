

public class Player {
    
    
    private Cash cash;
    private int tempPiecePicker;
    private boardPiece piece;
    private boolean isJailed;
    
    
    public enum boardPiece
    {
        BOOT, SMARTPHONE, GOBLET, HATSTAND, CAT, SPOON
    }
    
    public Player()
    {
        this.tempPiecePicker = 0;
        this.isJailed = false;
        this.cash = new Cash(1500);
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
    
    public Cash getPlayerCash()
    {
        return cash;
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
