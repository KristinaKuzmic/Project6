/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.termin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Kurs;
import domain.Termin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class AddTermine extends AbstractOperations {

    private List<Termin> termini = new ArrayList<>();

    public List<Termin> getTermini() {
        return termini;
    }

    public AddTermine() throws Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
      if(object==null){
          throw new Exception("Greska, termin ne postoji u bazi");
      }
      List<Termin> tt=(List<Termin>) object;
        for (Termin termin : tt) {
            if(termin.getDatum().before(new Date())){
                throw new Exception("Termin mora biti zakazan u buducnosti");
            }
        }
      List<Termin> termini=(ArrayList<Termin>)(ArrayList<?>) broker.selectAll(new Termin());
        for (Termin termin : termini) {
            for (Termin termin1 : tt) {
                if(termin.equals(termin1)){
                    throw new Exception("Ovakav termin vec postoji u bazi");
                }
            }
        }
      
      
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<Termin> tt = (ArrayList<Termin>) object;
        Long kljuc;
        for (Termin termin : tt) {
            PreparedStatement br = broker.insert(termin);
            ResultSet rs = br.getGeneratedKeys();
            while (rs.next()) {
                kljuc = rs.getLong(1);
                termin.setId(kljuc);
                termini.add(termin);
            }
        }
    }

}
