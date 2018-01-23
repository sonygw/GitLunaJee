package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.context.ConteneurSpring;
import com.formation.model.Client;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Action(value="login" )
@Result(location="accueil", type="redirect", name="success")
public class LoginAction extends ActionSupport implements ModelDriven<Client> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);
	//UserService userService = context.getBean(UserService.class);
	Client client = context.getBean(Client.class);

	@Override
	public Client getModel() {
		// TODO Auto-generated method stub

		return client;
	}

	public String execute() {
		return "A completer";
	}

}