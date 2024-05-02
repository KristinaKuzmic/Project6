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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kristina
 */
public class Clan extends AbstractDomainObject implements Serializable {

    private Long id;
    private String ime;
    private String prezime;
    private String JMBG;
    private Grupa grupa;

    public Clan() {
    }

    public Clan(Long id, String ime, String prezime, String JMBG, Grupa grupa) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.grupa = grupa;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
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
        final Clan other = (Clan) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String nazivTabele() {
        return " clan ";
    }

    @Override
    public String alijas() {
        return " c ";
    }

    @Override
    public String join() {
        return "left join grupa g on(c.grupaId=g.id)";
    }

    @Override
    public String toString() {
        return ime+ " "+prezime;
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> clanovi=new ArrayList<>();
        while(rs.next()){
            Clan clan=new Clan();
            Grupa grupa=new Grupa();
            grupa.setId(rs.getLong("g.id"));
            grupa.setBrojClanova(rs.getInt("g.brojClanova"));
            grupa.setNaziv(rs.getString("g.naziv"));
            clan.setId(rs.getLong("c.id"));
            clan.setIme(rs.getString("c.ime"));
            clan.setPrezime(rs.getString("c.prezime"));
            clan.setJMBG(rs.getString("c.jmbg"));
            clan.setGrupa(grupa);
            clanovi.add(clan);
        }
        return clanovi;
    }

    @Override
    public String koloneZaInsert() {
        return " (ime, prezime, jmbg, grupaId) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id= " + id;
    }

    @Override
    public String vrednostiZaInsert() {
        return " '" + ime + "', '" + prezime + "', '" + JMBG + "', " + grupa.getId();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "ime= '" + ime + "', prezime= '" + prezime + "', jmbg= '" + JMBG + "', grupaId=" + grupa.getId();
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String where() {
        return " id= '"+id+"'";
    }

    /**
     *
     * @param rs
     * @return
     * @throws Exception
     */
    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        if(rs.next()){
            id=rs.getLong("c.id");
            ime=rs.getString("c.ime");
            prezime=rs.getString("c.prezime");
            JMBG=rs.getString("c.jmbg");
            grupa.setId(rs.getLong("c.grupaId"));
            return this;
        }
        
            throw new SQLException("Ne postoji clan u bazi");
        
    }

    @Override
    public String whereSelect() {
        return "ime='"+ime+"'";
    }

    
}
