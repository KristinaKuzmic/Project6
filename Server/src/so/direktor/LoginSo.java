/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.direktor;

import controller.Controller;
import domain.AbstractDomainObject;
import domain.Direktor;
import java.io.IOException;
import java.sql.SQLException;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class LoginSo extends AbstractOperations {

    Direktor direktor;

    public Direktor getDirektor() {
        return direktor;
    }
    

    public LoginSo() throws IOException, SQLException, Exception {
        super();
    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if (!(object instanceof Direktor)) {
            throw new Exception("Greška, direktor ne postoji u bazi.");
        } else {
            System.out.println("Nađen direktor.");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        direktor = (Direktor) broker.selectOne((Direktor) object);
        Controller.getInstance().add(direktor);
    }

}
