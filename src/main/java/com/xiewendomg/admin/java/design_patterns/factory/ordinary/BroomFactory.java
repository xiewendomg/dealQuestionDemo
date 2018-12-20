package com.xiewendomg.admin.java.design_patterns.factory.ordinary;

public class BroomFactory extends VehicleFactory{
	public Moveable create() {
		return new Broom();
	}
}
