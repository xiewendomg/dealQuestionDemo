package com.xiewendomg.admin.java.design_patterns.factory.ordinary;

import java.util.ArrayList;
import java.util.List;

public class Car implements Moveable{
	
	private static Car car = new Car();
	//private static List<Car> cars = new ArrayList<Car>();
	
	public Car(){}
	
	public static Car getInstance() {
		
		return car;
	}
	
	public void run() {
		System.out.println("ð���̱�����car.......");
	}
}
