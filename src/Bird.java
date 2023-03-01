import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Bird {
	// set public objects
    public int x;
    public int y;
    public int width;
    public int height;

    public boolean dead;

    public double yvel;
    public double gravity;
    // set private objects
    private int jumpDelay;
    private double rotation;

    private Image image;
    private Keyboard keyboard;
    // create bird class
    public Bird() {
        x = 100;
        y = 150;
        yvel = 0;
        width = 45;
        height = 32;
        gravity = 0.5;
        jumpDelay = 0;
        rotation = 0.0;
        dead = false;
        // create new "keyboard" object that retrieves instance 
        keyboard = Keyboard.getInstance();
    }
    // public update class
    public void update() {
        yvel += gravity; // Y vertical + gravity = gravity

        if (jumpDelay > 0) // if "jumpDelay" is greater than 0 then is constant
            jumpDelay--;
        
        if (!dead && keyboard.isDown(KeyEvent.VK_SPACE) && jumpDelay <= 0) {
            yvel = -10;
            jumpDelay = 10;
        } // if update does not equal boolean "dead" and keyboard is down and "jumpDelay" is less than 0

        y += (int)yvel; // y + yvel = yvel
    }

    public Render getRender() {
        Render r = new Render(); // create an object "r" using Render class
        r.x = x;
        r.y = y;

        if (image == null) {
            image = Utility.loadImage("pictures/bird.png"); // image equals Utility object that loads "bird.png" from pictures
        }
        r.image = image; // "r" of object image equals image
        
        // rotation of "bird.png"
        rotation = (90 * (yvel + 20) / 20) - 90;
        rotation = rotation * Math.PI / 180;

        if (rotation > Math.PI / 2)
            rotation = Math.PI / 2;

        r.transform = new AffineTransform();
        r.transform.translate(x + width / 2, y + height / 2);
        r.transform.rotate(rotation);
        r.transform.translate(-width / 2, -height / 2);

        return r;
    }
}

