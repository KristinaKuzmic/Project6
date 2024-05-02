/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zakazivanje;

import domain.AbstractDomainObject;
import domain.Clan;
import domain.Zakazivanje;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class GetZakazivanjaSO extends AbstractOperations {

    private List<Zakazivanje> zakazivanja;

    public List<Zakazivanje> getZakazivanja() {
        return zakazivanja;
    }
    

    public GetZakazivanjaSO() throws Exception {
        super();
    }

    public GetZakazivanjaSO(List<Zakazivanje> zakazivanja) throws Exception {
        this.zakazivanja = zakazivanja;
    }

    @Override
    protected void preconditions(Object object) throws Exception {
//        if (object==null ||!(object instanceof Zakazivanje)) {
//            throw new Exception("Greška,zakazivanje ne postoji u bazi.");
//        } else {
//            System.out.println("Nadjeno zakazivanje.");
//        }
//
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        System.out.println("///");
        zakazivanja = (ArrayList<Zakazivanje>) (ArrayList<?>) broker.selectAll((AbstractDomainObject) object);
    }

}
