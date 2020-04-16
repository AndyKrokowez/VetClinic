import java.util.ArrayList;

import Animals.Animal;
import Animals.AnimalData;
import Staff.AdmStaff;
import Staff.MedicalStaff;
import Staff.StaffData;
import Staff.Veterinarian;

public class MainMenu {

	public static void main(String[] args) {

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
		}
		
		// creating Veterinarians

				StaffData vet = new StaffData();
				vet.genId();
				vet.readName();
				vet.genSalary();
				ArrayList<Veterinarian> veterinarian = new ArrayList<>();
				veterinarian = vet.buildDoctor(veterinarian);
				for (Veterinarian d : veterinarian) {
					System.out.println(d.toString());
				}

			// creating Adm Staff

		StaffData sData = new StaffData();
		sData.genId();
		sData.readName();
		sData.genSalary();
			ArrayList<AdmStaff> staff = new ArrayList<>();
			staff = sD.buildStaff(staff);

			for (AdmStaff c : staff) {
				System.out.println(c.toString());

			}
			System.out.println("number of Animals: " + animals.size());
			System.out.println("number of Medical Staff: " + medStaff.size());
			System.out.println("number of Veterinarians: " + veterinarian.size());
			System.out.println("number of Adm Staff: " + staff.size());
		}
	}
