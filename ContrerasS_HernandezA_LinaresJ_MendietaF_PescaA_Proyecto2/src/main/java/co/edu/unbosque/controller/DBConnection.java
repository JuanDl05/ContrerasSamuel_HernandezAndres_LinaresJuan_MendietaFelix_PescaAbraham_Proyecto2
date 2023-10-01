/*
 * La clase DBConnection proporciona una conexión a una base de datos MySQL
 * y métodos para iniciar y cerrar la conexión, así como para acceder a los
 * objetos Connection, Statement, PreparedStatement y ResultSet.
 * Esta clase utiliza el controlador JDBC de MySQL para establecer la conexión
 * con la base de datos especificada.  
*/

package co.edu.unbosque.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedstatement = null;
	private ResultSet resultset = null;
	private final String IP = "127.0.0.1";
	private final String PORT = "3306";
	private final String DATABASE = "alcoholicosanonimos";
	private final String USERNAME = "root";
	private final String PASSWORD = "";

	/*
	 * Constructor por defecto de la clase DBConnection.
	 */
	public DBConnection() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Inicia la conexión a la base de datos utilizando los parámetros de conexión
	 * especificados en las constantes IP, PORT, DATABASE, USERNAME y PASSWORD.
	 * Además, carga el controlador JDBC de MySQL.
	 */
	public void initConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE, USERNAME,
					PASSWORD);
			System.out.println("Conexion realizada con exito!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Cierra la conexión a la base de datos, así como los objetos Statement,
	 * ResultSet y Connection si están abiertos.
	 */
	public void close() {

		try {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters y setters para los atributos de la clase

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public PreparedStatement getPreparedstatement() {
		return preparedstatement;
	}

	public void setPreparedstatement(PreparedStatement preparedstatement) {
		this.preparedstatement = preparedstatement;
	}

	public ResultSet getResultset() {
		return resultset;
	}

	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

	public String getIP() {
		return IP;
	}

	public String getPORT() {
		return PORT;
	}

	public String getDATABASE() {
		return DATABASE;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}
}
