/**
 *
 * @author amylazarte
 * enum to represent different "actions" tied to specific properties
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
