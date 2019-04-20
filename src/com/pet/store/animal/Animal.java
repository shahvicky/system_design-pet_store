package com.pet.store.animal;

public abstract class Animal {
	
	private String name;
	private int id;
	private static int count;
	
	public Animal() {
		setId(count++);
	}
	
	public Animal(String name) {
		setId(count++);
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "("+name+" "+id+")";
	}
}
