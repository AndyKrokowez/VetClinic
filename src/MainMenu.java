import java.util.ArrayList;

import Animals.Animal;
import Animals.AnimalData;



public class MainMenu {

	public static void main(String[] args) {
		 
//		 Animal a1 = new Animal();  
//		 a1.setAge(2);
		 
//		 System.out.println(a1.toString());
		
		
		//creating 1000 animals
		
		AnimalData aD = new AnimalData();
        aD.readNames();
        aD.readMedCond();
        aD.genAge(10);
        ArrayList<Animal> animals = new ArrayList<>();
        animals = aD.buildAnimals(animals);
        
        for(Animal a : animals)
        {
            System.out.println(a.toString());
        }

	}
}