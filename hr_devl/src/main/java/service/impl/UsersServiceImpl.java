package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsersMapper;
import pojo.Users;
import service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersMapper UsersMapper=null;
	
	@Override
	public void addUsers(Users Users) {
		// TODO Auto-generated method stub
		UsersMapper.insertUsers(Users);
	}

	@Override
	public void removeUsers(short id) {
		// TODO Auto-generated method stub
		UsersMapper.deleteUsers(id);
	}

	@Override
	public void alterUsers(Users Users) {
		// TODO Auto-generated method stub
		UsersMapper.updateUsers(Users);
	}

	@Override
	public Users findUsersById(short id) {
		// TODO Auto-generated method stub
		return UsersMapper.selectUsersById(id);
	}

	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return UsersMapper.selectAllUsers();
	}
	
}
