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
public class Zakazivanje extends AbstractDomainObject implements Serializable {

    private Termin termin;
    private Grupa grupa;
    private Clan clan;
    private String napomena;

    public Zakazivanje() {
    }

    public Zakazivanje(Termin termin, Grupa grupa, Clan clan, String napomena) {
        this.termin = termin;
        this.grupa = grupa;
        this.clan = clan;
        this.napomena = napomena;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getNapomena() {
        return napomena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Zakazivanje other = (Zakazivanje) obj;
        if (!Objects.equals(this.termin, other.termin)) {
            return false;
        }
        if (!Objects.equals(this.grupa, other.grupa)) {
            return false;
        }
        return Objects.equals(this.clan, other.clan);
    }

    @Override
    public String nazivTabele() {
        return " zakazivanje ";
    }

    @Override
    public String alijas() {
        return " z ";
    }

    @Override
    public String join() {
        return " join termin t on (z.terminId=t.id) join grupa g on(z.grupaId=g.id) join clan c on(c.id=z.clanId) ";

    }

    @Override
    public String toString() {
        return "Zakazivanje{" + "termin=" + termin + ", grupa=" + grupa + ", clan=" + clan + ", napomena=" + napomena + '}';
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> zakazivanja = new ArrayList<>();
        while (rs.next()) {
            Zakazivanje zakazivanje = new Zakazivanje();
            Grupa grupa = new Grupa();
            Clan clan = new Clan();
            Termin termin = new Termin();
            grupa.setId(rs.getLong("g.id"));
            grupa.setBrojClanova(rs.getInt("g.brojClanova"));
            grupa.setNaziv(rs.getString("g.naziv"));
            clan.setId(rs.getLong("c.id"));
            clan.setIme(rs.getString("c.ime"));
            clan.setPrezime(rs.getString("c.prezime"));
            clan.setJMBG(rs.getString("c.jmbg"));
            clan.setGrupa(grupa);
            termin.setId(rs.getLong("t.id"));
            termin.setDatum(rs.getDate("t.datum"));
            termin.setVreme(rs.getString("t.vreme"));
            termin.setGrupa(grupa);
            zakazivanje.setClan(clan);
            zakazivanje.setGrupa(grupa);
            zakazivanje.setTermin(termin);
            zakazivanje.setNapomena(rs.getString("z.napomena"));
            zakazivanja.add(zakazivanje);
        }
        return (ArrayList<AbstractDomainObject>) zakazivanja;
    }

    @Override
    public String koloneZaInsert() {
        return " (terminId, grupaId, clanId, napomena) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "terminId="+termin.getId()+" and grupaId="+grupa.getId()+" and clanId="+clan.getId();
        
    }

    @Override
    public String vrednostiZaInsert() {
        return termin.getId() + ", " + grupa.getId() + " , " + clan.getId() + ", '" + napomena + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "napomena= " + napomena;
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
            Zakazivanje zakazivanje = new Zakazivanje();
            Grupa grupa = new Grupa();
            Clan clan = new Clan();
            Termin termin = new Termin();
            grupa.setId(rs.getLong("g.id"));
            grupa.setBrojClanova(rs.getInt("g.brojClanova"));
            grupa.setNaziv(rs.getString("g.naziv"));
            clan.setId(rs.getLong("c.id"));
            clan.setIme(rs.getString("c.ime"));
            clan.setPrezime(rs.getString("c.prezime"));
            clan.setJMBG(rs.getString("c.jmbg"));
            clan.setGrupa(grupa);
            termin.setId(rs.getLong("t.id"));
            termin.setDatum(rs.getDate("t.datum"));
            termin.setVreme(rs.getString("t.vreme"));
            termin.setGrupa(grupa);
            zakazivanje.setClan(clan);
            zakazivanje.setGrupa(grupa);
            zakazivanje.setTermin(termin);
            zakazivanje.setNapomena(rs.getString("z.napomena"));
            return zakazivanje;
        }
        throw new SQLException("Ne postoji zakazivanje");
    }

    @Override
    public String whereSelect() {
        return "";
    }

}
