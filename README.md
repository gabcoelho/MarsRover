<h1><a id="Mars_Rover_Problem_0"></a>Mars Rover Problem</h1>
<pre><code>A squad of robotic rovers are to be landed by NASA on a plateau on Mars.     This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth. 
A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North. In order to control a rover , NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading. Assume that the square directly North from (x, y) is (x,y+1).

INPUT: The ﬁrst line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0. The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The ﬁrst line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation. Each rover will be ﬁnished sequentially, which means that the second rover won’t start to move until the ﬁrst one has ﬁnished moving.
OUTPUT: The output for each rover should be its ﬁnal co-ordinates and heading. 
</code></pre>
<p>Test Input: 5 5<br>
1 2 N<br>
LMLMLMLMM<br>
3 3 E<br>
MMRMMRMRRM<br>
Expected Output: 1 3 N<br>
5 1 E</p>
<h1><a id="Tech_16"></a>Tech</h1>
<ul>
<li>Language: Java</li>
<li>Netbeans IDE 8.1</li>
</ul>
<h1><a id="How_to_22"></a>How to</h1>
<p>Open the project in an IDE and run MarsRovers class.</p>
<h1><a id="Implementation_27"></a>Implementation</h1>
<h4><a id="Commands_Class_29"></a>Commands Class</h4>
<p>The Commands Class defines the commands that will be received from the user.</p>
<pre><code class="language-sh">public enum Commands {
    MOVE(<span class="hljs-string">"M"</span>), LEFT(<span class="hljs-string">"L"</span>), RIGHT(<span class="hljs-string">"R"</span>);
    private String description;
    Commands(String description) {
        this.description = description;
    }
    public String <span class="hljs-function"><span class="hljs-title">getDescription</span></span>() {
        <span class="hljs-built_in">return</span> description.toUpperCase();
    }
}
</code></pre>
<h4><a id="Rover_Class_44"></a>Rover Class</h4>
<p>Rover Class that defines the characteristics of a Rover, with its coordinates and directions.</p>
<pre><code class="language-sh">public class Rover {
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
        <span class="hljs-built_in">return</span> this;
    }

    public Integer <span class="hljs-function"><span class="hljs-title">posX</span></span>() {
        <span class="hljs-built_in">return</span> posX;
    }

    public Rover posY(Integer posY) {
        this.posY = posY;
        <span class="hljs-built_in">return</span> this;
    }

    public Integer <span class="hljs-function"><span class="hljs-title">posY</span></span>() {
        <span class="hljs-built_in">return</span> posY;
    }

    public Rover direction(RoverDirections direction) {
        this.direction = direction;
        <span class="hljs-built_in">return</span> this;
    }

    public RoverDirections <span class="hljs-function"><span class="hljs-title">direction</span></span>() {
        <span class="hljs-built_in">return</span> direction;
    }

    public void <span class="hljs-built_in">print</span>Rover(Rover rover) {
        System.out.println(this.posX + <span class="hljs-string">" "</span> + this.posY + <span class="hljs-string">" "</span> + this.direction.getDescription());
    }
}
</code></pre>
<h4><a id="RoverDirections_Class_91"></a>RoverDirections Class</h4>
<p>This class describes the possible directions a Rover can move to.<br>
A Rover can move to 4 possble directions, North, East, South and West. It was used enum variables so that we can distribue values to each direction.<br>
HashMap is used, given that it works with the concept of key-value pairs.</p>
<pre><code class="language-sh">public enum RoverDirections {     

    N(<span class="hljs-string">"N"</span>,<span class="hljs-number">1</span>), E(<span class="hljs-string">"E"</span>,<span class="hljs-number">2</span>), S(<span class="hljs-string">"S"</span>,<span class="hljs-number">3</span>), W(<span class="hljs-string">"W"</span>,<span class="hljs-number">4</span>);
    private String description;
    private Integer value;
    private static final Map&lt;Integer, RoverDirections&gt; lookup = new HashMap&lt;Integer, RoverDirections&gt;();

    static {
        <span class="hljs-keyword">for</span> (RoverDirections d : EnumSet.allOf(RoverDirections.class))
            lookup.put(d.getValue(), d);
    }

    RoverDirections(String description, Integer value){
        this.description = description;
        this.value = value;
    }

    public String <span class="hljs-function"><span class="hljs-title">getDescription</span></span>() {
        <span class="hljs-built_in">return</span> description.toUpperCase();
    }

    public Integer <span class="hljs-function"><span class="hljs-title">getValue</span></span>() {
        <span class="hljs-built_in">return</span> value;
    }
    
    public static RoverDirections getDirection(int code){
        <span class="hljs-built_in">return</span> lookup.get(code);
    }
}
</code></pre>
<h4><a id="Movement_Class_128"></a>Movement Class</h4>
<p>This class calculates which direction a Rover should take, depending on the input of the user. It is composed of:</p>
<ul>
<li>A executeMovement method reads each character of the command given by the user.</li>
<li>A process method that given the command received, the rover calls a method, whether that is turn left, turn right or move, that correspond to the command.</li>
<li>The Move method, given the command, if the rover is facing North, it increments the Y coordinate of the Rover, if it is facing West, it increments X, if is facing South, it decrements Y, and if the Rover is facing West, it decrements X.</li>
<li>A turnRight method, in which we verifie if the rover is facing West(value&gt;4, can’t happpen), if it is we turn the rover to the North, if not, we increment the value of the direction of the Rover.</li>
<li>A turnLeft method, in which we verifie if the rover is facing North(value&lt;1, can’t happpen), if it is we turn the rover to the West, if not, we decrement the value of the direction of the Rover.</li>
</ul>
<pre><code class="language-sh">public class Movement {

    public Rover executeMovement(Rover rover, String direction) {
    <span class="hljs-keyword">for</span> (int i = <span class="hljs-number">0</span>; i &lt; direction.length(); i++) {
            rover = process(rover,direction.toUpperCase().charAt(i)); 
    }
    <span class="hljs-built_in">return</span> rover;
    }

    private Rover process(Rover rover, Character character) {
        <span class="hljs-keyword">if</span> (character.toString().equals(Commands.LEFT.getDescription())) {
            rover = turnLeft(rover);
        } <span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span> (character.toString().equals(Commands.RIGHT.getDescription())) {
            rover = turnRight(rover);
        } <span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span> (character.toString().equals(Commands.MOVE.getDescription())) {
            rover = move(rover);
        } <span class="hljs-keyword">else</span> {
            throw new IllegalArgumentException(<span class="hljs-string">"Command Invalid"</span>);
        }
        <span class="hljs-built_in">return</span> rover;
    }

    private Rover move(Rover rover) {
        
        <span class="hljs-keyword">if</span> (rover.direction() == RoverDirections.N) { 
            rover.posY( rover.posY() + <span class="hljs-number">1</span>);
        } <span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span> (rover.direction() == RoverDirections.E){
            rover.posX( rover.posX() + <span class="hljs-number">1</span>);
        } <span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span> (rover.direction() == RoverDirections.S){
            rover.posY( rover.posY() - <span class="hljs-number">1</span> );
        } <span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span> (rover.direction() == RoverDirections.W){
            rover.posX( rover.posX() - <span class="hljs-number">1</span> );
        }
        <span class="hljs-built_in">return</span> rover;
    }

    private Rover turnRight(Rover rover) {
        Integer value = (rover.direction().getValue() + <span class="hljs-number">1</span>) &gt; RoverDirections.W.getValue() ? RoverDirections.N.getValue() : rover.direction().getValue() + <span class="hljs-number">1</span> ;
        rover.direction(RoverDirections.getDirection(value));
    <span class="hljs-built_in">return</span> rover;
    }

    private Rover turnLeft(Rover rover) {
    Integer value = (rover.direction().getValue() - <span class="hljs-number">1</span>) &lt; RoverDirections.N.getValue() ? RoverDirections.W.getValue() : rover.direction().getValue() - <span class="hljs-number">1</span> ;
        rover.direction(RoverDirections.getDirection(value));
    <span class="hljs-built_in">return</span> rover;
    }    
}
</code></pre>
<h3><a id="Classe_MarsRover_188"></a>Classe MarsRover</h3>
<p>This is the main class of the project, in which we get inputs using Scanner.</p>
<pre><code class="language-sh">public class MarsRover {
  
    public static void main(String[] args) {
    
        Movement movement = new Movement();
    String <span class="hljs-built_in">continue</span>W = <span class="hljs-string">""</span>;
        int x = <span class="hljs-number">0</span>;
        int y = <span class="hljs-number">0</span>;
        String orientation = <span class="hljs-string">""</span>;
        System.out.println(<span class="hljs-string">"Enter the maximum coordinate of X and Y:"</span>);
        Scanner <span class="hljs-built_in">read</span>CoordinatesXY = new Scanner(System.in);
        String maxCoordinateXY = <span class="hljs-built_in">read</span>CoordinatesXY.nextLine();
        <span class="hljs-keyword">do</span> {
            System.out.println(<span class="hljs-string">"Enter X position of the Rover: "</span>);
            Scanner <span class="hljs-built_in">read</span>X = new Scanner(System.in);
            x = <span class="hljs-built_in">read</span>X.nextInt();
            
            System.out.println(<span class="hljs-string">"Enter Y position of the Rover: "</span>);
            Scanner <span class="hljs-built_in">read</span>Y = new Scanner(System.in);
            y = <span class="hljs-built_in">read</span>Y.nextInt();

            System.out.println(<span class="hljs-string">"Enter the direction the Rover is facing: "</span>);
            Scanner <span class="hljs-built_in">read</span>Orientation = new Scanner(System.in);
            orientation = <span class="hljs-built_in">read</span>Orientation.nextLine();
            
            Rover rover = new Rover(x, y, RoverDirections.valueOf(orientation));
            
            System.out.println(<span class="hljs-string">"Where would you like the Rover to move to?  "</span>);
            Scanner <span class="hljs-built_in">read</span>Movimentacao = new Scanner(System.in);
            String movimentacao = <span class="hljs-built_in">read</span>Movimentacao.nextLine();
        
            movement.executeMovement(rover, movimentacao);
            rover.printRover(rover);
            
            System.out.println(<span class="hljs-string">"New Rover? (Y/N) "</span>);
            Scanner <span class="hljs-built_in">read</span>Continue = new Scanner(System.in);
            <span class="hljs-built_in">continue</span>W = <span class="hljs-built_in">read</span>Continue.nextLine();
            
        } <span class="hljs-keyword">while</span>(<span class="hljs-built_in">continue</span>W.toUpperCase().equals(<span class="hljs-string">"Y"</span>));    
    }
}
</code></pre>
