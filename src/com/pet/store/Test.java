package com.pet.store;

import com.pet.store.animal.type.AnimalType;

public class Test {

	public static void main(String[] args) throws Exception {
		PetStore petStore = new PetStore(5);
//		System.out.println(petStore.getAnyAnimal());
		petStore.add(AnimalType.CAT, "Cat1");
		petStore.add(AnimalType.DOG, "Dog1");
		petStore.add(AnimalType.DOG, "Dog2");
		petStore.add(AnimalType.CAT, "Cat2");
		petStore.add(AnimalType.DOG, "Dog3");
//		petStore.add(AnimalType.CAT, "Cat3");
		System.out.println(petStore.getAnyAnimal());
		System.out.println(petStore.getAnyAnimal());
		System.out.println(petStore.getAnyAnimal());
		System.out.println(petStore.getAnyAnimal());
		System.out.println(petStore.getAnyAnimal());
	}

}
