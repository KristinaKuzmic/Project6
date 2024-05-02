/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Kristina
 */
public class Direktor extends AbstractDomainObject implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public Direktor() {
    }

    public Direktor(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direktor other = (Direktor) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String nazivTabele() {
        return " direktor ";
    }

    @Override
    public String alijas() {
        return " d ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> lista = new ArrayList<>();
        if (rs.next()) {
            Direktor d = new Direktor();
            d.setId(rs.getLong("id"));
            d.setUsername(rs.getString("username"));
            d.setPassword(rs.getString("password"));
            d.setFirstName(rs.getString("firtName"));
            d.setLastName(rs.getString("lastName"));
            lista.add(d);

        }
        return (ArrayList<AbstractDomainObject>) lista;

    }

    @Override
    public String koloneZaInsert() {
        return "(username, password, firstName, lastName)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id=" + id;
    }

    @Override
    public String vrednostiZaInsert() {
        return "' " + username + "' ,'" + password + "' ,'" + firstName + "' ,'" + lastName + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "username=' " + username + "' ,password='" + password + "' ,firstName='" + firstName + "' ,lastName'" + lastName + "'";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String where() {
        return "username= '" + username + "'and password= '" + password + "'";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        if (rs.next()) {
            id = rs.getLong("id");
            username = rs.getString("username");
            password = rs.getString("password");
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            return this;
        }
        throw new SQLException("Direktor ne postoji u bazi");
    }

    @Override
    public String whereSelect() {
        return "";
    }

}
