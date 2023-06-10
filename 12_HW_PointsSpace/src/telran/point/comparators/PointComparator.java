package telran.point.comparators;

import java.util.Comparator;

import telran.point.model.Point;

public class PointComparator implements Comparator<Point> {
	Point relPoint;

	public PointComparator(Point relPoint) {
		this.relPoint = relPoint;
	}

	@Override
	public int compare(Point o1, Point o2) {
		// s = Math.sqrt = (o1.x - o2.x) * 2 + (o1.y - o2.y) * 2
		// TODO Compare by distance to relPoint
		// Ask to Pithagoras
		
		double resO1 =  (Math.sqrt(Math.pow(relPoint.getX()-o1.getX(), 2))) + (Math.sqrt(Math.pow(relPoint.getY()-o1.getY(), 2)));
		double resO2 =  (Math.sqrt(Math.pow(relPoint.getX()-o2.getX(), 2))) + (Math.sqrt(Math.pow(relPoint.getY()-o2.getY(), 2)));
		if(resO1> resO2) return 1;
		if(resO1<resO2) return -1;
		return 0;
	}

}
