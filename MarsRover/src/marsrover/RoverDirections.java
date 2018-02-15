
package marsrover;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gabs
 */
//Best way to put values into a String 
public enum RoverDirections {        
    N("N",1), E("E",2), S("S",3), W("W",4);

    private String description;
    private Integer value;
    private static final Map<Integer, RoverDirections> lookup = new HashMap<Integer, RoverDirections>();

    static {
	for (RoverDirections d : EnumSet.allOf(RoverDirections.class))
		lookup.put(d.getValue(), d);
    }

    RoverDirections(String description, Integer value) {
	this.description = description;
	this.value = value;
    }

    public String getDescription() {
	return description.toUpperCase();
    }

    public Integer getValue() {
    	return value;
    }

    public static RoverDirections getDirection(int code) {
	return lookup.get(code);
    }

}
