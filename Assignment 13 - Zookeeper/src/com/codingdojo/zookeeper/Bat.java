package com.codingdojo.zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		setEnergyLevel(300);
	}
	
	public void fly() {
		int energyLevel = displayEnergy();
		energyLevel -= 50;
		setEnergyLevel(energyLevel);
		System.out.println("Screech screech! The bat takes off!");
		System.out.printf("Current energy level: %s\n\n", displayEnergy());
	}
	
	public void eatHumans() {
		int energyLevel = displayEnergy();
		energyLevel += 25;
		setEnergyLevel(energyLevel);
		System.out.println("Crunch crunch! The bat eats humans! Yummy!");
		System.out.printf("Current energy level: %s\n\n", displayEnergy());
	}
	
	public void attackTown() {
		int energyLevel = displayEnergy();
		energyLevel -= 100;
		setEnergyLevel(energyLevel);
		System.out.println("The bat attacks the town!");
		System.out.printf("Current energy level: %s\n\n", displayEnergy());
	}
}
