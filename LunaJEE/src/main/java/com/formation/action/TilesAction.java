package com.formation.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("com.formation")
@Namespace("/")

public class TilesAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------------------ VARIABLES
	// GLOBALES A L'APPLICATION -----
	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.sessionMap = map;
	}

	// ------------------------------------------------------------------------------------------------------------
	public boolean verifUser() {
		boolean b = false;
		try {
			b = (boolean) sessionMap.get("authentification");
			
		} catch (NullPointerException e) {
			

		}
		return b;
	}

	@Action(value = "accueil", results = { @Result(name = "accueil", location = "accueil", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String accueil() {

		if (!verifUser())
			return "inconnu";

		return "accueil";
	}

	@Action(value = "articleAccueil", results = {
			@Result(name = "articleAccueil", location = "articleAccueil", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String articleAccueil() {

		if (!verifUser())
			return "inconnu";

		return "articleAccueil";
	}

	@Action(value = "articleCreer", results = {
			@Result(name = "articleCreer", location = "articleCreer", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String articleCreer() {

		if (!verifUser())
			return "inconnu";

		return "articleCreer";
	}

	@Action(value = "articleModif", results = {
			@Result(name = "articleModif", location = "articleModif", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String articleModif() {

		if (!verifUser())
			return "inconnu";

		return "articleModif";
	}

	@Action(value = "articleResume", results = {
			@Result(name = "articleResume", location = "articleResume", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String articleResume() {

		if (!verifUser())
			return "inconnu";

		return "articleResume";
	}

	@Action(value = "clientAccueil", results = {
			@Result(name = "clientAccueil", location = "clientAccueil", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String clientAccueil() {

		if (!verifUser())
			return "inconnu";

		return "clientAccueil";
	}

	@Action(value = "clientCreer", results = { @Result(name = "clientCreer", location = "clientCreer", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String clientCreer() {

		if (!verifUser())
			return "inconnu";

		return "clientCreer";
	}

	@Action(value = "clientModif", results = { @Result(name = "clientModif", location = "clientModif", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String clientModif() {

		if (!verifUser())
			return "inconnu";

		return "clientModif";
	}

	@Action(value = "commandeAccueil", results = {
			@Result(name = "commandeAccueil", location = "commandeAccueil", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String commandeAccueil() {

		if (!verifUser())
			return "inconnu";

		return "commandeAccueil";
	}

	@Action(value = "commandeCreer", results = {
			@Result(name = "commandeCreer", location = "commandeCreer", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String commandeCreer() {

		if (!verifUser())
			return "inconnu";

		return "commandeCreer";
	}

	@Action(value = "commandeModif", results = {
			@Result(name = "commandeModif", location = "commandeModif", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String commandeModif() {

		if (!verifUser())
			return "inconnu";

		return "commandeModif";
	}

	@Action(value = "commandeResume", results = {
			@Result(name = "commandeResume", location = "commandeResume", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String commandeResume() {

		if (!verifUser())
			return "inconnu";

		return "commandeResume";
	}

	@Action(value = "panier", results = { @Result(name = "panier", location = "panier", type = "tiles"),
			@Result(name = "inconnu", location = "/403.jsp") })
	public String panier() {

		if (!verifUser())
			return "inconnu";

		return "panier";
	}

}
