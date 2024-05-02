/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.AbstractDomainObject;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Kristina
 */
public class DBBroker {

    private Connection connection;

    public DBBroker(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<AbstractDomainObject> selectAll(AbstractDomainObject ado) throws SQLException {
        String query = "SELECT * FROM" + ado.nazivTabele() + ado.alijas() + " " + ado.join() + " " + ado.uslov();
        System.out.println(query);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        return ado.vratiListu(rs);
        //vrati listu pravi listu od ResultSeta tj od tabele
    }

    public AbstractDomainObject selectOne(AbstractDomainObject object) throws SQLException {
        String query="select * from "+object.nazivTabele()+ object.alijas()+ " where "+object.where();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(query);
        return object.vratiJednog(rs);
        //return null;
    }
    
    

    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String query = "INSERT INTO " + ado.nazivTabele() + " " + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(query);
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(AbstractDomainObject ado) throws SQLException {
        String query = "UPDATE " + ado.nazivTabele() + " SET " + ado.vrednostiZaUpdate() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(query);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void delete(AbstractDomainObject ado) throws SQLException {
        String query = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(query);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
