package bounce;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/*
 *	======================================================================
 *	AnimationViewer.java : Moves shapes around on the screen
 *	It is the main drawing area where shapes are added and manipulated.
 *	It also contains a popup menu to clear all shapes.
 *	======================================================================
 */

public class AnimationViewer extends JPanel implements ActionListener	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes;		// the list to store all shapes
	private int defaultShapeType = 0; 	// tehd default shape type
	private final int DELAY = 100; 		// the default animation speed
	private JPopupMenu popup;				// popup menu
	private javax.swing.Timer timer;

	/** Constructor of the AnimationPanel
	 */
	public AnimationViewer() {
		timer = new javax.swing.Timer(DELAY, this);
		shapes = new ArrayList<Shape>(); //create an ArrayList to store shapes
		popup = new JPopupMenu(); //create the popup menu
		makePopupMenu();
		timer.start();

		// add the mouse event to handle popup menu and create new shape
		addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				maybeShowPopup(e);
			}

			public void mouseReleased(MouseEvent e) {
				maybeShowPopup(e);
			}

			private void maybeShowPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
			public void mouseClicked( MouseEvent e ) {
				boolean found = false;
				for (Shape s : shapes) {
					if ( s.contains( e.getPoint()) ) { // if the mousepoint is within a shape, then set the shape to be selected/deselected
						found = true;
						s.setSelected( ! s.isSelected() );
					 }
				}
				if (! found) createNewShape(e.getX(), e.getY()); // if the mousepoint is not within a shape, then create a new one according to the mouse position
			}
		});
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationPanel repaints itself.
		repaint();
	}

	/** creates a new shape
	 * @param x 	the x-coordinate of the mouse position
	 * @param y	the y-coordinate of the mouse position
	 */
	protected void createNewShape(int x, int y) {
		// create a new shape dependent on all current properties and the mouse position
		switch (defaultShapeType) {
			case 0: {
				shapes.add(new RectangleShape(x, y));
				break;
			}
			case 1: {
				shapes.add(new OvalShape(x, y));
				break;
			}
			case 2: {
				shapes.add(new DiamShape(x,y));
				break;
			}
			case 3: {
				shapes.add(new PacmanShape(x,y));				
			}
		}
	}

	/** sets the default shape type
	 * @param s	the new shape type
	 */
	public void setDefaultShapeType(int s) {
		defaultShapeType = s;
	}

	/** set the width for all currently selected shapes
	 * @param w	the new width value
	 */
	public void setWidth(int w) {
		for (Shape s : shapes) {
			if (s.isSelected()) {
				s.setWidth(w);
			}
		}
	}
	/** set the height for all currently selected shapes
	 * @param w	the new width value
	 */
	public void setHeight(int h) {
		for (Shape s : shapes) {
			if (s.isSelected()) {
				s.setHeight(h);
			}
		}
	}

	/** set the fill colour for all currently selected shapes
	 * @param c	the new fill colour value
	 */
	public void setFill(Color c){
		for (Shape s : shapes) {
			if (s.isSelected()) {
				s.setFill(c);
			}
		}
		
	}
	
	/** set the border colour for all currently selected shapes
	 * @param b	the new border colour value
	 */
	public void setBorder(Color b){
		for (Shape s : shapes){
			if (s.isSelected()) {
				s.setBorder(b);
			}			
		}
		
	}
	

	/** removes all shapes from our vector
	 */
	public void clearAllShapes() {
		shapes.clear();
	}

	/** creates the popup menu for our animation program
	 */
	protected void makePopupMenu() {
		JMenuItem menuItem;
	 // clear all
		menuItem = new JMenuItem("Clear All");
		menuItem.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllShapes();
			}
		});
		popup.add(menuItem);
	 }

	/**	updates the painting area
	 * @param g	the graphics control
	 */
	public void update(Graphics g){
		paint(g);
	}

	/**	moves and paints all shapes within the animation area
	 * @param g	the Graphics control
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Calculate bounds of animation screen area.
		int boundaryWidth = getSize().width;
		int boundaryHeight = getSize().height;

		for(Shape s : shapes) {
			s.paint(g);
			s.move(boundaryWidth,boundaryHeight );
		}
	}
}

