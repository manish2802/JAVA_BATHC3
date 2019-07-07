package com.asthvinayak.constant;

public class QueryConstant {
   
	public static String GET_LOGIN = new StringBuilder("SELECT USER_NAME AS UNAME,PASSWORD AS PWD FROM C_LOGIN")
			.append(" WHERE USER_NAME=? AND PASSWORD=?").toString();

	public static String GET_TX = new StringBuilder("").append(" ").toString();

}
