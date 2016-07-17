package bounce;
import java.awt.*;
/*
 *  ===============================================================================
 *  OvalShape.java : A shape that is an oval.
 *  An oval/circle has 4 handles shown when it is selected (by clicking on it).
 *  ===============================================================================
 */
public class OvalShape extends Shape {
	/** constructor to create an oval with default values
	 */
	public OvalShape() {
		super();
	}
	/**
	 * Creates an OvalShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 */
	public OvalShape(int x, int y) {
		super(x,y);
	}

	/**
	 * Creates an OvalShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	/**
	 * Creates an OvalShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param fill fill color.
	 * @param border border color.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, Color fill, Color border) {
		super(x,y,deltaX,deltaY,width,height,fill,border);
	}

	/**
	 * Paints this OvalShape object using the supplied Painter object.
	 */
	public void paint(Graphics g) {
		g.setColor(fFill);
		g.fillOval(fX,fY,fWidth,fHeight);
		g.setColor(fBorder);
		g.drawOval(fX,fY,fWidth,fHeight);
		drawHandles(g);
	}

	/** Returns whether the point is in the oval or not
	 * @return true if and only if the point is in the oval, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		double dx, dy;
		Point EndPt = new Point(fX + fWidth, fY + fHeight);
		dx = (2 * mousePt.x - fX - EndPt.x) / (double) fWidth;
		dy = (2 * mousePt.y - fY - EndPt.y) / (double) fHeight;
		return dx * dx + dy * dy < 1.0;
	}
}
