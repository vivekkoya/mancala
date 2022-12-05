package src;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class OvalMarble implements BoardStrategy {

	@Override
	public Double paintMarble(double x, double y) {
		// TODO Auto-generated method stub
		return new Ellipse2D.Double(x, y, 15, 25);
	}

}
