/**
 *
 * @author amylazarte
 */
import java.util.Scanner;
class CommandLineInterface implements UserInterface {
    private String printGame = " JL P UT P P S O PL O O FP\n B                       R\n B                      OK\n OK                      R\n B                       R\n S                       S\n T                       Y\n Br                      Y\n PL                      U\n Br                      Y\n Go P T P OK S G PL G G GJ\n";
    
    private void setGame(String s) {
        this.printGame = s;
    }
    
    /*
    * Displays current player's location on the board 
    * @params int p, current player's location on the board
    */ 
    @Override
    public void displayLocation(int i) {
        String[] position = {"                         ","\n"," JL P UT P P S O PL O O FP","\n"," B                       R","\n"," B                      OK","\n"," OK                      R","\n"," B                       R","\n"," S                       S", "\n"," T                       Y", "\n", " Br                      Y", "\n", " PL                      U","\n"," Br                      Y","\n", " Go P T P OK S G PL G G GJ","\n","                         "};
        int index;
        String finalString = "";
        
        if ((i >= 1)&& (i<=11)) {
            index = 24-(i*2);
            position[index] = position[index].replaceFirst(" ", "*");
        }  else if ((i>=21)&&(i<=31)) {
            index = (i - 20)*2;
            position[index] = position[index]+"*";
        } else {
            int a=1 ,b=1, c = 1;
            switch (i) {
                case 12:   
                    a = 4;
                    b = 5;
                    c = 0;
                    break;
                case 13:   
                    a = 6;
                    b = 7;
                    c = 0;
                    break;
                case 14:   
                    a = 9;
                    b = 10;
                    c = 0;
                    break;
                case 15:  
                    a = 11;
                    b = 12;
                    c = 0;
                    break;
                case 16:  
                    a = 13;
                    b = 14;
                    c = 0;
                    break;
                case 17:  
                    a = 15;
                    b = 16;
                    c = 0;
                    break;
                case 18:  
                    a = 17;
                    b = 18;
                    c = 0;
                    break;
                case 19:  
                    a = 20;
                    b = 21;
                    c = 0;
                    break;
                case 20:  
                    a = 22;
                    b = 23;
                    c = 0;
                    break;
                case 32:  
                    b = 23;
                    a = 22;
                    c = 24;
                    break;
                case 33:  
                    b = 21;
                    a = 20;
                    c = 24;
                    break;
                case 34:  
                    b = 19;
                    a = 18;
                    c = 24;
                    break;
                case 35:  
                    b = 16;
                    a = 15;
                    c = 24;
                    break;
                case 36:  
                    b = 14;
                    a = 13;
                    c = 24;
                    break;
                case 37:  
                    b = 12;
                    a = 11;
                    c = 24;
                    break;
                case 38:  
                    b = 9;
                    a = 8;
                    c = 24;
                    break;
                case 39:  
                    b = 7;
                    a = 6;
                    c = 24;
                    break;
                case 40:  
                    b = 5;
                    a = 4;
                    c = 24;
                    break;
            }
        position[c] = position[c].substring(0,a)+"*"+position[c].substring(b);

        }
        for (String s: position) {
            finalString+=s;
        }
        printGame = finalString;   
        System.out.print(printGame);

    }
    /*
    * Sets the number of players in a game based on user input
    * @return number of players
    */
    @Override
    public int getPlayerNumber() {
        int playerCount;
        while (true) {
        try { 
            System.out.println("How many players? 1-5"); //check requirements for allowed number
            Scanner sc = new Scanner(System.in);
            playerCount = sc.nextInt();
            if ((playerCount >= 1) && (5 >= playerCount)) {
                break;
            } else {
                System.out.println("Must be between 1 and 8.");
            }
        } catch (java.util.InputMismatchException e) { 
            System.out.println("Must be between 1 and 8.");
        }
        }
        return playerCount;
    }
    /*
    * Sets whether or not a game agent is used based on user input
    * @return true if a game agent is wanted, false otherwise
    */
    @Override
    public boolean getGameAgent() {
        int gameAgent;
        while (true) {
            try { 
                System.out.println("Do you want to use a game agent? 1: Yes, 2: No");
                Scanner sc = new Scanner(System.in);
                gameAgent = sc.nextInt();
                if ((gameAgent == 1)||(gameAgent == 2)) {
                    break;
                } else {
                    System.out.println("Type 1 for yes or 2 for no.");
                }
            } catch (java.util.InputMismatchException e) { 
                System.out.println("Type 1 for yes or 2 for no.");
            }
            }
        return gameAgent==1;
    }
    /*
    * Sets whether the game is full or abridged based on user input
    * @return true if game is full, false otherwise
    */
    @Override
    public boolean getFull() {
        int gameType;
        while (true) {
        try { 
            System.out.println("Do you want to play a full or abridged game? 1: Full, 2: Abridged");
            Scanner sc = new Scanner(System.in);
            gameType = sc.nextInt();
            if ((gameType == 1)||(gameType == 2)) {
               break; 
            } else {
                System.out.println("Type 1 for full or 2 for abridged.");
            }
                
        } catch (java.util.InputMismatchException e) { 
            System.out.println("Type 1 for full or 2 for abridged.");
        }
        }
        return gameType == 1;
    }
    

    /*
    * Sets the piece used for each player based on user input
    * @return int representing a piece
    */
    @Override
    public int getPiece(int i) {
        int pieceType;
        
        while (true) {
            try {
                System.out.println("Player "+(i+1)+" choose your piece. 1-Boot, 2-Smartphone, 3-Goblet, 4-Hatstand, 5-Cat, 6-Spoon.");
                Scanner sc = new Scanner(System.in);
                pieceType = sc.nextInt(); //we need to add something so that we only allow each piece to be assigned once
                if (pieceType > 6) {
                    break; 
                } else {
                    System.out.println("Type 1-6");
                }
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Type 1-6");
            }
        }
        return pieceType;
    }
    
    @Override 
    public int getTurnOption() {
        System.out.println("1:End Turn  2:Buy property 3:Display Property Data 4:Roll Again"); //More to be added
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                if (option <= 5) {
                    return option;
                } else {
                    System.out.println("Type 1-4");
                }
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Type 1-4");
            }  
        }
    }
    
    @Override
    public int getPayDraw() {
        System.out.println("1: Draw Card 2:Pay Fine");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                if (option < 3) {
                    return option;
                } else {
                    System.out.println("Type 1 or 2");
                }
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Type 1 or 2");
            }  
        }
    }
    
    @Override
    public int getBid()
    {
        System.out.println("Enter bid:");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                return option;
            }catch(java.util.InputMismatchException e){
                System.out.println("Enter a valid number");
            }
        }              
    }    
}
