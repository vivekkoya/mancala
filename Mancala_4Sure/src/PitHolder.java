
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PitHolder extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public PitHolder() {

    }
//	Image image = new Image
    // ("/src/marble.jpeg");

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
//		g2d.drawImage(image, x, y, c);
//		g2d.dispose();
    }

    public int getIconWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getIconHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

}
