

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

/**
 *
 * @author amylazarte
 */
public class Board {
    public List<Property> gameBoard;
    
    
    Board() {
        this.gameBoard = Collections.synchronizedList(new LinkedList<Property>());
        Property_Data data = new Property_Data();
        
        
        List propertySpace;
        for (List item : data.Excel) {
            propertySpace = item;
            int propertyType = propertySpace.size();
            int id;
            String space;
            Property p;
            propertyGroup group;
            int cost;
            switch (propertyType) {
                case 3: //jail
                    id = (int) Double.parseDouble(propertySpace.get(0).toString());
                    space = propertySpace.get(1).toString();
                    p = new Property(id,space);
                    gameBoard.add(p);
                    break;
                case 4: //action
                    id = (int) Double.parseDouble(propertySpace.get(0).toString());
                    space = propertySpace.get(1).toString();
                    propertyAction action = propertyAction.fromString(propertySpace.get(2).toString());
                    p = new Property(id, space, action);
                    gameBoard.add(p);
                    break;
                case 6: //util need to add rules somehow
                    id = (int) Double.parseDouble(propertySpace.get(0).toString());
                    space = propertySpace.get(1).toString();
                    group = propertyGroup.fromString(propertySpace.get(2).toString());
                    cost = (int) Double.parseDouble(propertySpace.get(4).toString());
                    p = new Property(id, space, group, cost);
                    gameBoard.add(p);
                    break;
                case 11: //house 
                    id = (int) Double.parseDouble(propertySpace.get(0).toString());
                    space = propertySpace.get(1).toString();
                    group = propertyGroup.fromString(propertySpace.get(2).toString());
                    cost = (int) Double.parseDouble(propertySpace.get(4).toString());
                    int rent = (int) Double.parseDouble(propertySpace.get(5).toString());
                    int house = (int) Double.parseDouble(propertySpace.get(6).toString());
                    int house2 = (int) Double.parseDouble(propertySpace.get(7).toString());
                    int house3 = (int) Double.parseDouble(propertySpace.get(8).toString());
                    int house4 = (int) Double.parseDouble(propertySpace.get(9).toString());
                    int hotel = (int) Double.parseDouble(propertySpace.get(10).toString());
                    p = new Property(id, space, cost, rent, house, house, house2, house3, house4, hotel, group);
                    gameBoard.add(p);
                    break;
            } 
        }
    }
    
    
}
