package src;

import java.awt.geom.Ellipse2D;

public class CircleMarble implements BoardStrategy {
	public Ellipse2D.Double paintMarble(double x, double y) {
		return new Ellipse2D.Double(x, y, 20, 20);
	}

}
