
package marsrover;

/**
 *
 * @author gabs
 */
public enum Commands {
    MOVE("M"), LEFT("L"), RIGHT("R");

    private String description;

    Commands(String description) {
	this.description = description;
    }

    public String getDescription() {
    	return description.toUpperCase();
    }
}
