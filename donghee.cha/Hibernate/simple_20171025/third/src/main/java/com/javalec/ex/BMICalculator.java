package com.javalec.ex;

public class BMICalculator {
	
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public void bmiCalcualtion(double weight, double height) {
		
		double h = height * 0.01;
		double result = weight / (h*h);
		
		System.out.println("BMI 지수 : " + (int)result);
	}

}
