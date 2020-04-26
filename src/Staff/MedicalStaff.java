package Staff;

import java.util.Random;

public class MedicalStaff extends StaffData {

	public Integer id;
	public String name;
	public Integer salary;
	String[] medFunc = { "Nurse", "Groomer", "Anesthetist"};

	public MedicalStaff() {

	}

	public MedicalStaff(Integer id, String name, String medFun, Integer salary, String[] medFunc) {
		this.id = id;
		this.name = name;
		this.medFunc = medFunc;
		this.salary = salary;
		
	}
	
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

	@Override
	public String toString() {
		return "Medical Staff \nID: " + id + "\n" + "Name: " + name + "\n" + "Function: " + (medFunc[new Random().nextInt(medFunc.length)]) + "\n"
				+ "Salary: E$ " + salary + ".00"+"\n";
	}

}
