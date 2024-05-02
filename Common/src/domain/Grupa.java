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
public class Grupa extends AbstractDomainObject implements Serializable{
    private Long id;
    private String naziv;
    private int brojClanova;
    private Kurs kurs;
    private Predavac predavac;
    private List<Termin> listaTermina;

    public Grupa() {
    }

    public Grupa(Long id, String naziv, int brojClanova, Kurs kurs, Predavac predavac) {
        this.id = id;
        this.naziv = naziv;
        this.brojClanova = brojClanova;
        this.kurs = kurs;
        this.predavac = predavac;
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

    public int getBrojClanova() {
        return brojClanova;
    }

    public void setBrojClanova(int brojClanova) {
        this.brojClanova = brojClanova;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    public List<Termin> getListaTermina() {
        return listaTermina;
    }

    public void setListaTermina(List<Termin> listaTermina) {
        this.listaTermina = listaTermina;
    }

    @Override
    public String toString() {
        return  naziv ;
    }
    
    

    @Override
    public String nazivTabele() {
        return " grupa ";
    }

    @Override
    public String alijas() {
        return " g ";
    }

    @Override
    public String join() {
        return " join predavac p on(g.predavacId=p.id) join kurs k on(g.kursId=k.id) ";
        
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
        final Grupa other = (Grupa) obj;
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> lista=new ArrayList<>();

        while(rs.next()){
            Grupa grupa=new Grupa();
            Predavac predavac=new Predavac();
            Kurs kurs=new Kurs();
            kurs.setId(rs.getLong("k.id"));
            kurs.setNaziv(rs.getString("k.naziv"));
            predavac.setId(rs.getLong("p.id"));
            predavac.setIme(rs.getString("p.ime"));
            predavac.setPrezime(rs.getString("p.prezime"));
            grupa.setId(rs.getLong("g.id"));
            grupa.setBrojClanova(rs.getInt("g.brojClanova"));
            grupa.setNaziv(rs.getString("g.naziv"));
            grupa.setKurs(kurs);
            grupa.setPredavac(predavac);
            lista.add(grupa);
            }
        System.out.println(lista);
        return (ArrayList<AbstractDomainObject>) lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(naziv, brojClanova, kursId, predavacId)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id="+id;
    }

    @Override
    public String vrednostiZaInsert() {
        return "' "+naziv+"' , "+brojClanova+" , "+kurs.getId()+" , "+predavac.getId();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "naziv=' "+naziv+"' ,brojClanova= "+brojClanova+" , kursId="+kurs.getId()+" ,predavacId= "+predavac.getId();
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
            Grupa grupa=new Grupa();
            Predavac predavac=new Predavac();
            Kurs kurs=new Kurs();
            kurs.setId(rs.getLong("k.id"));
            kurs.setNaziv(rs.getString("k.naziv"));
            predavac.setId(rs.getLong("p.id"));
            predavac.setIme(rs.getString("p.ime"));
            predavac.setPrezime(rs.getString("p.prezime"));
            grupa.setId(rs.getLong("g.id"));
            grupa.setBrojClanova(rs.getInt("g.brojClanova"));
            grupa.setNaziv(rs.getString("g.naziv"));
            grupa.setKurs(kurs);
            grupa.setPredavac(predavac);
            return grupa;
            }
        throw new SQLException("Ne postoji grupa u bazi");
    }

    @Override
    public String whereSelect() {
        return "";
    }


    
}
