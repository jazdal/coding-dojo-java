package com.sternritter.abstractArt;

public class Painting extends Art {
	private String paintType;

	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.printf("Title: %s\n", getTitle());
		System.out.printf("Artist: %s\n", getAuthor());
		System.out.printf("Description: %s\n", getDescription());
		System.out.printf("Paint Type: %s\n\n", getPaintType());
	}
}