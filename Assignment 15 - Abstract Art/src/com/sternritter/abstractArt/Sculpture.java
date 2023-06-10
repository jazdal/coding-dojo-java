package com.sternritter.abstractArt;

public class Sculpture extends Art {
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.printf("Title: %s\n", getTitle());
		System.out.printf("Artist: %s\n", getAuthor());
		System.out.printf("Description: %s\n", getDescription());
		System.out.printf("Material: %s\n\n", getMaterial());
	}
}
