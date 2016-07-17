package bounce;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

import org.junit.Test;

public class DiamShapeTest {

	@Test
	public void testMove() {
		Shape r1 = new DiamShape(0, 0, 5, 20,20,20,Color.blue,Color.black);
		Shape r2 = new DiamShape(5, 20, 5, 20,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testRight() {
		Shape r1 = new DiamShape(80, 0, 5, 0,20,20,Color.blue,Color.black);
		Shape r2 = new DiamShape(80, 0, -5, 0,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testLeft() {
		Shape r1 = new DiamShape(0, 0, -5, 0,20,20,Color.blue,Color.black);
		Shape r2 = new DiamShape(0, 0, 5, 0,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testTop() {
		Shape r1 = new DiamShape(0, 0, 0, -5,20,20,Color.blue,Color.black);
		Shape r2 = new DiamShape(0, 0, 0, 5,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testBottom() {
		Shape r1 = new DiamShape(0, 80, 0, 5,20,20,Color.blue,Color.black);
		Shape r2 = new DiamShape(0, 80, 0, -5,20,20,Color.blue,Color.black);
		r1.move(100,100);
		assertEquals(r1,r2);
	}
	@Test
	public void testContains() {
		Point p1 = new Point(30,21);
		Shape d = new DiamShape(20, 20, 0, 0,20,20,Color.blue,Color.black);
		Polygon d1 = new Polygon();
		d1.addPoint(d.fX, (d.fY + d.fHeight/2));
		d1.addPoint((d.fX + d.fWidth/2), (d.fY + d.fHeight));
		d1.addPoint((d.fX + d.fWidth), (d.fY + d.fHeight/2));
		d1.addPoint((d.fX + d.fWidth/2), d.fY);
		Boolean t1 = d1.contains(p1);
		Boolean t2 = true;
		assertEquals(t1,t2);
	}
}
