package bounce;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

public class OvalShapeTest {

	@Test
	public void testMove() {
		Shape r1 = new OvalShape(0, 0, 5, 20,20,20,Color.blue,Color.black);
		Shape r2 = new OvalShape(5, 20, 5, 20,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testRight() {
		Shape r1 = new OvalShape(80, 0, 5, 0,20,20,Color.blue,Color.black);
		Shape r2 = new OvalShape(80, 0, -5, 0,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testLeft() {
		Shape r1 = new OvalShape(0, 0, -5, 0,20,20,Color.blue,Color.black);
		Shape r2 = new OvalShape(0, 0, 5, 0,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testTop() {
		Shape r1 = new OvalShape(0, 0, 0, -5,20,20,Color.blue,Color.black);
		Shape r2 = new OvalShape(0, 0, 0, 5,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testBottom() {
		Shape r1 = new OvalShape(0, 80, 0, 5,20,20,Color.blue,Color.black);
		Shape r2 = new OvalShape(0, 80, 0, -5,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testContains() {
		Point p1 = new Point(30,39);
		Shape r1 = new OvalShape(20, 20, 0, 0,20,20,Color.blue,Color.black);
		double dx, dy;
		Point EndPt = new Point(r1.fX + r1.fWidth, r1.fY + r1.fHeight);
		dx = (2 * p1.x - r1.fX - EndPt.x) / (double) r1.fWidth;
		dy = (2 * p1.y - r1.fY - EndPt.y) / (double) r1.fHeight;
		Boolean t1 = dx * dx + dy * dy < 1.0;
		Boolean t2 = true;
		assertEquals(t1,t2);
	}

}
