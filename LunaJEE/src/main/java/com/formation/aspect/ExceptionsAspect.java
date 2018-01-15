package com.formation.aspect;



import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

import org.aspectj.lang.annotation.Aspect;


@Aspect
public class ExceptionsAspect {

	private static Logger log = Logger.getLogger(ExceptionsAspect.class);
	
	@AfterThrowing("execution(* *.*.*(..))") 
	public void sqlExceptions(JoinPoint joinPoint, SQLException e) {
		log.info("Méthode " + joinPoint.getSignature().getName() + " a levée l'exception :" + e);
	}
		
	
	
	
}