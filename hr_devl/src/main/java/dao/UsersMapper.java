package dao;

import java.util.List;

import pojo.Users;

public interface UsersMapper {
	public void insertUsers(Users SalaryGrantDetail);

	public void deleteUsers(short id);

	public void updateUsers(Users SalaryGrantDetail);

	public Users selectUsersById(short id);

	public List<Users> selectAllUsers();
}
