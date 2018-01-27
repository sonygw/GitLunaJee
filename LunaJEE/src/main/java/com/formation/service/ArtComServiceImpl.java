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

	
	@Override
	public ArrayList<ArtCom> SelectAllArtComFromCommande(int idCommande) {

		return artComDao.SelectAllArtComFromCommande(idCommande);

	}

	@Override
	public boolean DeleteArtCom(ArtCom obj) {

		if (artComDao.DeleteArtCom(obj).getIdArtCom() != 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean SaveOrUpdateArtCom(ArtCom obj) {

		if (artComDao.SaveOrUpdateArtCom(obj).getIdArtCom() != 0)
			return true;
		else
			return false;
	}

}