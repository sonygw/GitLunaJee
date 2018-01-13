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
		TypedQuery<Client> result = sessionFactory.getCurrentSession().createQuery("from Client where idClient =" +id);
		return (Client) result.getResultList();

	}

	@Override
	public ArrayList<Client> SelectAllClients() {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> result = sessionFactory.getCurrentSession().createQuery("Select * from client") ;
		return (ArrayList<Client>) result.getResultList();
	}

	@Override
	public boolean DeleteClient(Client obj) {
		sessionFactory.getCurrentSession().delete(obj);
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean UpdateClient(Client obj, int id) {
		

		Query query = sessionFactory.getCurrentSession().createQuery("Update client SET code = '" + obj.getCode() + "' ,nom = '" + obj.getNom() + "', prenom = '" + obj.getPrenom()
			+ "', mail = '" + obj.getEmail() + "', adresse = '" + obj.getAdresse() + "', carteFidel = "
			+ obj.isCarteFidelite() + ", remarques = '" + obj.getRemarques() + "', telephone = '"
			+ obj.getNumeroTelephone() + "', dateCrea = '" + obj.getDate() + "' where idClient = " + id + ";");
		query.executeUpdate();

		return true;
	}

	@Override
	public boolean CreateClient(Client obj) {
		
		sessionFactory.getCurrentSession().save(obj);

		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ArrayList<Client> SelectAllClientsByName(String nom) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("Select * from client where nom like '" + nom + "%'");
		query.executeUpdate();
		 return (ArrayList<Client>) query.getResultList();
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Client SelectLastClient() {
		
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT * FROM client ORDER BY idClient DESC LIMIT 1 ");
		query.executeUpdate();
		return (Client) query.getResultList();
		
	}

}
