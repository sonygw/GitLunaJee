package com.formation.DAO;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.Commande;

@Repository
public class CommandeDAOImpl implements CommandeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ArrayList<Commande> SelectAllCommandes() {

		@SuppressWarnings("unchecked")
		ArrayList<Commande> commandes = (ArrayList<Commande>) sessionFactory.getCurrentSession()
				.createQuery("FROM Commande").getResultList();

		return commandes;
	}

	@Override
	public ArrayList<Commande> SelectCommandesClient(int idclient) {

		@SuppressWarnings("unchecked")
		ArrayList<Commande> resultats = (ArrayList<Commande>) sessionFactory.getCurrentSession()
				.createQuery("FROM Commande WHERE client_idClient=" + idclient).getResultList();

		return resultats;
	}

	@Override
	public Commande SelectCommande(int id) {

		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM Commande WHERE idCommande=" + id);
		return (Commande) query.getSingleResult();
	}

	@Override
	public ArrayList<Commande> SelectCommandesArticles(int id) {

		@SuppressWarnings("unchecked")
		ArrayList<Commande> resultats = (ArrayList<Commande>) sessionFactory.getCurrentSession()
				.createQuery("FROM Commande c, Artcom a WHERE c.idCommande=a.idCommande AND a.idArticle= ?" )
				.setParameter(0, id)
				.getResultList();

		return resultats;
	}

	

	@Override
	public Commande SaveOrUpdateCommande(Commande commande) {
		sessionFactory.getCurrentSession().saveOrUpdate(commande);
		return commande;
	}

	@Override
	public Commande DeleteCommande(Commande commande) {
		sessionFactory.getCurrentSession().delete(commande);
		return commande;
	}

	@Override
	public Commande SelectLastCommande() {

		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Commande ORDER BY idCommande DESC");
		query.setMaxResults(1);
		return (Commande) query.getSingleResult();

	
	}

}
