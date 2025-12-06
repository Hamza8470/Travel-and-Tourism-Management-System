
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash {

    public static void main(String[] args) {
        SplashFrame frame = new SplashFrame();
        frame.setVisible(true);
        int x = 1;
        for (int i = 0; i <= 500; i += 4, x += 5) {
            frame.setLocation(762 - (x + i) / 2, 410 - (i / 2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SplashFrame extends JFrame implements Runnable {
    Thread t1;

    SplashFrame() {
        try {
            ImageIcon i1 = ImageLoader.loadAndScaleImage("splash.jpg", 1200, 600);
            if (i1 == null) {
                System.out.println("Could not load splash image");
                return;
            }
            JLabel l1 = new JLabel(i1);
            add(l1);
            setBounds(200, 180, 1200, 500);// location ,Size
            setUndecorated(true);
            t1 = new Thread(this);
            t1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            this.setVisible(false);

            try {
                Login l = new Login();
                l.setVisible(true);
            } catch (Exception e) {
                System.out.println("Login window error: " + e.getMessage());
                e.printStackTrace();
                // If Login fails, keep splash visible
                this.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] arg) {

        SplashFrame frame = new SplashFrame();
        // multithreading

        frame.setVisible(true);
        int x = 1;
        for (int i = 0; i <= 500; i += 4, x += 5) {

            frame.setLocation(762 - (x + i) / 2, 410 - (i / 2));

            frame.setSize(x + i, i);

            try {
                Thread.sleep(10);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
