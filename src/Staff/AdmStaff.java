package Staff;

import java.util.Random;

public class AdmStaff extends StaffData {
		
	String[] admFunc = { "Receptionist", "Cleaner", "IT", "Accountant" };	
	
	public AdmStaff() {
		this.setType(admFunc[new Random().nextInt(admFunc.length)]);
	}	
	
	public String[] getTasks() {
		switch (getType()) {
		case "Receptionist": {
			return new String[] {"Making Phone Calls", "Filing", "Greet clients and visitors" };			
		}
		case "Cleaner": {
			return new String[] {"Clean facility areas", "dusting", "sweeping", "mopping"};			
		}
		case "IT": {
			return new String[] {"Installing and configuring computer software", "installing printers", "installing scanner", "fix any issue related to any tech device"};			
		}
		case "Accountant": {
			return new String[] {"preparing accounts and tax returns", "administering payrolls", "controlling income and expenditure" };			
		}		
		}
		return null;
	}

	@Override
	public String toString() {
		return "Adm Staff \nID: " + getId() + "\n" + "Name: " + getName() +  " " + getSurname() + "\n" + "Type: " + getType()  + "\n"
				+ "Salary: E$ " + getSalary() + ".00"+"\n" + "Tasks: " + String.join(", ",getTasks()) +"\n";
	}
	//(admFunc[new Random().nextInt(admFunc.length)])
}

