package classes;

import interfaces.*;

public class UserImpl implements User{

	private String name;

	public UserImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
