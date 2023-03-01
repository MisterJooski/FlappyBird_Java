import javax.swing.*; // package; GUI toolkit and API usage

public class Application {

	public static int WIDTH = 500;	// set constant width of 500
    public static int HEIGHT = 520; // set constant height of 520

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // container for "java.awt"; provides components such as labels, buttons, and textfields
        frame.setVisible(true); // make the frame appear on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the frame
        frame.setLocationRelativeTo(null); // set default relative location

        Keyboard keyboard = Keyboard.getInstance(); // create object keyboard
        frame.addKeyListener(keyboard); // handles all events pertaining to any action with regards to keyboard object

        GamePanel panel = new GamePanel(); // create object "panel" via GamePanel which the frame holds the texts
        frame.add(panel); // add frame
        frame.setResizable(false); // set to false, the parameter cannot re-size the frame
        frame.setSize(WIDTH, HEIGHT); // set width and height
    }
}
