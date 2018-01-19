package com.formation.DAO;

import java.util.ArrayList;

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
				.createQuery("FROM Commande WHERE idClient=" + idclient).getResultList();

		return resultats;
	}

	@Override
	public Commande SelectCommande(int id) {

		Commande commande = (Commande) sessionFactory.getCurrentSession()
				.createQuery("FROM Commande WHERE idCommande=" + id);

		return commande;
	}

	@Override
	public ArrayList<Commande> SelectCommandesArticles(int id) {

		@SuppressWarnings("unchecked")
		ArrayList<Commande> resultats = (ArrayList<Commande>) sessionFactory.getCurrentSession()
				.createQuery("FROM Commande c, Artcom a WHERE c.idCommande=a.idCommande AND a.idArticle=" + id)
				.getResultList();

		return resultats;
	}

	

	@Override
	public Commande SaveOrUpdateCommande(Commande commande, int id) {
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

		Commande commande = (Commande) sessionFactory.getCurrentSession()
				.createQuery("FROM Commande ORDER BY idCommande DESC LIMIT 1 ");

		return commande;
	}

}
