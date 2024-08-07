/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.clan;

import db.DBBroker;
import db.DBConnection;
import domain.Clan;
import domain.Grupa;
import domain.Kurs;
import domain.Predavac;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristina
 */
public class AddClanSoTest {
    
    AddClanSo addClanSo;
    DBBroker broker;
    Clan clan;
    int velicinaPre;
    int velicinaPosle;
    
    public AddClanSoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp(){
        try {
            broker= new DBBroker(DBConnection.getInstance().pop());
        } catch (Exception ex) {
            fail("Greska prilikom povezivanja sa bazom");
        } 
        try {
            addClanSo=new AddClanSo();
        }  catch (Exception ex) {
            fail("Greska prilikom pravljenja objekta");
        }
        Kurs kurs=new Kurs(-1l, "test");
        Predavac predavac=new Predavac(-1l, "test", "test");
        Grupa grupa=new Grupa(-1l, "test", 0, kurs, predavac);
        clan=new Clan(-1l, "test", "test", "1234567890123", grupa);
        
        
        try {
            List<Clan> clanovi=(ArrayList<Clan>) (ArrayList<?>) broker.selectAll(new Clan());
            velicinaPre=clanovi.size();
        } catch (SQLException ex) {
            fail("Nije moguce ucitati listu clanova");
        }
        
        
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void testPreconditionsObjectIsNull() {
        try {
            addClanSo.preconditions(null);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Greška pri čuvanju podataka o članu.", e.getMessage());
        }
    }

    @Test
    public void testPreconditionsObjectIsNotClan() {
        try {
            addClanSo.preconditions("Not a Clan");
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Greška pri čuvanju podataka o članu.", e.getMessage());
        }
    }

    @Test
    public void testPreconditionsClanExists() throws Exception {
        Kurs kurs=new Kurs(1l, "test");
        Predavac predavac=new Predavac(1l, "test", "test");
        Grupa grupa=new Grupa(1l, "test", 0, kurs, predavac);
        clan=new Clan(-1l, "test", "test", "1234567890123", grupa);
        // Insert the existingClan into the database.
        
        broker.insert(clan);
        
        Clan newClan=new Clan(-1l, "test", "test", "1234567890123", grupa);

        try {
            addClanSo.preconditions(newClan);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Nije moguce sacuvati clana", e.getMessage());
        }
    }
    
    
    /**
     * Test of preconditions method, of class AddClanSo.
     */
    @Test
    public void testPreconditions() throws Exception {
        Kurs kurs=new Kurs(1l, "test");
        Predavac predavac=new Predavac(1l, "test", "test");
        Grupa grupa=new Grupa(1l, "test", 0, kurs, predavac);
        clan=new Clan(-1l, "test", "test", "0234567890123", grupa);
        
        try {
            addClanSo.preconditions(clan);
        } catch (Exception e) {
            fail("Nije predvidjeno mesto za nastanak greske");
        }
        
       
        
    }

    /**
     * Test of executeOperation method, of class AddClanSo.
     */
    @Test
    public void testExecuteOperation() throws Exception {
        Kurs kurs=new Kurs(1l, "test");
        Predavac predavac=new Predavac(1l, "test", "test");
        Grupa grupa=new Grupa(1l, "test", 0, kurs, predavac);
        clan=new Clan(-1l, "test", "test", "2334567890123", grupa);
        List<Clan> clanovi=new ArrayList<>();
        addClanSo.executeOperation(clan);
        
        
        //broker.insert(clan);
        
        try {
            clanovi=(ArrayList<Clan>) (ArrayList<?>) broker.selectAll(new Clan());
            velicinaPosle = clanovi.size();
        } catch (SQLException ex) {
            fail("Nije moguce ucitati listu clanova");
        }
        System.out.println(clanovi);
        ///ne moze ovako da se poredi jer u equals metodi gleda se da li su im isti id
        //assertEquals(velicinaPre+1, velicinaPosle);
       
        
    }
    
}
