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

/**
 *
 * @author Kristina
 */
public class Predavac extends AbstractDomainObject implements Serializable {

    private Long id;
    private String ime;
    private String prezime;

    public Predavac() {
    }

    public Predavac(Long id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String nazivTabele() {
        return " predavac ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> predavaci=new ArrayList<>();
        while(rs.next()){
            Predavac p=new Predavac();
            p.setId(rs.getLong("p.id"));
            p.setIme(rs.getString("p.ime"));
            p.setPrezime(rs.getString("p.prezime"));
            predavaci.add(p);
        }
        return predavaci;
    }

    @Override
    public String koloneZaInsert() {
        return "(ime,prezime)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id=" + id;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "' , '" + prezime + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "ime='" + ime + "' , prezime='" + prezime + "'";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String where() {
        return "";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        while(rs.next()){
            Predavac p=new Predavac();
            p.setId(rs.getLong("p.id"));
            p.setIme(rs.getString("p.ime"));
            p.setPrezime(rs.getString("p.prezime"));
            return p;
        }
        throw new SQLException("Ne postoji predavac");
    }

    @Override
    public String whereSelect() {
        return "";
    }

}
