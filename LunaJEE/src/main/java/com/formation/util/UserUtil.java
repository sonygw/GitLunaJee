package com.formation.util;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class UserUtil implements SessionAware {

	// ------------------------------------------------------------------ VARIABLES
	// GLOBALES A L'APPLICATION -----
	private static Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		UserUtil.sessionMap = map;
	}
	// ------------------------------------------------------------------------------------------------------------

	public static final boolean verifUser() {

		if (sessionMap.get("client").equals(null))
			return false;
		else
			return true;

	}

}
