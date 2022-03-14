package interfaces;

import java.util.stream.*;

public interface Department {
	String getTitle();

	User getChief();

	Stream<User> getUsers();

	void setUsers(Stream<User> users);
	
	void setChief(User user);
}
