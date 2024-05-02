/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.termin;

import domain.AbstractDomainObject;
import domain.Termin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class UpdateTerminSO extends AbstractOperations{

    
    public UpdateTerminSO() throws Exception {
        super();
    }
    

    @Override
    protected void preconditions(Object object) throws Exception {
        if(object==null || !(object instanceof Termin)){
            throw new Exception("Greska, termin ne postoji u bazi");
        }
        Termin t=(Termin)object;
        List<Termin> termini=(ArrayList<Termin>)(ArrayList<?>) broker.selectAll(new Termin());
        /*for (Termin termin : termini) {
            if(termin.getDatum().before(new Date())){
                throw new Exception("Termin mora biti zakazan u buducnosti");
            }
        }*/
        if(t.getDatum().before(new Date())){
            throw new Exception("Termin mora biti zakazan u buducnosti");
        }
        if(!termini.isEmpty()){
            for (Termin termin : termini) {
                if(termin.equals(t)){
                    throw new Exception("Ovakav termin vec postoji u bazi");
                }
            }
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.update((AbstractDomainObject) object);
    }
    
}
