package bounce;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
/**
 * Class to represent a Pacman.
 *
 */
public class PacmanShape extends Shape {
	
	protected int aStart = 50;
	protected int eStart = 265;
	protected int aStartLeft = 230;
	protected int eStartLeft = 265;
	protected boolean chomp = true;
	protected boolean faceRight = true;
	
	/** constructor to create a Pacman with default values
	 */
	public PacmanShape() {
		super();
	}
	
	/**
	 * Creates a PacmanShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 */
	public PacmanShape(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Creates a PacmanShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public PacmanShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a PacmanShape instance with specified values for instance
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
	public PacmanShape(int x, int y, int deltaX, int deltaY, int width, int height, Color fill, Color border) {
		super(x,y,deltaX,deltaY,width,height,fill,border);
	}
	
	/**
	 * Paints this PacmanShape object using the supplied Graphics object.
	 * This also animates the mouth, changing each time this is called.
	 */
	public void paint(Graphics g) {
		if(fDeltaX < 0){
			faceRight = false;
		}
		if(fDeltaX>0){
			faceRight=true;
		}
		
		Graphics2D g2 = (Graphics2D) g;
		Arc2D.Float p = new Arc2D.Float(Arc2D.PIE);
		p.setFrame(fX, fY, fWidth, fHeight);
		// This animates the mouth movement as well as going beyond the assignment
		// brief and spinning the mouth the direction the Pacman is moving
		if (faceRight){
			if (aStart <= 0 ){
				chomp = false;			
			} else if (aStart >= 45){
				chomp = true;
			}
			if (chomp){
				aStart = aStart - 5;
				eStart = eStart + 10;			
			} else {
				aStart = aStart + 5;
				eStart = eStart - 10;
			}
			p.setAngleStart(aStart);
			p.setAngleExtent(eStart);			
		} else {
			if (aStartLeft <= 180 ){
				chomp = false;			
			} else if (aStartLeft >= 225){
				chomp = true;
			}
			if (chomp){
				aStartLeft = aStartLeft - 5;
				eStartLeft = eStartLeft + 10;			
			} else {
				aStartLeft = aStartLeft + 5;
				eStartLeft = eStartLeft - 10;
			}
			p.setAngleStart(aStartLeft);
			p.setAngleExtent(eStartLeft);
		}
		
		g2.setColor(fFill);
		g2.fill(p);
		g2.setColor(fBorder);
		g2.draw(p);

		
		drawHandles(g);
	}
	
	/** Returns whether the point is in the Pacman (circle, mouth state is ignored) or not
	 * @return true if and only if the point is in the rectangle, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		double dx, dy;
		Point EndPt = new Point(fX + fWidth, fY + fHeight);
		dx = (2 * mousePt.x - fX - EndPt.x) / (double) fWidth;
		dy = (2 * mousePt.y - fY - EndPt.y) / (double) fHeight;
		return dx * dx + dy * dy < 1.0;
	}

}
