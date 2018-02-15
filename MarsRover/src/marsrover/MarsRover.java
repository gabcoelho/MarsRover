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
        
        do {
            //Captures the initial position of the rover
            System.out.println("Informe o posicionamento de X do rover: ");
            Scanner readX = new Scanner(System.in);
            x = readX.nextInt();
            
            System.out.println("Informe o posicionamento de Y do rover: ");
            Scanner readY = new Scanner(System.in);
            y = readY.nextInt();

            System.out.println("Informe a orientação do rover: ");
            Scanner readOrientation = new Scanner(System.in);
            orientation = readOrientation.nextLine();
            
            Rover rover = new Rover(x, y, RoverDirections.valueOf(orientation));
            
            System.out.println("Informe a movimentação do rover: ");
            //Capture moviment required for the rover 
            Scanner readMovimentacao = new Scanner(System.in);
            String movimentacao = readMovimentacao.nextLine();
		
           // Rover rover1 = new Rover();
            movement.executeMovement(rover, movimentacao);
            rover.printRover(rover);
            
            System.out.println("Cadastrar novo rover (s/n) ");
            Scanner readContinue = new Scanner(System.in);
            continueW = readContinue.nextLine();
			
	} while(continueW.toUpperCase().equals("S"));    
        
        /*  Rover rover = new Rover(1, 2, RoverDirections.NORTH);
        rover = movement.executeMovement(rover, "LMLMLMLMM");
        rover.printRover(rover);

        rover = new Rover(3, 3, RoverDirections.EAST);
        rover = movement.executeMovement(rover, "MMRMMRMRRM");
        rover.printRover(rover);
        */
    }
}
