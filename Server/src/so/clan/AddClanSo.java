/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import domain.AbstractDomainObject;
import domain.Clan;
import domain.Direktor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class AddClanSo extends AbstractOperations {

    public AddClanSo() throws IOException, SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (object == null || !(object instanceof Clan)) {
            throw new Exception("Greška pri čuvanju podataka o članu.");
        } else {
            Clan c = (Clan) object;
            List<Clan> clanovi = new ArrayList<>();
            try {
                clanovi = (ArrayList<Clan>) (ArrayList<?>) broker.selectAll(new Clan());
            } catch (Exception e) {
                throw new Exception("Greska prilikom ucitavanja podataka iz baze");
            } finally {
                if (clanovi.size() != 0) {
                    for (Clan clan : clanovi) {
                        if (clan.getJMBG().equals(c.getJMBG())) {
                            throw new Exception("Nije moguce sacuvati clana");
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
