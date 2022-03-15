package classes;

import interfaces.*;

public class UserImpl implements User{

	private String name;

	private int salary;

	private Department department;

	public UserImpl(String name, int salary, Department department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSalary() {
		return salary;
	}

	@Override
	public Department getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return name;
	}
}
