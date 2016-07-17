package bounce;
import java.awt.*;

public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	protected static final int DEFAULT_Y_POS = 0;
	protected static final int DEFAULT_DELTA_X = 5;
	protected static final int DEFAULT_DELTA_Y = 5;
	protected static final int DEFAULT_HEIGHT = 35;
	protected static final int DEFAULT_WIDTH = 25;
	protected static final Color DEFAULT_FILL = Color.blue;
	protected static final Color DEFAULT_BORDER = Color.black;	
	// ===

	// === Instance variables, accessible by subclasses.
	protected int fX;
	protected int fY;
	protected int fDeltaX;
	protected int fDeltaY;
	protected int fWidth;
	protected int fHeight;
	protected Color fFill;
	protected Color fBorder;
	protected boolean fSelected = false;  // draw handles if selected

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_FILL, DEFAULT_BORDER);
	}

	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_FILL, DEFAULT_BORDER);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_FILL, DEFAULT_BORDER);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 * @param defaultFill 
	 * @param defaultBorder 
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height, Color fill, Color border) {
		fX = x;
		fY = y;
		fDeltaX = deltaX;
		fDeltaY = deltaY;
		fWidth = width;
		fHeight = height;
		fFill = fill;
		fBorder = border;
	}

	/**
	 * Moves this Shape object within the specified bounds. On hitting a
	 * boundary the Shape instance bounces off and back into the two-
	 * dimensional world.
	 * @param boundaryWidth width of two-dimensional world.
	 * @param boundaryHeight height of two-dimensional world.
	 */
	public void move(int boundaryWidth, int boundaryHeight ) {
		int nextX = fX + fDeltaX;
		int nextY = fY + fDeltaY;

		if (nextX <= 0) {
			nextX = 0;
			fDeltaX = -fDeltaX;
		} else if (nextX + fWidth >= boundaryWidth) {
			nextX = boundaryWidth - fWidth;
			fDeltaX = -fDeltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			fDeltaY = -fDeltaY;
		} else if (nextY + fHeight >= boundaryHeight) {
			nextY = boundaryHeight - fHeight;
			fDeltaY = -fDeltaY;
		}
		fX = nextX;
		fY = nextY;
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	public abstract void paint(Graphics g);
	
	

	/** abstract contains method
	 * Returns whether the point p is inside the shape or not.
	 * @param p	the mouse point
	 */
	public abstract boolean contains(Point p);

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return fX;
	}

	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return fY;
	}

	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return fDeltaX;
	}

	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return fDeltaY;
	}

	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return fWidth;
	}

	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return fHeight;
	}

	/** Set the width of the shape.
	 * @param w 	the width value
	 */
	public void setWidth(int w) { fWidth = w; }

	/** Set the height of the shape.
	 * @param h 	the height value
	 */
	public void setHeight(int h) { fHeight = h; }
	
	/** Set the height of the shape.
	 * @param c 	the fill colour value
	 */
	public void setFill(Color c) {fFill = c;}
	
	/** Set the height of the shape.
	 * @param b 	the border colour value
	 */
	public void setBorder(Color b) {fBorder = b;}
	

	/** Return the selected property of the shape.
	 * @return the selected property
	 */
	public boolean isSelected() { return fSelected; }

	/** Set the selected property of the shape.
	 *  When the shape is selected, its handles are shown.
	 * @param s 	the selected value
	 */
	public void setSelected(boolean s) { fSelected = s; }

	/** Draw the handles of the shape
	 * @param g 	the Graphics control
	 */
	public void drawHandles(Graphics g) {
	// if the shape is selected, then draw the handles
		if (isSelected()) {
			g.setColor(Color.black);
			g.fillRect(fX -2, fY-2, 4, 4);
			g.fillRect(fX + fWidth -2, fY + fHeight -2, 4, 4);
			g.fillRect(fX -2, fY + fHeight -2, 4, 4);
			g.fillRect(fX + fWidth -2, fY-2, 4, 4);
		}
	}

	/**
	 * Returns a String whose value is the fully qualified name of this class
	 * of object. E.g., when called on a RectangleShape instance, this method
	 * will return "bounce.RectangleShape".
	 */
	public String toString() {
		return "[" + this.getClass().getName() + "," + fX + "," + fY + "," + fWidth + "," + fHeight + "]";
	}
	
	public boolean equals(Object obj) {
		if (! (obj instanceof Shape))
			return false;
		Shape s = (Shape)obj;
		return fX == s.fX && fY == s.fY && fDeltaX == s.fDeltaX && fDeltaY == s.fDeltaY && fWidth == s.fWidth && fHeight == s.fHeight && fSelected == s.fSelected;
	}	
}
