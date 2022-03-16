import interfaces.*;
import classes.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String... args) {
		Department dep1 = new DepartmentImpl("IT");
		Department dep2 = new DepartmentImpl("HR");

		User user1 = new UserImpl("Denis", 500, dep1);
		User user2 = new UserImpl("Oxana", 400, dep1);
		User user3 = new UserImpl("Sanya", 200, dep1);
		User user4 = new UserImpl("Kristina",123, dep2);
		User user5 = new UserImpl("Olya",444, dep2);
		User user6 = new UserImpl("Masha",88, dep2);
		

		dep1.setChief(user1);
		dep2.setChief(user4);

		Company com1 = new CompanyImpl("ICT");
		List<User> usersDep1 = List.of(user1, user2, user3);
		List<User> usersDep2 = List.of(user4, user5, user6);
		

		dep1.setUsers(usersDep1);
		dep2.setUsers(usersDep2);

		List<Department> depsComp1 = List.of(dep1, dep2);

		com1.setDepartments(depsComp1);
		
		Map<User, List<Department>> departmentChief = getDepartmentByChief(com1);
		System.out.println(departmentChief);

		Map<User, List<String>> departmentNamesByChief = getDepartmentNamesByChief(com1);
		System.out.println(departmentNamesByChief);
		
		Map<User, List<User>> usersByChief = getUsersByChief(com1);
		System.out.println(usersByChief);


		Map<Department, Integer> minSal = getMinSalaryDepartments(com1); 
		System.out.println(minSal);
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
	
	public static Map<User, List<User>> getUsersByChief(Company company) {
		return company.getDepartments()
			.collect(groupingBy(Department::getChief, flatMapping(Department::getUsers, toList())));
	}
	
	public static Map<Department, Integer> getMinSalaryDepartments(Company company) {
		return company.getDepartments()
			.flatMap(Department::getUsers)
			.peek(x -> System.out.println(x.getDepartment()))
			.collect(toMap(User::getDepartment, User::getSalary, BinaryOperator.minBy(Comparator.naturalOrder())));
	}


}


