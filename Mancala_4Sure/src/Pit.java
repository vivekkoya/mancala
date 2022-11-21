import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pit extends JButton {

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public Pit() throws IOException {
		URL file = new URL("file:///home/surikoya/Downloads/shadedcircle.jpg");
		Image img = ImageIO.read(file);
		ImageIcon pitImage = new ImageIcon(img);
		setBackground(new Color(Color.TRANSLUCENT));
	}

}
