package service;

import java.util.List;

import pojo.Users;

public interface UsersService{
	public void addUsers(Users UsersDetail);
	public void removeUsers(short id);
	public void alterUsers(Users UsersDetail);
	public Users findUsersById(short id);
	public List<Users> findAllUsers();
}
