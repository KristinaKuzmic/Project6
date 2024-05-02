/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristina
 */
public abstract class AbstractDomainObject {
    
    public abstract String nazivTabele();

    public abstract String alijas();

    public abstract String join();

    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;

    public abstract String koloneZaInsert();

    public abstract String vrednostZaPrimarniKljuc();

    public abstract String vrednostiZaInsert();

    public abstract String vrednostiZaUpdate();

    public abstract String uslov();
    
    public abstract String where();
    
    public abstract AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException;
    
    public abstract String whereSelect();
    
}
