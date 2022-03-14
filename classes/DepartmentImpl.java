package classes;

import interfaces.*;
import java.util.stream.*;

public class DepartmentImpl implements Department{
	private String title;

	private Stream<User> users;

	private User chief;

	public DepartmentImpl(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}

	public void setUsers(Stream<User> users) {
		this.users = users;
	}

	@Override
	public Stream<User> getUsers() {
		return users;
	}

	public void setChief(User chief) {
		this.chief = chief;
	}

	@Override
	public User getChief() {
		return chief;
	}

	@Override
	public String toString() {
		return title;
	}


}
