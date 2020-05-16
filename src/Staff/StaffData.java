package Staff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaffData {
	
	private Integer id;
	private String name;
	private String surname;
	private Integer salary;
	private String type;
	
	Random rGen = new Random();
	ArrayList<Integer> idList = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();
	ArrayList<String> surnames = new ArrayList<>();
	ArrayList<Integer> salaryList = new ArrayList<>();
	int max = 12345;
	int min = 1234;
	int amt = 40;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getFullName() {
		return name + " " + surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public String getType() {
		return type == null ? "" : type;
	}
	public void setType(String type) {
		this.type =type;
	}
	
	public void readName() {

		File file = new File("names.txt");
		try (BufferedReader sN = new BufferedReader(new FileReader(file))) {

			String currentLine;

			while ((currentLine = sN.readLine()) != null) {
				names.add(currentLine);
				surnames.add(currentLine);
			}

		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void readSurname() {

		File file = new File("surname.txt");
		try (BufferedReader sN = new BufferedReader(new FileReader(file))) {

			String currentLine;

			while ((currentLine = sN.readLine()) != null) {
				surnames.add(currentLine);
			}

		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void genId() {
		int numId = rGen.nextInt(40);

		while (idList.size() < amt) {
			numId = rGen.nextInt(40);

			if (!idList.contains(numId)) {
				idList.add(numId);
			}

			// System.out.println(id + "unique ID number created");

		}

	}

	public void genSalary() {
		int salaries;

		while (salaryList.size() < amt) {
			salaries = rGen.nextInt(max - min) + min;

			if (!salaryList.contains(salaries)) {
				salaryList.add(salaries);
			}

			// System.out.println(salary.size() + " salary");

		}

	}

	public List<MedicalStaff> buildMedStaff(List<MedicalStaff> medStaff) {

		while (medStaff.size() < 30) {

			MedicalStaff medicalStaff = new MedicalStaff();
			medicalStaff.setId(idList.get(rGen.nextInt(idList.size())));
			medicalStaff.setName(names.get(rGen.nextInt(names.size())));
			medicalStaff.setSurname(surnames.get(rGen.nextInt(surnames.size())));
			medicalStaff.setSalary(salaryList.get(rGen.nextInt(salaryList.size())));
			medStaff.add(medicalStaff);
		}

		return medStaff;
	}

	public List<AdmStaff> buildStaff(List<AdmStaff> admin) {

		while (admin.size() < 10) {

			AdmStaff admStaff = new AdmStaff();
			admStaff.setId(idList.get(rGen.nextInt(idList.size())));
			admStaff.setName(names.get(rGen.nextInt(names.size())));
			admStaff.setSurname(surnames.get(rGen.nextInt(surnames.size())));
			admStaff.setSalary(salaryList.get(rGen.nextInt(salaryList.size())));			
			admin.add(admStaff);
		}

		return admin;
	}

}
