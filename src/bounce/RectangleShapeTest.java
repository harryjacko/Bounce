package bounce;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

public class RectangleShapeTest {

	@Test
	public void testMove() {
		Shape r1 = new RectangleShape(0, 0, 5, 20,20,20,Color.blue,Color.black);
		Shape r2 = new RectangleShape(5, 20, 5, 20,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testRight() {
		Shape r1 = new RectangleShape(80, 0, 5, 0,20,20,Color.blue,Color.black);
		Shape r2 = new RectangleShape(80, 0, -5, 0,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testLeft() {
		Shape r1 = new RectangleShape(0, 0, -5, 0,20,20,Color.blue,Color.black);
		Shape r2 = new RectangleShape(0, 0, 5, 0,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testTop() {
		Shape r1 = new RectangleShape(0, 0, 0, -5,20,20,Color.blue,Color.black);
		Shape r2 = new RectangleShape(0, 0, 0, 5,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testBottom() {
		Shape r1 = new RectangleShape(0, 80, 0, 5,20,20,Color.blue,Color.black);
		Shape r2 = new RectangleShape(0, 80, 0, -5,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testContains() {
		Point p1 = new Point(20,40);
		Shape r1 = new RectangleShape(20, 20, 0, 0,20,20,Color.blue,Color.black);
		Boolean t1 = p1.x >= r1.fX && p1.x <= (r1.fX + r1.fWidth+1);
		Boolean t2 = p1.y >= r1.fY && p1.y <= (r1.fY + r1.fHeight+1);
		Boolean t3 = true;
		assertEquals((t1 && t2), t3);
	}
}
