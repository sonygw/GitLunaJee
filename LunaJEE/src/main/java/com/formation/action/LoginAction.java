package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.context.ConteneurSpring;
import com.formation.model.User;
import com.formation.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Action(value="insert" )
@Result(location="/jsp/success.jsp", name="success")
public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConteneurSpring.class);
	UserService userService = context.getBean(UserService.class);
	User user1 = context.getBean(User.class);

	@Override
	public User getModel() {
		// TODO Auto-generated method stub

		return user1;
	}

	public String execute() {
		return "A completer";
	}

}