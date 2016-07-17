package bounce;
import java.awt.*;
/**
 * Class to represent a Diamond.
 *
 */
public class DiamShape extends Shape {
	/** constructor to create a diamond with default values
	 */
	public DiamShape() {
		super();
	}
	
	/**
	 * Creates a DiamShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 */
	public DiamShape(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Creates a DiamShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DiamShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a DiamShape instance with specified values for instance
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
	public DiamShape(int x, int y, int deltaX, int deltaY, int width, int height, Color fill, Color border) {
		super(x,y,deltaX,deltaY,width,height,fill,border);
	}
	
	/**
	 * Paints this DiamShape object using the supplied Graphics object.
	 */
	public void paint(Graphics g) {
		Polygon d = new Polygon();
		d.addPoint(fX, (fY + fHeight/2));
		d.addPoint((fX + fWidth/2), (fY + fHeight));
		d.addPoint((fX + fWidth), (fY + fHeight/2));
		d.addPoint((fX + fWidth/2), fY);
		
		g.setColor(fFill);
		g.fillPolygon(d);
		g.setColor(fBorder);
		g.drawPolygon(d);
		
		drawHandles(g);
	}
	
	/** Returns whether the point is in the diamond or not
	 * @return true if and only if the point is in the rectangle, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		Polygon d = new Polygon();
		d.addPoint(fX, (fY + fHeight/2));
		d.addPoint((fX + fWidth/2), (fY + fHeight));
		d.addPoint((fX + fWidth), (fY + fHeight/2));
		d.addPoint((fX + fWidth/2), fY);
		return d.contains(mousePt);
	}
}
