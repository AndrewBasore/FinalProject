package application;

public class Employee {
	private String firstName;
	private String lastName;
	private int employeeID;
	
	public Employee(String firstName, String lastName, int employeeID){
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
	}
	
	protected int getEmployeeID(){
		return this.employeeID;
	}
	
	protected void setName(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	protected String getName(){
		//getName formats name as "Firstname, lastname.charAt(0)"
		return this.firstName +" " + this.lastName.charAt(0);
	}

	public static void main(String[] args){
		Employee testEmployee = new Employee("Andrew", "Basore",3248);
				
		System.out.println(testEmployee.getName());
	}
}
