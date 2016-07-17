package bounce;
import java.awt.*;

/**
 * Class to represent a simple rectangle.
 *
 */
public class RectangleShape extends Shape {
	/** constructor to create a rectangle with default values
	 */
	public RectangleShape() {
		super();
	}

	/**
	 * Creates a RectangleShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 */
	public RectangleShape(int x, int y) {
		super(x,y);
	}

	/**
	 * Creates a RectangleShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public RectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	/**
	 * Creates a RectangleShape instance with specified values for instance
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
	public RectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color fill, Color border) {
		super(x,y,deltaX,deltaY,width,height,fill,border);
	}

	/**
	 * Paints this RectangleShape object using the supplied Graphics object.
	 */
	public void paint(Graphics g) {
		g.setColor(fFill);
		g.fillRect(fX,fY,fWidth,fHeight);
		g.setColor(fBorder);
		g.drawRect(fX,fY,fWidth,fHeight);
		drawHandles(g);
	}

	/** Returns whether the point is in the rectangle or not
	 * @return true if and only if the point is in the rectangle, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		return (fX <= mousePt.x && mousePt.x <= (fX+ fWidth + 1)  &&  fY <= mousePt.y && mousePt.y <= (fY + fHeight + 1));
	}
}
