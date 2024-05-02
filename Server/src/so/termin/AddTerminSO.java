/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.termin;

import domain.AbstractDomainObject;
import domain.Termin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class AddTerminSO extends AbstractOperations {

    Long kljuc;

    public Long getKljuc() {
        return kljuc;
    }

    public AddTerminSO() throws Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (!(object instanceof Termin)) {
            throw new Exception("Greška,termin ne postoji u bazi.");
        } else {
            System.out.println("Nadjen kurs.");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        PreparedStatement br = broker.insert((AbstractDomainObject) object);
        ResultSet rs = br.getGeneratedKeys();
        while (rs.next()) {
            kljuc = rs.getLong(1);
        }

    }

}
