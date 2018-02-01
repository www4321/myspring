package com.www1234.dao;

import java.util.List;

public interface UserMapper {
	
	public List<User> getUser(int id);
	
	public void insert(User user);
	
	public void update(User user);
	
	public void delete(int id);
}

