import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.util.stream.Collectors;

import Animals.Animal;
import Animals.AnimalData;
import Staff.AdmStaff;
import Staff.MedicalStaff;
import Staff.StaffData;

public class MainMenu {

	public static void main(String[] args) {
		StaffData sD = new StaffData();
		sD.genId();
		sD.readName();
		sD.genSalary();
		List<StaffData>  staff = new ArrayList<StaffData>();
		List<MedicalStaff> medStaff = new ArrayList<>();
		medStaff = sD.buildMedStaff(medStaff);		
		List<AdmStaff> admin = new ArrayList<AdmStaff>();
		admin = sD.buildStaff(admin);
		AnimalData aD = new AnimalData();
		aD.readNames();
		aD.readMedCond();
		aD.genAge(10);
		ArrayList<Animal> animals = new ArrayList<>();
		animals = aD.buildAnimals(animals);
		staff.addAll(medStaff);
		staff.addAll(admin);
		for (Animal a : animals) {
			medStaff.get(new Random().nextInt(medStaff.size())).addAnimal(a);			
		}	
		boolean continuing = true;
		int option = 0;
		String optionTxt = "";		

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
			System.out.println("10. For a given member of the medical staff, pass to the next pet. ");
			System.out.println("0. EXIT");
			System.out.println("SELECT MENU (0-9)");
			System.out.print("-> ");

			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();

			// second instance of scanner
			Scanner sc1 = new Scanner(System.in);

			switch (option) {
			case 1: {				
				for (StaffData c : staff) {
					System.out.println(c.toString());
				}						
				break;
			}
			case 2: {
				System.out.println("Please type a category");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;				
				for (StaffData c : staff) {
					if(c.getType().equalsIgnoreCase(optionTxt)) {
						System.out.println(c.toString());
						index = index +1;
					}					
				}
				if(index == 0) {
					System.out.println("No staff was found with that category");
				}
				
				break;
			}

			case 3: {
				// creating Adm Staff
				for (AdmStaff c : admin) {
					System.out.println(c.toString());
				}				
				break;
			}

			case 4: {
				System.out.println("Please type a name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				for (StaffData c : staff) {
					if(c.getName().equalsIgnoreCase(optionTxt)) {
						System.out.println(c.toString());
						index = index +1;
					}					
				}
				if(index == 0) {
					System.out.println("No staff was found with that name");
				}
				break;
			}
			case 5: {				
				for (Animal a : animals) {
					System.out.println(a.toString());
				}				
				break;
			}
			case 6: {
				System.out.println("Enter a type");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				for (Animal a : animals) {
					if(a.getTypeAnimal().equalsIgnoreCase(optionTxt)) {
						System.out.println(a.toString());
						index = index +1;
					}					
				}
				if(index == 0) {
					System.out.println("No animal was found with that type");
				}
				break;
			}

			case 7: {
				System.out.println("Please, type a name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				for (Animal a : animals) {
					if(a.getName().equalsIgnoreCase(optionTxt)) {
						System.out.println(a.toString());
						index = index +1;
					}					
				}
				if(index == 0) {
					System.out.println("No animal was found with that name");
				}
				break;
			}

			case 8: {
				System.out.println("Please, type the member staff name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				for (MedicalStaff c : medStaff) {
					if(c.getName().equalsIgnoreCase(optionTxt)) {
						System.out.println("Medical Staff:" + c.getName() + "\n" + "Function: " + c.getType() + "\n");
						for (Animal a : c.getAnimals()) {							
								System.out.println(a.toString());
								index = index +1;
						}						
					}					
				}
				
				if(index == 0) {
					System.out.println("No animal was found for that Staff Member");
				}
				break;
			}

			case 9: {
				System.out.println("Please, type the member staff name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				for (MedicalStaff c : medStaff) {
					if(c.getName().equalsIgnoreCase(optionTxt)) {
						System.out.println("Medical Staff:" + c.getName() + "\n" + "Function: " + c.getType() + "\n");
						for (Animal a : c.getAnimalsOrdered()) {
							System.out.println("Treatment Order number: " + (index + 1) + "\n");
							System.out.println(a.toString());
							index = index +1;
						}						
					}					
				}				
				if(index == 0) {
					System.out.println("No animal was found for that Staff Member");
				}
				break;
			}
			case 10:{
				System.out.println("Please, type the member staff name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				for (MedicalStaff c : medStaff) {
					if(c.getName().equalsIgnoreCase(optionTxt)) {
						c.passNextAnimal();
						System.out.println("Medical Staff:" + c.getName() + "\n" + "Function: " + c.getType() + "\n");
						for (Animal a : c.getAnimalsOrdered()) {
							System.out.println("Treatment Order number: " + (index + 1) + "\n");
							System.out.println(a.toString());
							index = index +1;
						}						
					}					
				}				
				if(index == 0) {
					System.out.println("No animal was found for that Staff Member");
				}
				break;
			}

			case 0: {
				
				System.out.println("Do you really want exit? (Y/N)");
				System.out.print("-> ");
				optionTxt = sc.next();
				if (optionTxt.equalsIgnoreCase("y")) {
					continuing = false;	
					System.out.println("Thank you for using our app");
				} 
				break;
			}			
			default: {
				System.out.println("Invalid option!");
				break;
			}
			}
			
		} while (continuing);
	}
	
	public static void setUp() {
		
	}

}
