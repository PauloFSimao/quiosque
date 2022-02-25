package br.senai.sp.cadastroclientes.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionFactory {
	private static final String USER = "root";
	private static final String SENHA = "";
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_cadastroclientes", USER, SENHA);
			return conexao;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
