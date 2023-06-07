package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {

	public void throwSomething() {
		int energyLevel = displayEnergy();
		energyLevel -= 5;
		setEnergyLevel(energyLevel);
		System.out.println("The gorilla threw something! (Don't ask what.)");
		System.out.printf("Current energy level: %s\n\n", displayEnergy());
	}
	
	public void eatBananas() {
		int energyLevel = displayEnergy();
		energyLevel += 10;
		setEnergyLevel(energyLevel);
		System.out.println("The gorilla ate bananas! Its hunger is satisfied.");
		System.out.printf("Current energy level: %s\n\n", displayEnergy());
	}
	
	public void climb() {
		int energyLevel = displayEnergy();
		energyLevel -= 10;
		setEnergyLevel(energyLevel);
		System.out.println("The gorilla climbed a tree!");
		System.out.printf("Current energy level: %s\n\n", displayEnergy());
	}

}
