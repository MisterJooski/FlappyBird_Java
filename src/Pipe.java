import java.awt.Image;

public class Pipe {
	
    public int x;
    public int y;
    public int width;
    public int height;
    public int speed = 3;
    
    public String orientation;

    private Image image;

    public Pipe(String orientation) { // pipe class with String orientation input
        this.orientation = orientation;
        reset();
    }

    public void reset() { // default position when game restarts
        width = 66;
        height = 400;
        x = Application.WIDTH + 2;

        if (orientation.equals("south")) {
            y = -(int)(Math.random() * 120) - height / 2;
        }
    }

    public void update() {
        x -= speed;
    }
    
    public boolean collides(int _x, int _y, int _width, int _height) {

        int margin = 2;

        if (_x + _width - margin > x && _x + margin < x + width) {

            if (orientation.equals("south") && _y < y + height) {
                return true;
            } else if (orientation.equals("north") && _y + _height > y) {
                return true;
            }
        }

        return false;
    }

    public Render getRender() { // render of "pipe" and orientation structure
        Render r = new Render();
        r.x = x;
        r.y = y;

        if (image == null) {
            image = Utility.loadImage("pictures/pipe-" + orientation + ".png");
        }
        r.image = image;

        return r;
    }
}