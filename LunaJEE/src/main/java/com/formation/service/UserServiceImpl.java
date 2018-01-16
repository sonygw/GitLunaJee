package com.formation.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.UserDAO;
import com.formation.model.User;

@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<User> SelectAllUsers() {

		return userDao.SelectAllUsers();
	}

	@Override
	public boolean UpdateUser(User user) {

		return userDao.UpdateUser(user);
	}

	@Override
	public boolean CreateUser(User user) {

		return userDao.CreateUser(user);
	}

	@Override
	public boolean DeleteUser(User user) {

		return userDao.DeleteUser(user);
	}

	@Override
	public User SelectUser(int id) {

		return userDao.SelectUser(id);
	}
}
