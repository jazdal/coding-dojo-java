package com.codingdojo.caranddriver;

public class Driver extends Car {
	public void drive() {
		int gasLevel = super.getGas();
		System.out.println("You drive the car.");
		gasLevel--;
		super.setGas(gasLevel);
		super.status();
	}
	
	public void boost() {
		int gasLevel = super.getGas();
		if (gasLevel < 3) {
			System.out.println("Your gas level is not enough to boost the car.");
		} else {
			System.out.println("You used Boost.");
			gasLevel -= 3;
			super.setGas(gasLevel);
		}
		super.status();
	}
	
	public void refuel() {
		int gasLevel = super.getGas();
		if (gasLevel > 8) {
			System.out.println("No need to refuel right now. Your gas level is still adequate.");
		} else {
			System.out.println("You refueled the car.");
			gasLevel += 2;
			super.setGas(gasLevel);
		}
		super.status();
	}
}
