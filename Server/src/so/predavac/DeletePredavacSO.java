/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.predavac;

import domain.AbstractDomainObject;
import domain.Grupa;
import domain.Predavac;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class DeletePredavacSO extends AbstractOperations {

    public DeletePredavacSO() throws Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Predavac je vec obrisan");
        } else if (!(object instanceof Predavac)) {
            throw new Exception("Predavac ne postoji u bazi");
        } else {
            Predavac p = (Predavac) object;
            List<Grupa> grupe = (ArrayList<Grupa>) (ArrayList<?>) broker.selectAll(new Grupa());
            System.out.println(grupe);
            if (!(grupe.isEmpty())) {
                for (Grupa grupa : grupe) {
                    if (grupa.getPredavac() != null) {
                        if (grupa.getPredavac().getId().equals(p.getId())) {
                            throw new Exception("Nije moguce obrisati predavaca!");
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.delete((AbstractDomainObject) object);
    }

}
