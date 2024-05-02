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
public class Kurs extends AbstractDomainObject implements Serializable {

    private Long id;
    private String naziv;

    public Kurs() {
    }

    public Kurs(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String nazivTabele() {
        return " kurs ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> kursevi = new ArrayList<>();
        while (rs.next()) {
            Kurs kurs = new Kurs();
            kurs.setId(rs.getLong("id"));
            kurs.setNaziv(rs.getString("naziv"));
            kursevi.add(kurs);
        }
        return (ArrayList<AbstractDomainObject>) kursevi;
    }

    @Override
    public String koloneZaInsert() {
        return " (naziv) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " id=" + id;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naziv + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " naziv= '" + naziv + "' ";
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
        while (rs.next()) {
            Kurs kurs = new Kurs();
            kurs.setId(rs.getLong("id"));
            kurs.setNaziv(rs.getString("naziv"));
            return kurs;
        }
        throw new SQLException("Ne postoji kurs u bazi");
    }

    @Override
    public String whereSelect() {
        return "";
    }

}
