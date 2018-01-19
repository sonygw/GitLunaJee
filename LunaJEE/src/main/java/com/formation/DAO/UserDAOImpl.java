package com.formation.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<User> SelectAllUsers() {

		@SuppressWarnings("unchecked")
		ArrayList<User> users = (ArrayList<User>) sessionFactory.getCurrentSession().createQuery("from User")
				.getResultList();
		return users;
	}

	@Override
	public User SaveOrUpdateUser(User user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	

	@Override
	public User DeleteUser(User user) {

		sessionFactory.getCurrentSession().delete(user);
		return user;
	}

	@Override
	public User SelectUser(int id) {

		return (User) sessionFactory.getCurrentSession().createQuery("FROM user WHERE idUser=" + id);
	}
}
