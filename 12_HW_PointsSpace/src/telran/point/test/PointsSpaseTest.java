package telran.point.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.point.dao.PointsSpace;
import telran.point.model.Point;

class PointsSpaseTest {
	Point p0, p2, p3, p4, p1, p_2;
	Point[] original;
	Point[] expected0;
	Point[] expected4;
	Point[] expected01;
	Point[] expected01_2;
	PointsSpace ps;

	@BeforeEach
	void setUp() throws Exception {
		p0 = new Point(0, 0);
		p1 = new Point(1.0, 1.0);
		p2 = new Point(2, 2);
		p3 = new Point(3, 3);
		p4 = new Point(4, 4);
		p_2 = new Point(-2, -2);
		original = new Point[] {p3, p2, p0, p4};
		expected0 = new Point[] {p0, p2, p3, p4};
		expected01 = new Point[] {p0, p1, p2, p3, p4};
		expected01_2 = new Point[] {p0, p1, p_2, p2, p3, p4};
		expected4 = new Point[] {p4, p3, p2, p0};
		ps = new PointsSpace(original, p0);
	}

	@Test
	void testPointsSpace() {
		assertArrayEquals(expected0, ps.getPoints());
		ps = new PointsSpace(original, p4);
		assertArrayEquals(expected4, ps.getPoints());
	}

	@Test
	void testAddPoint() {
		ps.addPoint(p1);
		assertArrayEquals(expected01, ps.getPoints());
		ps.addPoint(p_2);
		assertArrayEquals(expected01_2, ps.getPoints());
	}

}
