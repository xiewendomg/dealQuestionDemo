package com.xiewendomg.admin.java.design_patterns.factory.ordinary;

public class Test {
	public static void main(String[] args) {
		//Car c = Car.getInstance();
		//Car c2 = Car.getInstance();
		VehicleFactory factory = new BroomFactory();
		Moveable m = factory.create();
		//if(c == c2) System.out.println("same car");
		m.run();
	}
}
