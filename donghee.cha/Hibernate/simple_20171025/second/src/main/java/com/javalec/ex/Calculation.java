package com.javalec.ex;

public class Calculation {
	
	public void add(int firstNum, int secondNum) {
		System.out.println("add");
		resultCalcul(firstNum, secondNum," + ",(firstNum + secondNum));
	}
	public void sub(int firstNum, int secondNum) {
		System.out.println("sub");
		resultCalcul(firstNum, secondNum," - ",(firstNum - secondNum));
	}
	public void mul(int firstNum, int secondNum) {
		System.out.println("mul");
		resultCalcul(firstNum, secondNum," * ",(firstNum * secondNum));
	}
	public void div(int firstNum, int secondNum) {
		System.out.println("div");
		resultCalcul(firstNum, secondNum, " / ",(firstNum / secondNum));
	} 
	
	public void resultCalcul(int firstNum, int secondNum, String calculCase, int result) {
		System.out.println(firstNum + calculCase + secondNum + " = " + result);
	}
}
