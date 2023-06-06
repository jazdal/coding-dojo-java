package com.codingdojo.caranddriver;

public class Car {
	private int gas;
	
	public Car() {
		this.gas = 10;
	}

	public int getGas() {
		return this.gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

	public void status() {
		if (this.gas == 0) {
			System.out.println("Game Over");
		} else {
			System.out.printf("Gas remaining: %s/10\n\n", this.gas);
		}
	}
}
