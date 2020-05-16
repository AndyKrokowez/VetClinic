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
//	public String medFunc;
	private Integer salary;
	private String type;
	
	Random rGen = new Random();
	ArrayList<Integer> idList = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();
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

		while (medStaff.size() < 25) {

			MedicalStaff medicalStaff = new MedicalStaff();
			medicalStaff.setId(idList.get(rGen.nextInt(idList.size())));
			medicalStaff.setName(names.get(rGen.nextInt(names.size())));
//			medicalStaff.setMedFunc(medFunc[rGen.nextInt(medFunc.length)]);
			medicalStaff.setSalary(salaryList.get(rGen.nextInt(salaryList.size())));
			medStaff.add(medicalStaff);
		}

		return medStaff;
	}

	public ArrayList<Veterinarian> buildDoctor(ArrayList<Veterinarian> doctor) {

	//	while (doctor.size() < 5) {

			//Veterinarian veterinarian = new Veterinarian();
			//veterinarian.setId(id.get(rGen.nextInt(id.size())));
			//veterinarian.setName(names.get(rGen.nextInt(names.size())));
//			medicalStaff.setMedFunc(medFunc[rGen.nextInt(medFunc.length)]);
		//	veterinarian.setSalary(salary.get(rGen.nextInt(salary.size())));
		//	doctor.add(veterinarian);
		//}

		return null;
	}

	public List<AdmStaff> buildStaff(List<AdmStaff> admin) {

		while (admin.size() < 10) {

			AdmStaff admStaff = new AdmStaff();
			admStaff.setId(idList.get(rGen.nextInt(idList.size())));
			admStaff.setName(names.get(rGen.nextInt(names.size())));
			admStaff.setSalary(salaryList.get(rGen.nextInt(salaryList.size())));			
			admin.add(admStaff);
		}

		return admin;
	}

}
