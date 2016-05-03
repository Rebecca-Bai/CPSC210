package ca.ubc.cs.cpsc210.management.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cs.cpsc210.management.Department;
import ca.ubc.cs.cpsc210.management.Employee;

public class EmployeeTest {

    private Department deptA;
    private Department deptB;
    private Employee empl;

    @Before
    public void runBefore() {
        deptA = new Department("Testing");
        deptB = new Department("Marketing");
        empl = new Employee("Jo", "J90");
    }

    @Test
    public void testConstructor() {
        assertEquals("Jo", empl.getName());
        assertEquals("J90", empl.getEmployeeID());
    }

    @Test
    public void testSetDepartment() {
        empl.setDepartment(deptA);
        assertEquals(deptA, empl.getDepartment());
        assertEquals(1, deptA.getNumEmployees());
        assertTrue(deptA.contains(empl));
    }

    @Test
    public void testChangeDepartment() {
        empl.setDepartment(deptA);
        empl.setDepartment(deptB);

        assertEquals(deptB, empl.getDepartment());
        assertEquals(0, deptA.getNumEmployees());
        assertFalse(deptA.contains(empl));
        assertEquals(1, deptB.getNumEmployees());
        assertTrue(deptB.contains(empl));
    }

    @Test
    public void testDetachDepartment() {
        empl.setDepartment(deptA);
        empl.setDepartment(null);

        assertEquals(0, deptA.getNumEmployees());
        assertFalse(deptA.contains(empl));
        assertEquals(null, empl.getDepartment());
    }
}
