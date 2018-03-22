

public class Player {
        
    private Cash cash;
    private int tempPiecePicker;
    private boardPiece piece;
    private Jailed jailStatus;
    
    public enum boardPiece
    {
        BOOT, SMARTPHONE, GOBLET, HATSTAND, CAT, SPOON
    }
    
    public Player()
    {
        this.tempPiecePicker = 0;
        this.jailStatus = new Jailed();
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
    public Jailed getJailed()
    {
        return this.jailStatus;
    }
    public Cash getPlayerCash()
    {
        return this.cash;
    }

}
