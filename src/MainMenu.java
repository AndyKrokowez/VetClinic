import java.util.ArrayList;
import java.util.Scanner;

import Animals.Animal;
import Animals.AnimalData;
import Staff.AdmStaff;
import Staff.MedicalStaff;
import Staff.StaffData;
import Staff.Veterinarian;

public class MainMenu {

	public static void main(String[] args) {

		String continuing = "allData";
		int option = 0;

		do {

			System.out.println("1. LIST ALL STAFF");
			System.out.println("2. LIST STAFF BY CATEGORIES");
			System.out.println("3. LIST ALL ADM STAFF");
			System.out.println("4. SEARCH STAFF BY NAME");
			System.out.println("5. LIST ALL ANIMALS");
			System.out.println("6. LIST ANIMAL BY TYPE");
			System.out.println("7. SEARCH BY ANIMAL NAME");
			System.out.println("8. LIST ALL ANIMALS ASSIGNED TO MEDICAL STAFF");
			System.out.println("9. LIST TREATMENT ORDER OF THE ANIMALS ASSIGNED TO PARTICULAR MEDICAL STAFF");
			System.out.println("0. EXIT");
			System.out.println("SELECT MENU (0-9)");
			System.out.print("-> ");

			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();

			// second instance of scanner
			Scanner sc1 = new Scanner(System.in);

			switch (option) {
			case 1: {
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
				
				
				StaffData sData = new StaffData();
				sData.genId();
				sData.readName();
				sData.genSalary();
				ArrayList<AdmStaff> staff = new ArrayList<>();
				staff = sData.buildStaff(staff);

				for (AdmStaff c : staff) {
					System.out.println(c.toString());
				}
				continuing = "allData";
				break;

			}

			case 2: {
				System.out.println("To be done");

				continuing = "allData";
				break;
			}

			case 3: {
				// creating Adm Staff

				StaffData sData = new StaffData();
				sData.genId();
				sData.readName();
				sData.genSalary();
				ArrayList<AdmStaff> staff = new ArrayList<>();
				staff = sData.buildStaff(staff);

				for (AdmStaff c : staff) {
					System.out.println(c.toString());
				}

				continuing = "allData";
				break;

			}

			case 4: {
				System.out.println("To be done");
				continuing = "allData";
				break;
			}

			case 5: {

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
				continuing = "allData";
				break;
			}

			case 6: {
				System.out.println("To be done");
				continuing = "allData";
				break;
			}

			case 7: {
				System.out.println("To be done");
				continuing = "allData";
				break;
			}

			case 8: {
				System.out.println("To be done");
				continuing = "allData";
				break;
			}

			case 9: {
				System.out.println("To be done");
				continuing = "allData";
				break;
			}

			case 0: {
				
				System.out.println("Do you want exit? (Y/N)");
				System.out.print("-> ");
				String option1 = sc1.next();
				if (option1.equalsIgnoreCase("y")) {
					continuing = "y";
					break;
					
				} else {
					
					continuing = "allData";
					break;
				}
			}
			
			default: {
				System.out.println("Invalid option!");
				break;
			}
			}
			
		} while (!continuing.equalsIgnoreCase("y"));
	}
}
