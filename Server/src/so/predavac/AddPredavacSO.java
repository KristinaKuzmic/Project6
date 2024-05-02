/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.predavac;

import domain.AbstractDomainObject;
import domain.Predavac;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class AddPredavacSO extends AbstractOperations {

    public AddPredavacSO() throws IOException, SQLException, Exception {
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (object == null || !(object instanceof Predavac)) {
            throw new Exception("Greška,predavac ne postoji u bazi.");
        } else {
            Predavac p = (Predavac) object;
            List<Predavac> predavaci = new ArrayList<>();
            try {
                predavaci = (ArrayList<Predavac>) (ArrayList<?>) broker.selectAll(new Predavac());
            } catch (Exception e) {
                throw new Exception("Greska prilikom ucitavanja podataka iz baze");
            } finally {
                if (!predavaci.isEmpty()) {
                    for (Predavac predavac : predavaci) {
                        if (predavac.getIme().equals(p.getIme()) && predavac.getPrezime().equals(p.getPrezime())) {
                            throw new Exception("Predavac sa ovim imenom i prezimenom vec postoji u bazi!");
                        }

                    }
                }
            }
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.insert((AbstractDomainObject) object);
    }

}
