package com.xiewendomg.admin.java.design_patterns.factory.ordinary;

public class CarFactory extends VehicleFactory{
	public Moveable create() {
		return new Car();
	}
}
