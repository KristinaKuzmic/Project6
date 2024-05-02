/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.predavac;

import domain.AbstractDomainObject;
import domain.Predavac;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class GetPredavacSO extends AbstractOperations {

    private List<Predavac> predavci;

    public List<Predavac> getPredavci() {
        return predavci;
    }

    public GetPredavacSO() throws Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (object==null || !(object instanceof Predavac)) {
            throw new Exception("Greška,predavac ne postoji u bazi.");
        } else {
            System.out.println("Nadjen predavac.");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        predavci=(ArrayList<Predavac>)(ArrayList<?>)broker.selectAll((AbstractDomainObject) object);
    }

}
