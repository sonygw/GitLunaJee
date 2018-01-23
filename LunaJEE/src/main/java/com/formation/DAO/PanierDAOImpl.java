package com.formation.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.Client;
import com.formation.model.Panier;

@Repository
public class PanierDAOImpl implements PanierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Panier SaveOrUpdatePanier(Panier obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public  ArrayList<Panier> SelectPanierFromClient(Client client) {
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery("from Panier where client = :cli");
		query.setParameter("cli", client);
		return (ArrayList<Panier>) query.getResultList();
	}

	@Override
	public long SelectCountArticleFromPanier() {
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery("select count(article) from Panier");
		return (long) query.uniqueResult();
	}

	@Override
	public Panier DeletePanier(Panier obj) {
		sessionFactory.getCurrentSession().delete(obj);
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override

	public ArrayList<Panier> DeletePanierFromClient(Client client) {
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery("delete Panier where client = :cli");
		query.setParameter("cli", client);
		return (ArrayList<Panier>) query.getResultList();
		
	}

}
