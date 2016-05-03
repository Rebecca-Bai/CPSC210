package ca.ubc.cs.cpsc210.management;

/**
 * An employee at a software development company.
 */
public class Employee {
	private Department dept;
	private String name;
	private String employeeID;
	
	/**
	 * Constructor
	 * @param name         name of employee
	 * @param employeeID   ID of employee
	 */
	public Employee(String name, String employeeID) {
		this.name = name;
		this.employeeID = employeeID;
		dept = null;
	}
	
	/**
	 * Sets department for this employee. Removes employee from previous
	 * department, if any. If department is not null, adds employee to department.  
	 * 
	 * @param d  department to which employee is to be added
	 */
	public void setDepartment(Department d) {		
		if (dept != d) {
			if (dept != null) 
				dept.removeEmployee(this);
			
			dept = d;
			if (dept != null)
				dept.addEmployee(this);
		}
	}
	
	public Department getDepartment() {
		return dept;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeID == null) ? 0 : employeeID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		return true;
	}
}
