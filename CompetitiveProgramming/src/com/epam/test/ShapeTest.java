package com.epam.test;

import java.util.HashMap;
import java.util.Map;

import main.epam.Shape;

public class ShapeTest {

	public void rectangleTest() {
		Shape cir = Shape.getInstance("Rectangle", new float[] { 1.0f });
		float area = cir.getArea();
		if (area != 2.0f) {
			System.out.println("test fail for rectangle");
		}
	}

}
