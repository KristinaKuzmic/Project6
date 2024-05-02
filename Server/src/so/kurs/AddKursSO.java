/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kurs;

import domain.AbstractDomainObject;
//import domain.Clan;
import domain.Kurs;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class AddKursSO extends AbstractOperations {

    public AddKursSO() throws IOException, SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (object == null || !(object instanceof Kurs)) {
            throw new Exception("Greška pri čuvanju podataka o članu.");
        } else {
            Kurs k = (Kurs) object;
            List<Kurs> kursevi = new ArrayList<>();
            try {
                kursevi = (ArrayList<Kurs>) (ArrayList<?>) broker.selectAll(new Kurs());
            } catch (Exception e) {
                throw new Exception("Greska prilikom ucitavanja podataka iz baze");
            } finally {
                if (kursevi.size() != 0) {
                    for (Kurs kurs : kursevi) {
                        if (kurs.getNaziv().equals(k.getNaziv())) {
                            throw new Exception("Kurs sa ovim nazivom vec postoji u bazi!");
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
