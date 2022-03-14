import interfaces.*;
import classes.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String... args) {
		User user1 = new UserImpl("Denis");
		User user2 = new UserImpl("Oxana");
		User user3 = new UserImpl("Sanya");
		User user4 = new UserImpl("Kristina");
		User user5 = new UserImpl("Olya");
		User user6 = new UserImpl("Masha");
		
		Department dep1 = new DepartmentImpl("IT");
		Department dep2 = new DepartmentImpl("HR");
		dep1.setChief(user1);
		dep2.setChief(user4);

		Company com1 = new CompanyImpl("ICT");
		List<User> usersDep1 = List.of(user1, user2, user3);
		List<User> usersDep2 = List.of(user4, user5, user6);
		

		dep1.setUsers(usersDep1.stream());
		dep2.setUsers(usersDep2.stream());

		List<Department> depsComp1 = List.of(dep1, dep2);

		com1.setDepartments(depsComp1.stream());
		
		//Map<User, List<Department>> departmentChief = getDepartmentByChief(com1);
		//System.out.println(departmentChief);

		Map<User, List<String>> departmentNamesByChief = getDepartmentNamesByChief(com1);
		System.out.println(departmentNamesByChief);
				
	}

	public static Map<User, List<Department>> getDepartmentByChief(Company company) {
		return company.getDepartments()
			.peek(x -> System.out.println(x.getTitle()))
			.collect(groupingBy(Department::getChief));
	}

	public static Map<User, List<String>> getDepartmentNamesByChief(Company company) {
		return company.getDepartments()
			.collect(groupingBy(Department::getChief, mapping(Department::getTitle, toList())));
	}




}


