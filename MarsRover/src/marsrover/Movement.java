package marsrover;

/**
 *
 * @author gabs
 */
public class Movement {

    public Rover executeMovement(Rover rover, String direction) {
	for (int i = 0; i < direction.length(); i++) {
            rover = process(rover,direction.toUpperCase().charAt(i)); //reads each character of the command 
	}
	return rover;
    }

    private Rover process(Rover rover, Character character) {
        
        if (character.toString().equals(Commands.LEFT.getDescription())) {
            rover = turnLeft(rover);
        } else if (character.toString().equals(Commands.RIGHT.getDescription())) {
            rover = turnRight(rover);
        } else if (character.toString().equals(Commands.MOVE.getDescription())) {
            rover = move(rover);
        } else {
            throw new IllegalArgumentException("Command Invalid");
        }
		
        return rover;
    }

    private Rover move(Rover rover) {
        
        if (rover.direction() == RoverDirections.N) {  //if the Rover is facing North, increment Y
            rover.posY( rover.posY() + 1);
        } else if (rover.direction() == RoverDirections.E) { //if the Rover is facing East, increment X
            rover.posX( rover.posX() + 1);
        } else if (rover.direction() == RoverDirections.S) { //if the Rover is facing South, decrement Y
            rover.posY( rover.posY() - 1 );
        } else if (rover.direction() == RoverDirections.W) { //if the Rover is facing West, decrement Y
            rover.posX( rover.posX() - 1 );
        }
            return rover;
    }

    private Rover turnRight(Rover rover) {
    	Integer value = (rover.direction().getValue() + 1) > RoverDirections.W.getValue() ? RoverDirections.N.getValue() : rover.direction().getValue() + 1 ;
        //Verifies if the rover is facing West(value>4), if it is we turn the rover to North.
        rover.direction(RoverDirections.getDirection(value));
	return rover;
    }

    private Rover turnLeft(Rover rover) {
	Integer value = (rover.direction().getValue() - 1) < RoverDirections.N.getValue() ? RoverDirections.W.getValue() : rover.direction().getValue() - 1 ;
	//Verifies if the rover is facing North(value<1), if it is we turn the rover to West.
        rover.direction(RoverDirections.getDirection(value));
	return rover;
    }    
}
