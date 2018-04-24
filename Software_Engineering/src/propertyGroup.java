/**
 *
 * @author amylazarte
 * enum to represent different groups of property
 */
public enum propertyGroup {
    BROWN("Brown"),
    STATION("Station"),
    BLUE("Blue"),
    PURPLE("Purple"),
    UTILITIES("Utilities"),
    ORANGE("Orange"),
    RED("Red"),
    YELLOW("Yellow"),
    GREEN("Green"),
    DEEP("Deep blue");
    
    private final String name;
    
    propertyGroup(String s){
        this.name = s;
    }
    
    public String getname() {
    return this.name;
    }

    public static propertyGroup fromString(String name) {
        for (propertyGroup g : propertyGroup.values()) {
      if (g.name.equalsIgnoreCase(name)) {
        return g;
      }
    }
    return null;
    }
    
}
