/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.grupa;

import domain.AbstractDomainObject;
import domain.Direktor;
import domain.Grupa;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class UcitajListuGrupaSO extends AbstractOperations{
    private List<Grupa> grupe;

    public List<Grupa> getGrupe() {
        return grupe;
    }
    

    public UcitajListuGrupaSO() throws IOException, SQLException, Exception {
        super();
    }
    
    @Override
    protected void preconditions(Object object) throws Exception {
        if (object==null || !(object instanceof Grupa)) {
            throw new Exception("Greška, grupa ne postoji u bazi.");
        } else {
            System.out.println("Nadjena grupa.");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        grupe=(List<Grupa>)(ArrayList<?>)broker.selectAll((AbstractDomainObject) object);
        
    }
    
}
