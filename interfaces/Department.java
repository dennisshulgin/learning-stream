package interfaces;

import java.util.*;
import java.util.stream.*;

public interface Department {
	String getTitle();

	User getChief();

	Stream<User> getUsers();

	void setUsers(List<User> users);
	
	void setChief(User user);
}
