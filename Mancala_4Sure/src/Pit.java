
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Pit extends JButton {

    private static final long serialVersionUID = 1L;
    ArrayList<Ellipse2D.Double> marbles = new ArrayList<>();
    int numOfMarbles = 0;
    private int oldMarbleCount = 0;

    /**
     * Create the panel.
     *
     * @throws IOException
     */
    public Pit() throws IOException {

        // setBackground(new Color(Color.TRANSLUCENT));
        setPreferredSize(new Dimension(200, 200));
        setBorder(new RoundedBorder(37));
        setOpaque(true);
    }

    public Pit(String string) {
        super(string);
    }

    void setMarbles(int num) {
        numOfMarbles = num;
        // Point p = get
        // Ellipse2D.Double marble = new Ellipse2D.Double(p.getX(), p.getY(), 34.22,
        // 34.22);
        // marbles.add(marble);
        // marbles.clear();
        // Random location = new Random();
        // for (int i = 0; i < numOfMarbles; ++i) {
        // double x = location.nextDouble(0, getWidth());
        //// Random color = new Random();
        // double y = location.nextDouble(0, getHeight());
        //// g2.setColor(new Color(color.nextInt(0, 240), color.nextInt(0, 240),
        // color.nextInt(0, 240)));
        // Ellipse2D.Double marble = new Ellipse2D.Double(x, y, 20, 20);
        // marbles.add(marble);
        // }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        URL file;
        try {
            // file = new URL(
            // "file:///home/surikoya/Documents/Fall%202022/classfiles/Eclipse-Workspace/Mancala/src/marble-big.jpg");
            // Image img = ImageIO.read(file);
            // int w = img.getWidth(null);
            // int h = img.getHeight(null);
            // BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            // g.drawImage(img, 0, 0, null);
            // g.drawImage(img, 40, 0, null);
            g2.setColor(Color.blue);
            Point p = getLocation();
            Random location = new Random();

            // g2.setColor(new Color(color.nextInt(0, 240), color.nextInt(0, 240),
            // color.nextInt(0, 240)));
            // marbles.add(marble);
            // marbles.clear();
            if (oldMarbleCount != numOfMarbles) {
                for (int i = oldMarbleCount; i < numOfMarbles; ++i) {
                    double x = location.nextInt(getWidth());
                    Random color = new Random();
                    double y = location.nextInt(getHeight());
                    Ellipse2D.Double marble = new Ellipse2D.Double(x, y, 20, 20);
                    marbles.add(marble);
                }
            }
            // repaint();
            for (Ellipse2D.Double c : marbles) {
                g2.fill(c);
            }
            g2.setColor(Color.black);
            oldMarbleCount = numOfMarbles;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // public void paintIcon(Component c, Graphics g, int x, int y) throws
    // IOException {
    // Graphics2D g2d = (Graphics2D) g.create();
    // URL file = new URL("file:///home/surikoya/Downloads/shadedcircle.jpg");
    // Image img = ImageIO.read(file);
    // g2d.drawImage(img, x, y, c);
    // repaint();
    //// g2d.dispose();
    // }

    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

}
