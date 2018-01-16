package com.formation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.DAO.ArtComDAO;
import com.formation.model.ArtCom;

@Service
@Transactional

public class ArtComServiceImpl implements ArtComService {

	@Autowired
	private ArtComDAO artComDao;

	/**
	 * constructeur vide
	 */
	public ArtComServiceImpl() {
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

		return artComDao.SelectAllArtComFromCommande(idCommande);

	}

	@Override
	public boolean DeleteArtCom(ArtCom obj) {

		return artComDao.DeleteArtCom(obj);

	}

	@Override
	public boolean UpdateArtCom(ArtCom obj) {

		return artComDao.UpdateArtCom(obj);
	}

	@Override
	public boolean CreateArtComFromCommande(ArtCom obj) {

		return artComDao.CreateArtComFromCommande(obj);
	}

	



}