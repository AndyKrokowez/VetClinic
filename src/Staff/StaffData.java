package Staff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class StaffData {

	Random rGen = new Random();
	ArrayList<Integer> id = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();
	String[] medFunc = { "Nurse", "Veterinarian", "Trainee Vet", "Groomer", "Anesthetist" };
	String[] admFunc = { "Receptionist", "Cleaner", "IT", "Accountant" };
	ArrayList<Integer> salary = new ArrayList<>();
	int max = 12345;
	int min = 1234;
	int amt = 40;

	public void readName() {

		File file = new File("names.txt");
		try (BufferedReader sN = new BufferedReader(new FileReader(file))) {

			String currentLine;

			while ((currentLine = sN.readLine()) != null) {
				names.add(currentLine);
			}

		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void genId() {
		int numId = rGen.nextInt(500);

		while (id.size() < amt) {
			numId = rGen.nextInt(500);

			if (!id.contains(numId)) {
				id.add(numId);
			}

	//		System.out.println(id + "unique ID number created");

		}

	}

	public void genSalary() {
		int salaries;

		while (salary.size() < amt) {
			salaries = rGen.nextInt(max - min) + min;

			if (!salary.contains(salaries)) {
				salary.add(salaries);
			}

		//	System.out.println(salary.size() + " salary");

		}

	}

	public ArrayList<MedicalStaff> buildMedStaff(ArrayList<MedicalStaff> medStaff) {

		while (medStaff.size() < amt) {

			MedicalStaff medicalStaff = new MedicalStaff();
			medicalStaff.setId(id.get(rGen.nextInt(id.size())));
			medicalStaff.setName(names.get(rGen.nextInt(names.size())));
			medicalStaff.setMedFunc(medFunc[rGen.nextInt(medFunc.length)]);
			medicalStaff.setSalary(salary.get(rGen.nextInt(salary.size())));
			medStaff.add(medicalStaff);
		}

		return medStaff;
	}

}
