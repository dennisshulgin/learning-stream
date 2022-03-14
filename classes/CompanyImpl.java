package classes;

import interfaces.*;
import java.util.stream.*;

public class CompanyImpl implements Company {

	private String title;

	private Stream<Department> departments;
	
	public CompanyImpl(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDepartments(Stream<Department> departments) {
		this.departments = departments;
	}

	@Override
	public Stream<Department> getDepartments() {
		return departments;
	}

	@Override
	public String toString() {
		return title;
	}
}
