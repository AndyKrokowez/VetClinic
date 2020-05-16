package Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Animals.Animal;

public class MedicalStaff extends StaffData {
	
	private int AnimalOrder;
	private List<Animal> Animals = new ArrayList<Animal>();

	public void passNextAnimal() {
		this.AnimalOrder = this.AnimalOrder + 1;
	}	
	
	public void addAnimal(Animal animal) {
		this.Animals.add(animal);
	}
	
	public List<Animal> getAnimals(){
		return this.Animals;
	}
	
	public List<Animal> getAnimalsOrdered(){
		return this.Animals.subList(this.AnimalOrder, Animals.size());
	}
	
	String[] medFunc = { "Nurse", "Groomer", "Anesthetist", "Veterinarian", "Trainee Vet"};

	public MedicalStaff() {
		this.setType(medFunc[new Random().nextInt(medFunc.length)]);
		this.AnimalOrder = 1;
	}	
	
	@Override
	public String toString() {
		return "Medical Staff \nID: " + getId() + "\n" + "Name: " + getName() +" " + getSurname() + "\n" + "Function: " + getType() + "\n"
				+ "Salary: E$ " + getSalary() + ".00"+"\n";
	}

}
