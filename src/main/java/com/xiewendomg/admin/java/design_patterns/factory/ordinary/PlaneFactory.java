package com.xiewendomg.admin.java.design_patterns.factory.ordinary;

public class PlaneFactory extends VehicleFactory{
	public Moveable create() {
		return new Plane();
	}
}
