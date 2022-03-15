package classes;

import interfaces.*;
import java.util.*;
import java.util.stream.*;

public class CompanyImpl implements Company {

	private String title;

	private List<Department> departments;
	
	public CompanyImpl(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public Stream<Department> getDepartments() {
		return departments.stream();
	}

	@Override
	public String toString() {
		return title;
	}
}
