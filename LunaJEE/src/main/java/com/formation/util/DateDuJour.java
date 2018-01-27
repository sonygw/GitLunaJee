package com.formation.util;

public class DateDuJour {

	/**
	 * 
	 * @return La date du jour en format yyyy/MM/dd
	 */
	public final static String getDateDuJour() {
		String format = "yyyy/MM/dd";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		java.util.Date date = new java.util.Date();
				
		return (formater.format( date ));
	}
}
