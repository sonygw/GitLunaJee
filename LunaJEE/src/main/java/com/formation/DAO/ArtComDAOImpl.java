package com.formation.DAO;

import java.util.ArrayList;


import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.model.ArtCom;

@Repository

public class ArtComDAOImpl implements ArtComDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * constructeur vide
	 */
	public ArtComDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructeur avec la connection
	 * 
	 * @param conn
	 *            connexionJDBC
	 */

	@Override
	public ArrayList<ArtCom> SelectAllArtComFromCommande(int idCommande) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<ArtCom> result = sessionFactory.getCurrentSession().createQuery("from ArtCom where idCommande =" +idCommande);
		return (ArrayList<ArtCom>) result.getResultList();

	}


	@Override
	public ArtCom SaveOrUpdateArtCom(ArtCom obj) {

		sessionFactory.getCurrentSession().saveOrUpdate(obj);	
		return obj;
	}


	@Override
	public ArtCom DeleteArtCom(ArtCom obj) {
		
		sessionFactory.getCurrentSession().delete(obj);
		return obj;
	}

}