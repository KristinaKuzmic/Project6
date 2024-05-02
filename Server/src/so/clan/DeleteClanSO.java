/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import domain.AbstractDomainObject;
import domain.Clan;
import domain.Grupa;
import domain.Zakazivanje;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class DeleteClanSO extends AbstractOperations {
    
    public DeleteClanSO() throws Exception {
        super();
    }
    
    @Override
    protected void preconditions(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Clan je vec obrisan");
        }
        if (!(object instanceof Clan)) {
            throw new Exception("Clan ne postoji u bazi");
        }
        Clan c = (Clan) object;
        List<Zakazivanje> zakazivanja = (ArrayList<Zakazivanje>) (ArrayList<?>) broker.selectAll(new Zakazivanje());
        if (!(zakazivanja.isEmpty())) {
            for (Zakazivanje zakazivanje : zakazivanja) {
                if (zakazivanje.getClan() != null) {
                    if (zakazivanje.getClan().getId().equals(c.getId())) {
                        throw new Exception("Nije moguce obrisati clana");
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
