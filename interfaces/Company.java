package interfaces;

import java.util.*;
import java.util.stream.*;

public interface Company {
	Stream<Department> getDepartments();
	void setDepartments(List<Department> departments);
}
