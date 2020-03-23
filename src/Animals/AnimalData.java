package Animals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AnimalData {

	Random rGen = new Random();
	ArrayList<String> names = new ArrayList<>();
	ArrayList<String> medConds = new ArrayList<>();
	ArrayList<Integer> age = new ArrayList<>();
//	Integer[] age = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	String[] gender = { "Male", "Female" };
	String[] typeAnimal = { "Horse", "Turtle", "Fish", "Bird", "Dog", "Cat", "Snake" };
	int max = 12;
	int min = 1;
	int amt = 1000;

	public void readNames() {

		File file = new File("animal.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				names.add(currentLine);
			}

		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void readMedCond() {

		File file = new File("medCond.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				medConds.add(currentLine);
			}

		}

		catch (IOException f) {
			System.out.println(f.getMessage());
		}

	}

	public void genAge(int amt) {
		int ages;

		while (age.size() <= amt) {
			ages = rGen.nextInt(max - min) + min;

			if (!age.contains(ages)) {
				age.add(ages);
			}

		}
		System.out.println(age.size() + " year(s)");

	}

	public ArrayList<Animal> buildAnimals(ArrayList<Animal> animals) {

		while (animals.size() <= amt) {

			Animal animal = new Animal();
			animal.setTypeAnimal(typeAnimal[rGen.nextInt(typeAnimal.length)]);
			animal.setGender(gender[rGen.nextInt(gender.length)]);
			animal.setName(names.get(rGen.nextInt(names.size())));
			animal.setAge(age.get(rGen.nextInt(age.size())));
//			animal.setAge(age[rGen.nextInt(age.length)]);
			animal.setMedCond(medConds.get(rGen.nextInt(medConds.size())));
			animals.add(animal);
		}

		return animals;
	}

}