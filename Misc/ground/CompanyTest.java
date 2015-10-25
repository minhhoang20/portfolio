package ground;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ground.Company.Employee;

public class CompanyTest {
	Employee ceoBill = new Employee(0, "Bill");
	Employee dom = new Employee(1, "Dom");
	Employee samir = new Employee(2, "Samir");
	Employee michael = new Employee(3, "Michael");
	Employee bob = new Employee(4, "Bob");
	Employee peter = new Employee(5, "Peter");
	Employee porter = new Employee(6, "Porter");
	Employee milton = new Employee(7, "Milton");
	Employee nina = new Employee(8, "Nina");

	@Before
	public void setUp() throws Exception {
		ceoBill.addReport(dom);
		ceoBill.addReport(samir);
		ceoBill.addReport(michael);
		dom.addReport(bob);
		dom.addReport(peter);
		dom.addReport(porter);
		dom.addReport(milton);
		dom.addReport(nina);
		peter.addReport(milton);
		peter.addReport(nina);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNonUniqueEmployee() {
		Company.closestCommonManager(ceoBill, ceoBill, dom);
	}

	@Test(expected = NullPointerException.class)
	public void testNullEmployee() {
		Company.closestCommonManager(ceoBill, null, dom);
	}

	@Test
	public void testCommonList() {
		Employee employee1 = Company.closestCommonManager(ceoBill, milton, nina);
		assertEquals(peter.getId(), employee1.getId());

		Employee employee2 = Company.closestCommonManager(ceoBill, porter, nina);
		assertEquals(dom.getId(), employee2.getId());

		Employee employee3 = Company.closestCommonManager(ceoBill, samir, nina);
		assertEquals(ceoBill.getId(), employee3.getId());

		Employee employee4 = Company.closestCommonManager(ceoBill, peter, nina);
		assertEquals(peter.getId(), employee4.getId());
	}

	@Test
	public void testListManagers() {
		List<Employee> employees = Company.listManagers(ceoBill, milton);
		assertEquals(peter.getId(), employees.get(0).getId());
		assertEquals(dom.getId(), employees.get(1).getId());
		assertEquals(ceoBill.getId(), employees.get(2).getId());
	}
}
