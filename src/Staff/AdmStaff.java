package Staff;

public class AdmStaff {
	
	private int id;
	private String name;
	private int salary;
	private String type;
	
	public AdmStaff() {}
		
		
		//class constructor
		public AdmStaff(int id, String name, int salary, String type) {
			
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.type = type;
						
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getSalary() {
			return salary;
		}


		public void setSalary(int salary) {
			this.salary = salary;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}
		
	
	
	
	

}
