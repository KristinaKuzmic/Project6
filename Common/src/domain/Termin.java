/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import contants.Constants;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Kristina
 */
public class Termin extends AbstractDomainObject implements Serializable {

    private Long id;
    private Grupa grupa;
    private Date datum;
    private String vreme;

    public Termin() {
    }

    public Termin(Long id, Grupa grupa, Date datum, String vreme) {
        this.id = id;
        this.grupa = grupa;
        this.datum = datum;
        this.vreme = vreme;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getVreme() {
        return vreme;
    }

    @Override
    public String toString() {
        return Constants.SDFDATUM.format(datum) + " " + vreme;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Termin other = (Termin) obj;
        if (!Objects.equals(this.grupa, other.grupa)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        return Objects.equals(this.vreme, other.vreme);
    }

  
    @Override
    public String nazivTabele() {
        return " termin ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return "join grupa g on (t.grupaId=g.id)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> termini=new ArrayList<>();
        while(rs.next()){
            Termin t=new Termin();
            Grupa grupa=new Grupa();
            grupa.setId(rs.getLong("g.id"));
            grupa.setBrojClanova(rs.getInt("g.brojClanova"));
            grupa.setNaziv(rs.getString("g.naziv"));
            t.setId(rs.getLong("t.id"));
            t.setDatum(rs.getDate("t.datum"));
            t.setVreme(rs.getString("t.vreme"));
            t.setGrupa(grupa);
            termini.add(t);
        }
        return (ArrayList<AbstractDomainObject>) termini;
    }

    @Override
    public String koloneZaInsert() {
        return " (grupaId, datum, vreme) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id=" + id+" and grupaId="+grupa.getId();
    }

    @Override
    public String vrednostiZaInsert() {
        return grupa.getId() + ", '" + new java.sql.Date(datum.getTime()) + "', '"+vreme+"'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "grupaId= " + grupa.getId() + " ,datum= '" + new java.sql.Date(datum.getTime()) + "', vreme='"+ vreme + "'";
    }

    @Override
    public String uslov() {
        return "ORDER BY datum asc";
    }

    @Override
    public String where() {
        return "";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        while(rs.next()){
            Termin t=new Termin();
            Grupa grupa=new Grupa();
            grupa.setId(rs.getLong("g.id"));
            grupa.setBrojClanova(rs.getInt("g.brojClanova"));
            grupa.setNaziv(rs.getString("g.naziv"));
            t.setId(rs.getLong("t.id"));
            t.setDatum(rs.getDate("t.datum"));
            t.setVreme(rs.getString("t.vreme"));
            t.setGrupa(grupa);
            return t;
        }
        throw new SQLException("Ne postoji termin");
    }

    @Override
    public String whereSelect() {
        return "";
    }

}
