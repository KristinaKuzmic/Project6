/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.termin;

import domain.AbstractDomainObject;
import domain.Termin;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class GetTerminSO extends AbstractOperations {
    private List<Termin> termini;

    public GetTerminSO() throws Exception {
    }

    public List<Termin> getTermini() {
        return termini;
    }

    @Override
    protected void preconditions(Object object) throws Exception {

        if (object==null || !(object instanceof Termin)) {
            throw new Exception("Greška,termin ne postoji u bazi.");
        } else {
            System.out.println("Nađen termin.");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
     termini=(ArrayList<Termin>)(ArrayList<?>)   broker.selectAll((AbstractDomainObject) object);
    }

}
