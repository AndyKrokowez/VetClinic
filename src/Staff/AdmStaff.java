package Staff;

import java.util.Random;

public class AdmStaff extends StaffData {

	public Integer id;
	public String name;
//	public String medFunc;
	public Integer salary;
	String[] admFunc = { "Receptionist", "Cleaner", "IT", "Accountant" };
	
	public AdmStaff() {

	}

	public AdmStaff(Integer id, String name, String medFun, Integer salary, String[] admFunc) {
		this.id = id;
		this.name = name;
		this.admFunc = admFunc;
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
		return "Adm Staff \nID: " + id + "\n" + "Name: " + name + "\n" + "Function: " + (admFunc[new Random().nextInt(admFunc.length)]) + "\n"
				+ "Salary: E$ " + salary + ".00"+"\n";
	}

}

