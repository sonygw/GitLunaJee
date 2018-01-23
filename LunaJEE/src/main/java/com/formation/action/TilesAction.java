package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("com.formation")
@Namespace("/")

public class TilesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "accueil", results = @Result(name = "accueil", location = "accueil", type = "tiles"))
	public String accueil() {
		return "accueil";
	}

	@Action(value = "articleAccueil", results = @Result(name = "articleAccueil", location = "articleAccueil", type = "tiles"))
	public String articleAccueil() {
		return "articleAccueil";
	}

	@Action(value = "articleCreer", results = @Result(name = "articleCreer", location = "articleCreer", type = "tiles"))
	public String articleCreer() {
		return "articleCreer";
	}

	@Action(value = "articleModif", results = @Result(name = "articleModif", location = "articleModif", type = "tiles"))
	public String articleModif() {
		return "articleModif";
	}

	@Action(value = "clientAccueil", results = @Result(name = "clientAccueil", location = "clientAccueil", type = "tiles"))
	public String clientAccueil() {
		return "clientAccueil";
	}

	@Action(value = "clientCreer", results = @Result(name = "clientCreer", location = "clientCreer", type = "tiles"))
	public String clientCreer() {
		return "clientCreer";
	}

	@Action(value = "clientModif", results = @Result(name = "clientModif", location = "clientModif", type = "tiles"))
	public String clientModif() {
		return "clientModif";
	}

	@Action(value = "commandeAccueil", results = @Result(name = "commandeAccueil", location = "commandeAccueil", type = "tiles"))
	public String commandeAccueil() {
		return "commandeAccueil";
	}

	@Action(value = "commandeCreer", results = @Result(name = "commandeCreer", location = "commandeCreer", type = "tiles"))
	public String commandeCreer() {
		return "commandeCreer";
	}
 	@Action(value = "commandeModif", results = @Result(name = "commandeModif", location = "commandeModif", type = "tiles"))
	public String commandeModif() {
		return "commandeModif";
	}

	@Action(value = "panier", results = @Result(name = "panier", location = "panier", type = "tiles"))
	public String panier() {
		return "panier";
	}

}
