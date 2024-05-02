/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zakazivanje;

import domain.AbstractDomainObject;
import domain.Zakazivanje;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class AddZakazivanjeSO extends AbstractOperations {

    public AddZakazivanjeSO() throws Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (object == null)//|| !(object instanceof Zakazivanje))
        {
            throw new Exception("Greška pri čuvanju podataka o članu.");
        } else {
            List<Zakazivanje> zz = (List<Zakazivanje>) object;
            List<Zakazivanje> zakazivanja = (ArrayList<Zakazivanje>) (ArrayList<?>) broker.selectAll(new Zakazivanje());
            for (Zakazivanje zakazivanje : zakazivanja) {
                for (Zakazivanje zakazivanje1 : zz) {
                    if (zakazivanje.equals(zakazivanje1)) {
                        throw new Exception("Greska, ovakvo zakazivanje vec postoji u bazi!");
                    }
                }
            }

        }

    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<Zakazivanje> zz = (ArrayList<Zakazivanje>) object;
        for (Zakazivanje zakazivanje : zz) {
            broker.insert(zakazivanje);

        }
    }

}
