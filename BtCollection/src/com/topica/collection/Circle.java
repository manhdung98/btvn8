package com.topica.collection;

public class Circle implements Comparable<Circle>{
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Double circleArea(int radius) {
		return (Math.PI * radius * radius);
		
	}

	@Override
	public int compareTo(Circle o) {
		int result = 0;
		if (this.radius < o.radius) result = 1;
		if (this.radius > o.radius) result = -1;
		return result;
	}


}
