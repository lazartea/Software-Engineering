/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amylazarte
 */
public enum propertyAction {
    COLLECT("Collect £200"),
    TAKE("Take card"),
    INCOME("Pay £200"),
    FINES("Collect fines"),
    JAIL("Go to jail"),
    SUPER("Pay £100");
    
    private final String name;
    
    propertyAction(String s){
        this.name = s;
    }
    
    public String getname() {
    return this.name;
    }

    public static propertyAction fromString(String name) {
        for (propertyAction a : propertyAction.values()) {
      if (a.name.equalsIgnoreCase(name)) {
        return a;
      }
    }
    return null;
    }
}
