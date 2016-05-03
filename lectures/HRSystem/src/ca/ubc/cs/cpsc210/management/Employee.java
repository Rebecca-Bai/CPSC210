package ca.ubc.cs.cpsc210.management;

/**
 * An employee at a software development company.
 */
public class Employee {
	String name;
	String employeeID;
	Department d;
	/**
	 * Constructor
	 * @param name         name of employee
	 * @param employeeID   ID of employee
	 */
	public Employee(String name, String employeeID) {
		this.name=name;
		this.employeeID=employeeID;
		d=null;
	}
	
	/**
	 * Sets department for this employee. Removes employee from previous
	 * department, if any. If department is not null, adds employee to department.  
	 * 
	 * @param d  department to which employee is to be added
	 */
	public void setDepartment(Department d) {
		if (this.d!=d) {
			if (this.d != null) {
				if (this.d.contains(this)) {
					this.d.removeEmployee(this);
				}
			}
			this.d = d;
			if (d != null) {
				d.addEmployee(this);
			}
		}
	}
	
	public Department getDepartment() {
		return d;  // stub
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
}
