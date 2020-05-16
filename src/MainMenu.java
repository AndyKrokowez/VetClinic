import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import Animals.Animal;
import Animals.AnimalData;
import Staff.AdmStaff;
import Staff.MedicalStaff;
import Staff.StaffData;

public class MainMenu {

	public static void main(String[] args) {
		//declaring lists objects to store the data
		List<StaffData>  staff = new ArrayList<StaffData>();
		List<MedicalStaff> medStaff = new ArrayList<>();				
		List<AdmStaff> admin = new ArrayList<AdmStaff>();		
		List<Animal> animals = new ArrayList<>();
		
		//Populating list and generating random data
		setUp(staff, medStaff, admin, animals);
		
		//declaring behavior variables
		boolean continuing = true;
		int option = 0;
		String optionTxt = "";		

		do {
			//displaying menu options
			displayMenu();
			
			//instance of scanner object
			Scanner sc = new Scanner(System.in);
			
			//collecting option from the user
			option = sc.nextInt();

			switch (option) {
			case 1: {
				//printing all staff
				for (StaffData c : staff) {
					System.out.println(c.toString());
				}						
				break;
			}
			case 2: {
				//searching any staff by category/type
				searchStaff(sc, optionTxt, staff, "category");				
				break;
			}
			case 3: {
				//printing all admin staff
				for (AdmStaff c : admin) {
					System.out.println(c.toString());
				}				
				break;
			}
			case 4: {
				//searching any staff by name
				searchStaff(sc, optionTxt, staff, "name");
				break;
			}
			case 5: {	
				//printing all animals
				for (Animal a : animals) {
					System.out.println(a.toString());
				}				
				break;
			}
			case 6: {
				//searching animals by type
				searchAnimals(sc,optionTxt,animals,"type");				
				break;
			}
			case 7: {
				//searching animals by name
				searchAnimals(sc,optionTxt,animals,"name");
				break;
			}
			case 8: {
				//searching the medical staff
				System.out.println("Please, type the member staff name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				int indexStaff = 0;
				for (MedicalStaff c : medStaff) {
					if(c.getFullName().toLowerCase().contains(optionTxt.toLowerCase())) {						
						System.out.println("Medical Staff:" + c.getFullName() + "\n" + "Function: " + c.getType() + "\n");
						//printing the animals of the staff treatment list
						for (Animal a : c.getAnimals()) {							
								System.out.println(a.toString());
								index = index +1;
						}						
						indexStaff = indexStaff + 1;
					}					
				}				
				if(indexStaff == 0) {
					System.out.println("No staff was found by that name");
				}else if(index == 0) {
					System.out.println("No animal was found for that Staff Member");
				}
				break;
			}
			case 9: {
				//searching the medical staff
				System.out.println("Please, type the member staff name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				int indexStaff = 0;
				for (MedicalStaff c : medStaff) {
					if(c.getFullName().toLowerCase().contains(optionTxt.toLowerCase())) {
						System.out.println("Medical Staff:" + c.getName() + "\n" + "Function: " + c.getType() + "\n");
						//printing the animals list treatment ordered
						for (Animal a : c.getAnimalsOrdered()) {
							System.out.println("Treatment Order number: " + (index + 1) + "\n");
							System.out.println(a.toString());
							index = index +1;
						}	
						indexStaff = indexStaff + 1;
					}					
				}
				if(indexStaff == 0) {
					System.out.println("No staff was found by that name");
				}else if(index == 0) {
					System.out.println("No animal was found for that Staff Member");
				}
				
				break;
			}
			case 10:{
				//searching the medical staff by name
				System.out.println("Please, type the member staff name");
				System.out.print("-> ");
				optionTxt = sc.next();
				int index = 0;	
				int indexStaff = 0;	
				for (MedicalStaff c : medStaff) {
					if(c.getFullName().toLowerCase().contains(optionTxt.toLowerCase())) {
						//passing the order to the next animal
						c.passNextAnimal();
						
						System.out.println("Medical Staff:" + c.getName() + "\n" + "Function: " + c.getType() + "\n");
						for (Animal a : c.getAnimalsOrdered()) {
							System.out.println("Treatment Order number: " + (index + 1) + "\n");
							System.out.println(a.toString());
							index = index +1;
						}	
						indexStaff = indexStaff + 1;
					}					
				}				
				if(indexStaff == 0) {
					System.out.println("No staff was found by that name");
				}else if(index == 0) {
					System.out.println("The Staff member does not have animals on his treatment list");
				}
				break;
			}
			case 0: {
				// confirming exit option
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
		// always displaying the menu after an action	
		} while (continuing);
	}
	
	public static void setUp(List<StaffData>  staff, List<MedicalStaff> medStaff,List<AdmStaff> admin,List<Animal> animals) {
		StaffData sD = new StaffData();
		sD.genId();
		sD.readName();
		sD.genSalary();
		medStaff = sD.buildMedStaff(medStaff);
		admin = sD.buildStaff(admin);
		AnimalData aD = new AnimalData();
		aD.readNames();
		aD.readMedCond();
		aD.genAge(10);
		animals = aD.buildAnimals(animals);
		staff.addAll(medStaff);
		staff.addAll(admin);
		for (Animal a : animals) {
			medStaff.get(new Random().nextInt(medStaff.size())).addAnimal(a);			
		}	
	}
	
	public static void displayMenu() {
		System.out.println("1. LIST ALL STAFF");
		System.out.println("2. LIST STAFF BY CATEGORIES");
		System.out.println("3. LIST ALL ADM STAFF");
		System.out.println("4. SEARCH STAFF BY NAME");
		System.out.println("5. LIST ALL ANIMALS");
		System.out.println("6. LIST ANIMAL BY TYPE");
		System.out.println("7. SEARCH BY ANIMAL NAME");
		System.out.println("8. LIST ALL ANIMALS ASSIGNED TO MEDICAL STAFF");
		System.out.println("9. LIST TREATMENT ORDER OF THE ANIMALS ASSIGNED TO PARTICULAR MEDICAL STAFF");
		System.out.println("10. FOR A GIVEN MEMBER OF THE MEDICAL STAFF, PASS TO THE NEXT PET TO BE TREATED.");
		System.out.println("0. EXIT");
		System.out.println("SELECT MENU (0-9)");
		System.out.print("-> ");
	}
	
	public static void searchStaff(Scanner sc, String optionTxt, List<StaffData> staff, String attribute) {
		System.out.println("Please type a " + attribute);
		System.out.print("-> ");
		optionTxt = sc.next();
		int index = 0;				
		for (StaffData c : staff) {
			switch (attribute) {
			case "category":
				//searching staff by type
				if(c.getType().equalsIgnoreCase(optionTxt)) {
					System.out.println(c.toString());
					index = index +1;
				}
				break;
			case "name":
				//searching staff by name or surname
				if(c.getFullName().toLowerCase().contains(optionTxt.toLowerCase())) {
					System.out.println(c.toString());
					index = index +1;
				}
				break;
			}								
		}
		if(index == 0) {
			System.out.println("No staff was found with that " + attribute);
		}
		
	}
	
	public static void searchAnimals(Scanner sc, String optionTxt, List<Animal> animals, String attribute) {
		System.out.println("Enter a " + attribute);
		System.out.print("-> ");
		optionTxt = sc.next();
		int index = 0;	
		for (Animal a : animals) {
			switch (attribute) {
			case "type":
				if(a.getTypeAnimal().equalsIgnoreCase(optionTxt)) {
					System.out.println(a.toString());
					index = index +1;
				}	
				break;

			case "name":
				if(a.getName().equalsIgnoreCase(optionTxt)) {
					System.out.println(a.toString());
					index = index +1;
				}
				break;
			}
							
		}
		if(index == 0) {
			System.out.println("No animal was found with that " + attribute);
		}
		
	}
}
