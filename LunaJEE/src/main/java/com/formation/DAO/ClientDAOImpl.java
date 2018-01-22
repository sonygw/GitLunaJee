/**
 * 
 */
package com.formation.DAO;

import java.util.ArrayList;


import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.Client;

/**
 * @author SDJ09
 *
 */
@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ClientDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Client SelectClient(int id) {

		@SuppressWarnings("unchecked")
		TypedQuery<Client> result = sessionFactory.getCurrentSession().createQuery("from Client where idClient =" + id);
		return (Client) result.getSingleResult();

	}

	@Override
	public ArrayList<Client> SelectAllClients() {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> result = sessionFactory.getCurrentSession().createQuery("from Client");
		return (ArrayList<Client>) result.getResultList();
	}

	@Override
	public Client DeleteClient(Client obj) {
		sessionFactory.getCurrentSession().delete(obj);
		return obj;
		
	}

	@Override
	public Client SaveOrUpdateClient(Client obj) {

		sessionFactory.getCurrentSession().saveOrUpdate(obj);

		return obj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ArrayList<Client> SelectAllClientsByName(String nom) {

		Query query = sessionFactory.getCurrentSession().createQuery("from Client where nom like:searchName");
		query.setParameter("searchName", "%" + nom + "%");
		return (ArrayList<Client>) query.getResultList();

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Client SelectLastClient() {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Client ORDER BY idClient DESC");
		query.setMaxResults(1);
		return (Client) query.uniqueResult();

	}

}