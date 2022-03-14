package interfaces;

import java.util.stream.*;

public interface Company {
	Stream<Department> getDepartments();
	void setDepartments(Stream<Department> departments);
}
