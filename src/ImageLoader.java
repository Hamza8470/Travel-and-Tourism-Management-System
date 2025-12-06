import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageLoader {

    /**
     * Loads an image from ICONS folder with fallback to file system
     * 
     * @param imageName The name of the image file (e.g., "login.png")
     * @return ImageIcon or null if not found
     */
    public static ImageIcon loadImage(String imageName) {
        try {
            URL iconUrl = null;

            // Try classpath first
            iconUrl = ClassLoader.getSystemResource("ICONS/" + imageName);

            // If not found in classpath, try file system
            if (iconUrl == null) {
                File f = new File("src/ICONS/" + imageName);
                if (!f.exists()) {
                    f = new File("ICONS/" + imageName);
                }
                if (f.exists()) {
                    iconUrl = f.toURI().toURL();
                }
            }

            if (iconUrl != null) {
                return new ImageIcon(iconUrl);
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + imageName);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads and scales an image
     * 
     * @param imageName The name of the image file
     * @param width     Target width
     * @param height    Target height
     * @return Scaled ImageIcon or null if not found
     */
    public static ImageIcon loadAndScaleImage(String imageName, int width, int height) {
        ImageIcon icon = loadImage(imageName);
        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
            return new ImageIcon(img);
        }
        return null;
    }
}
