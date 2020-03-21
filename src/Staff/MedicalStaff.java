package Staff;

public class MedicalStaff extends StaffData {

	public Integer id;
	public String name;
	public String medFunc;
	public Integer salary;

	public MedicalStaff() {

	}

	public MedicalStaff(Integer id, String name, String medFun, Integer salary, String medFunc) {
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

	public String getMedFunc() {
		return medFunc;
	}

	public void setMedFunc(String medFun) {
		this.medFunc = medFun;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Medical Staff \nID: " + id + "\n" + "Name: " + name + "\n" + "Function: " + medFunc + "\n"
				+ "Salary: E$ " + salary + ".00"+"\n";
	}

}
