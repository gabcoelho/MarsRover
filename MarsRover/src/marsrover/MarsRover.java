package marsrover;

import java.util.Scanner;

/**
 *
 * @author gabs
 */
public class MarsRover {
  
    public static void main(String[] args) {
        
        Movement movement = new Movement();
	String continueW = "";
        int x = 0;
        int y = 0;
        String orientation = "";
        System.out.println("Enter the maximum coordinate of X and Y:");
        Scanner readCoordinatesXY = new Scanner(System.in);
	String maxCoordinateXY = readCoordinatesXY.nextLine();
        do {
            System.out.println("Enter X position of the Rover: ");
            Scanner readX = new Scanner(System.in);
            x = readX.nextInt();
            
            System.out.println("Enter Y position of the Rover: ");
            Scanner readY = new Scanner(System.in);
            y = readY.nextInt();

            System.out.println("Enter the direction the Rover is facing: ");
            Scanner readOrientation = new Scanner(System.in);
            orientation = readOrientation.nextLine();
            
            Rover rover = new Rover(x, y, RoverDirections.valueOf(orientation));
            
            System.out.println("Where would you like the Rover to move to?  ");
            Scanner readMovimentacao = new Scanner(System.in);
            String movimentacao = readMovimentacao.nextLine();
		
            movement.executeMovement(rover, movimentacao);
            rover.printRover(rover);
            
            System.out.println("New Rover (Y/N) ");
            Scanner readContinue = new Scanner(System.in);
            continueW = readContinue.nextLine();
			
	    } while(continueW.toUpperCase().equals("Y"));   
        
        /*  Rover rover = new Rover(1, 2, RoverDirections.N);
        rover = movement.executeMovement(rover, "LMLMLMLMM");
        rover.printRover(rover);

        rover = new Rover(3, 3, RoverDirections.E);
        rover = movement.executeMovement(rover, "MMRMMRMRRM");
        rover.printRover(rover);
        */
    }
}
