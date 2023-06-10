package telran.point.dao;

import java.util.Arrays;
import java.util.Comparator;
import telran.point.comparators.PointComparator;
import telran.point.model.Point;

public class PointsSpace {
	Point[] points;
	Point relPoint;
	Comparator<Point> comparator;

	public PointsSpace(Point[] points, Point relPoint) {
		this.points = Arrays.copyOf(points, points.length);
		this.relPoint = relPoint;
		comparator = new PointComparator(this.relPoint);
		Arrays.sort(this.points, comparator);
	}

	public Point[] getPoints() {
		return points;
	}
	
	public void addPoint(Point point) {
		
		int index = Arrays.binarySearch(points, point, comparator);

		 if(index < 0) {
			   index = Math.abs(index)- 1;
			  }
		
		Point[] newPoints = new Point[points.length+1];
		System.arraycopy(points, 0, newPoints, 0, index);
		newPoints[index] = point;
		
		System.arraycopy(points, index, newPoints, index+1, points.length-index);
		this.points = Arrays.copyOf(newPoints, newPoints.length);
	}
	
	
}
