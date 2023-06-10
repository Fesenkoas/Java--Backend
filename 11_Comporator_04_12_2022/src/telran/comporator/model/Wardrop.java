package telran.comporator.model;

import java.util.Objects;

public class Wardrop  implements Comparable<Wardrop> {
   private double height;
   private double width;
   private double depth;
public Wardrop(double height, double width, double depth) {
	super();
	this.height = height;
	this.width = width;
	this.depth = depth;
}
public double getHeight() {
	return height;
}
public double getWidth() {
	return width;
}
public double getDepth() {
	return depth;
}
   
    public double area() {
    	return width * depth;
    }
    public double volume() {
    	return height * area();
    }
	@Override
	public int hashCode() {
		return Objects.hash(depth, height, width);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wardrop other = (Wardrop) obj;
		return Double.doubleToLongBits(depth) == Double.doubleToLongBits(other.depth)
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}
	@Override
	public String toString() {
		return "Wardrop [height=" + height + ", width=" + width + ", depth=" + depth + ", area=" + area() + ", volume=" + volume() + "]";
	}
	@Override
	public int compareTo(Wardrop o) {
		// TODO Auto-generated method stub
		return Double.compare(height, o.height);
	}
    
    
    
}
