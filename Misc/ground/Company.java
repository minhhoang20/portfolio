package ground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

	// IMPORTANT: DO NOT MODIFY THIS CLASS
	public static class Employee {

		private final int id;
		private final String name;
		private List<Employee> reports;

		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
			this.reports = new ArrayList<Employee>();
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public List<Employee> getReports() {
			return reports;
		}

		public void addReport(Employee employee) {
			reports.add(employee);
		}
	}

	/*
	 * Read the attached PDF for more explanation about the problem Note: Don't
	 * modify the signature of this function
	 * 
	 * @param ceo
	 *
	 * @param firstEmployee
	 * 
	 * @param secondEmployee
	 * 
	 * @return common manager for both employees that is closest to them.
	 */
	public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
		if (ceo == null || firstEmployee == null || secondEmployee == null) {
			throw new NullPointerException("Employee cannot be null.");
		}
		if (ceo.reports.isEmpty()) {
			throw new IllegalArgumentException("CEO does not have any reports.");
		}
		if (ceo.equals(firstEmployee) || ceo.equals(secondEmployee) || firstEmployee.equals(secondEmployee)) {
			throw new IllegalArgumentException("All employees must be distinct.");
		}
		List<Employee> shorterList;
		List<Employee> longerList;
		if (firstEmployee.reports.contains(secondEmployee)) {
			return firstEmployee;
		}
		if (secondEmployee.reports.contains(firstEmployee)) {
			return secondEmployee;
		}
		List<Employee> firstEmployeeManagers = Company.listManagers(ceo, firstEmployee);
		List<Employee> secondEmployeeManagers = Company.listManagers(ceo, secondEmployee);
		// If one employee has the shorter list of managers than the other, the former is higher ranked than the latter
		if (firstEmployeeManagers.size() >= secondEmployeeManagers.size()) {
			shorterList = secondEmployeeManagers;
			longerList = firstEmployeeManagers;
		} else {
			shorterList = firstEmployeeManagers;
			longerList = secondEmployeeManagers;
		}

		for (Employee manager : shorterList) {
			if (longerList.contains(manager)) {
				return manager;
			}
		}
		return null;
	}

	public static List<Employee> listManagers(Employee ceo, Employee employee) {
		if (ceo.equals(employee)) {
			return Collections.emptyList();
		}
		for (Employee report : ceo.reports) {
			List<Employee> list = new ArrayList<>();
			list.add(ceo);
			final List<Employee> employees = privateFindManagers(report, employee, list);
			if (!employees.isEmpty()) {
				Collections.reverse(employees);
				return employees;
			}
		}
		return Collections.emptyList();
	}

	private static List<Employee> privateFindManagers(Employee manager, Employee employee, List<Employee> currentList) {
		if (manager.equals(employee)) {
			return currentList;
		}
		if (manager.reports.isEmpty()) {
			return Collections.emptyList();
		}
		currentList.add(manager);
		for (Employee report : manager.reports) {
			List<Employee> temp = new ArrayList<>(currentList);
			List<Employee> managers = privateFindManagers(report, employee, temp);
			if (!managers.isEmpty()) {
				return managers;
			}
		}
		return Collections.emptyList();
	}
}