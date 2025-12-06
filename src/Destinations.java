
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Destinations extends JFrame implements Runnable {
   
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Thread t1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JLabel[] label = new JLabel[] { l1, l2, l3, l4, l5, l6, l7, l8, l9, l10 };


    public void run() {
               
        try {
            for (int i = 0; i <= 9; i++) {
                this.label[i].setVisible(true);
                Thread.sleep(2000);
                this.label[i].setVisible(false);

                if (i==9) {
                    this.setVisible(false);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    Destinations() {
        setBounds(500, 200, 900, 550);
        
        // Initialize labels
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();
        l6 = new JLabel();
        l7 = new JLabel();
        l8 = new JLabel();
        l9 = new JLabel();
        l10 = new JLabel();
        
        label = new JLabel[] { l1, l2, l3, l4, l5, l6, l7, l8, l9, l10 };

        // Load destination images
        for (int i = 0; i <= 9; i++) {
            ImageIcon image = ImageLoader.loadAndScaleImage("dest" + (i + 1) + ".jpg", 900, 550);
            this.label[i] = new JLabel(image);
            this.label[i].setBounds(0, 0, 900, 550);
            this.label[i].setVisible(false);
            add(this.label[i]);
        }
        
        t1 = new Thread(this);
        t1.start();
    }

    

}
