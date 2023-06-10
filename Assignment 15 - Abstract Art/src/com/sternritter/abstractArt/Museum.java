package com.sternritter.abstractArt;

import java.util.ArrayList;
import java.util.Random;

public class Museum {
	public static ArrayList<Art> museum = new ArrayList<Art>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		Painting painting1 = new Painting(
				"Mona Lisa", 
				"Leonardo da Vinci", 
				"An enigmatic portrait of a woman with a captivating smile.", 
				"Oil"
		);
		museum.add(painting1);
		
		Painting painting2 = new Painting(
				"Water Lilies", 
				"Claude Monet", 
				"A series of serene and immersive paintings capturing the reflection of water lilies in a pond.", 
				"Watercolor"
		);
		museum.add(painting2);
		
		Painting painting3 = new Painting(
				"Blue Poles", 
				"Jackson Pollock", 
				"A large-scale abstract expressionist painting featuring vibrant and chaotic blue poles.", 
				"Acrylic"
		);
		museum.add(painting3);
		
		Sculpture sculpture1 = new Sculpture(
				"David", 
				"Michelangelo", 
				"A stunning and iconic sculpture depicting the biblical hero David.", 
				"Marble"
		);
		museum.add(sculpture1);
		
		Sculpture sculpture2 = new Sculpture(
				"The Thinker", 
				"Auguste Rodin", 
				"A renowned sculpture depicting a seated figure lost in contemplation, symbolizing the power of intellect and introspection.", 
				"Bronze"
		);
		museum.add(sculpture2);
		
		ArrayList<Integer> randomArray = new ArrayList<Integer>();
		
		while (randomArray.size() < 5) {
			int randomNumber = random.nextInt(5);
			if (!randomArray.contains(randomNumber)) {
				randomArray.add(randomNumber);
			}
		}
		
		for (int index : randomArray) {
			museum.get(index).viewArt();
		}
	}
}
