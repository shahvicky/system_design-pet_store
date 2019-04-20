package com.pet.store;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.pet.store.animal.Animal;
import com.pet.store.animal.repository.Cat;
import com.pet.store.animal.repository.Dog;
import com.pet.store.animal.type.AnimalType;

public class PetStore {
	private static Map<AnimalType, Queue<Animal>> animals;
	private static int inventory;
	private static int maxInventory;
	
	PetStore(int i) {
		animals = new EnumMap<AnimalType, Queue<Animal>>(AnimalType.class);
		for(AnimalType type : AnimalType.values()) {
			animals.put(type, new LinkedList<>());
		}
//		System.out.println(animals);
		maxInventory = i;
	}
	
	public void add(AnimalType type, String name) throws Exception {
		if(inventory == maxInventory) {
			throw new Exception("Sorry, the Pet Store is full");
		}
		if(type == AnimalType.CAT) {
			animals.get(type).add(new Cat(name));
		} else if(type == AnimalType.DOG) {
			animals.get(type).add(new Dog(name));
		}
		inventory++;
		System.out.println(animals);
	}
	
	public Animal getAnyAnimal() throws Exception {
		if(inventory == 0) {
			throw new Exception("Sorry, the pet shop is empty");
		}
		int id = Integer.MAX_VALUE;
		// to find the smallest id which entered the pet shop first
		for(Map.Entry<AnimalType, Queue<Animal>> entry : animals.entrySet()) {
			if(entry.getValue().size() > 0) {
				id = Math.min(id, entry.getValue().peek().getId());
			}
		}
		Animal animal = null;
		// to find the animal with the found id
		for(Map.Entry<AnimalType, Queue<Animal>> entry : animals.entrySet()) {
			if(entry.getValue().size()>0 && entry.getValue().peek().getId() == id) {
				animal = entry.getValue().poll();
				break;
			}
		}
		inventory--;
		return animal;
		
	}
	
}
