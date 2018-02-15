package marsrover;

/**
 *
 * @author gabs
 */
public class Rover {
    //private Integer directionValue = RoverDirections.N.numDirection;
    
    private Integer posX;
    private Integer posY;
    private RoverDirections direction;

	public Rover(Integer posX, Integer posY, RoverDirections direction) {
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
	}

	public Rover posX(Integer posX) {
		this.posX = posX;
		return this;
	}

	public Integer posX() {
		return posX;
	}

	public Rover posY(Integer posY) {
		this.posY = posY;
		return this;
	}

	public Integer posY() {
		return posY;
	}

	public Rover direction(RoverDirections direction) {
		this.direction = direction;
		return this;
	}

	public RoverDirections direction() {
		return direction;
	}

	public void printRover(Rover rover) {
		System.out.println(this.posX + " " + this.posY + " " + this.direction.getDescription());
	}
}
