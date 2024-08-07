/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.predavac;

import db.DBBroker;
import db.DBConnection;
import domain.AbstractDomainObject;
import domain.Predavac;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristina
 */
public class AddPredavacSOTest {

    DBBroker broker;
    AddPredavacSO addPredavacSO;
    int velicinaPre;
    int velicinaPosle;
    Predavac predavac;

    public AddPredavacSOTest() {
        try {
            broker = new DBBroker(DBConnection.getInstance().pop());
        } catch (Exception ex) {
            System.out.println("");
        }

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            List<Predavac> predavaci = (ArrayList<Predavac>) (ArrayList<?>) broker.selectAll(new Predavac());
            velicinaPre = predavaci.size();
            System.out.println("Velicina liste pre dodavanja " + velicinaPre);

            predavac = new Predavac();
            predavac.setIme("Test");
            predavac.setPrezime("Test");

            addPredavacSO = new AddPredavacSO();

            addPredavacSO.preconditions(predavac);
            broker.insert(predavac);
            //addPredavacSO.executeOperation(predavac);

            List<Predavac> predavaciPosle = (ArrayList<Predavac>) (ArrayList<?>) broker.selectAll(new Predavac());
            velicinaPosle = predavaciPosle.size();

            System.out.println("Velicina liste nakon dodavanja "+ velicinaPosle);

        } catch (SQLException ex) {
            System.out.println("");
        } catch (Exception ex) {
            Logger.getLogger(AddPredavacSOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @After
    public void tearDown() {
        predavac = null;
        addPredavacSO = null;
    }

    @Test
    public void test() throws Exception {
        if (velicinaPosle > velicinaPre) {
            System.out.println("Velicina posle dodavanja je veca");
        } else {
            System.out.println("Velicina pre dodavanja je veca");
        }
        Assert.assertEquals(velicinaPre + 1, velicinaPosle);
    }

}
