/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import domain.AbstractDomainObject;
import domain.Clan;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class UpdateClanSO extends AbstractOperations {

    public UpdateClanSO() throws IOException, SQLException, Exception {
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
                        if (clan.getJMBG().equals(c.getJMBG())&& clan.getIme().equals(c.getIme())
                                && clan.getPrezime().equals(c.getPrezime()) && clan.getGrupa().equals(c.getGrupa())) {
                           throw new Exception("Nije moguce zapamtiti clana");
                        }

                    }
                }
            }
        }

    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.update((AbstractDomainObject) object);
    }

}
