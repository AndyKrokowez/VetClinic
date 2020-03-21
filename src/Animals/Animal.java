package Animals;


public class Animal{
		
	private String typeAnimal;
	private String name;
	private int age;
	private String gender;
	private String medCond;
	
	//Constructors

	//basic constructor
	public Animal() {}

	//class constructor
	public Animal(String typeAnimal, String name, int age, String gender, String medCond) {
		
		this.typeAnimal = typeAnimal;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.medCond = medCond;
		
		
	}

	//Getters and Setters
	
	public String getTypeAnimal() {
		return typeAnimal;
	}

	public void setTypeAnimal(String typeAnimal) {
		this.typeAnimal = typeAnimal;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMedCond() {
		return medCond;
	}

	public void setMedCond(String medCond) {
		this.medCond = medCond;
	}

	@Override
	public String toString() {
		return "Type of Animal: " + typeAnimal +"\n"+ "Name: " + name +"\n"+ "Age: " + age + " year(s)" + "\n"+ "Gender: " + gender
				+"\n"+ "Medical Condiction: " + medCond +"\n ";
	}

	
	
	

}
