import javax.swing.*; // package that provide GUI components
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*; // provides 2D classes for defining and performing two-dimensional geometry

public class GamePanel extends JPanel implements Runnable {

    private Game game;

    public GamePanel() {
        game = new Game(); // create new object game
        new Thread(this).start(); // set new thread
    }

    public void update() { // update game object
        game.update();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // refer to parent class object

        Graphics2D g2D = (Graphics2D) g; // set 2D graphic to object g
        for (Render r : game.getRenders())
            if (r.transform != null)
                g2D.drawImage(r.image, r.transform, null);
            else
                g.drawImage(r.image, r.x, r.y, null);


        g2D.setColor(Color.BLACK); // set 2D graphic color to "BLACK"

        if (!game.started) { // set game start font to "TimesRoman"
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press SPACE to start", 150, 240);
        } else { // set game number font to "TimesRoman"
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 24));
            g2D.drawString(Integer.toString(game.score), 10, 465);
        }

        if (game.gameover) { // set gameover statement to "TimesRoman"
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press R to restart", 150, 240);
        }
    }

    public void run() { // try and exception method
        try {
            while (true) {
                update();
                Thread.sleep(25);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
