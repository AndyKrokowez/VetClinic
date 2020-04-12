package Staff;

import java.util.Random;

public class Veterinarian extends StaffData {

	public Integer id;
	public String name;
	public Integer salary;
	String[] doctor = {"Veterinarian Surgeon", "Trainee Vet"};

	public Veterinarian() {

	}

	public Veterinarian(Integer id, String name, String medFun, Integer salary, String[] doctor) {
		this.id = id;
		this.name = name;
		this.doctor = doctor;
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

	public String[] getDoctor() {
		return doctor;
	}

	public void setDoctor(String[] doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Veterinarian\nID: " + id + "\n" + "Name: " + name + "\n"+ "Function: " + (doctor[new Random().nextInt(doctor.length)]) + "\n"+ "Salary: E$ " + salary + ".00"+"\n";
		
		
	}

}
