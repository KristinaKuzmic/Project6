/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import constants.ServerConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author Kristina
 */
public class DBConnection {
    
    private static DBConnection instance;
    
    private List<Connection> connections;

    private DBConnection() throws IOException, SQLException {
        connections = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("config/dbconfig.properties"));
                String url = properties.getProperty(ServerConstants.DB_URL);
                String user = properties.getProperty(ServerConstants.DB_USER);
                String password = properties.getProperty(ServerConstants.DB_PASSWORD);
                Connection connection = DriverManager.getConnection(url, user, password);
                //System.out.println("Konekcija sa bazom je uspesno kreirana!");
                connection.setAutoCommit(false);
                connections.add(connection);
            }catch(SQLException e) {
                System.out.println("Doslo je do greske prilikom povezivanja sa bazom");
                throw e;
            }
        }
    }

    public static DBConnection getInstance() throws IOException, SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public synchronized void push(Connection connection) {
        connections.add(connection);
    }

    public synchronized Connection pop() throws Exception {
        if (connections.isEmpty()) {
            throw new Exception("Nema slobodne konekcije");
        }
        Connection connection = connections.get(0);
        connections.remove(0);
        return connection;

    }

}
