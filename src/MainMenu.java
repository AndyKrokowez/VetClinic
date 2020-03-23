import java.util.ArrayList;

import Animals.Animal;
import Animals.AnimalData;
import Staff.AdmStaff;
import Staff.MedicalStaff;
import Staff.StaffData;

public class MainMenu {

	public static void main(String[] args) {

//		 Animal a1 = new Animal();  
//		 a1.setAge(2);

//		 System.out.println(a1.toString());

		// creating 1000 animals

		AnimalData aD = new AnimalData();
		aD.readNames();
		aD.readMedCond();
		aD.genAge(10);
		ArrayList<Animal> animals = new ArrayList<>();
		animals = aD.buildAnimals(animals);

		for (Animal a : animals) {
			System.out.println(a.toString());
		}

		// creating Medical Staff

		StaffData sD = new StaffData();
		sD.genId();
		sD.readName();
		sD.genSalary();
		ArrayList<MedicalStaff> medStaff = new ArrayList<>();
		medStaff = sD.buildMedStaff(medStaff);
		for (MedicalStaff b : medStaff) {
			System.out.println(b.toString());
//		}

			// creating Adm Staff

//		StaffData sData = new StaffData();
//		sData.genId();
//		sData.readName();
//		sData.genSalary();
			ArrayList<AdmStaff> staff = new ArrayList<>();
			staff = sD.buildStaff(staff);

			for (AdmStaff c : staff) {
				System.out.println(c.toString());
			}

		}
	}
}