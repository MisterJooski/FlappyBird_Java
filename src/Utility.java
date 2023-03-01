import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Utility {

    private static HashMap<String, Image> cache = new HashMap<String, Image>();

    public static Image loadImage(String path) { // load image with input String path
        Image image = null; // object "Image" equals null (default)

		if (cache.containsKey(path)) {
			return cache.get(path);
		}

		try { // try and exception method
			image = ImageIO.read(new File(path)); // load image from object file input "path"

			if (!cache.containsKey(path)) {
				cache.put(path, image);
			}
		} 
		catch (IOException e) {
		    e.printStackTrace();
        }

		return image;
	}
}