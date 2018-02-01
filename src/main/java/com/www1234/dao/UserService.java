package com.www1234.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
	  this.userMapper = userMapper;
	}
	
	public List<User> doGetUser(int id) {
	  return this.userMapper.getUser(id);
	}
	public void doInsertUser(User user) {
		  this.userMapper.insert(user);
	}
	public void doUpdateUser(User user) {
		  this.userMapper.update(user);
	}
	public void doDeleteUser(int id) {
		  this.userMapper.delete(id);
	}
}
