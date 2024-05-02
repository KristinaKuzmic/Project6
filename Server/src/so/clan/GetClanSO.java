/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import domain.AbstractDomainObject;
import domain.Clan;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractOperations;

/**
 *
 * @author Kristina
 */
public class GetClanSO extends AbstractOperations {

    private List<Clan> clanovi;

    public GetClanSO() throws Exception {
        super();

    }

    @Override
    protected void preconditions(Object object) throws Exception {
        if(object==null || !(object instanceof Clan)){
            throw new Exception("Greska, clan ne postoji u bazi!");
        }
        
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        clanovi = (ArrayList< Clan>) (ArrayList<?>) broker.selectAll((AbstractDomainObject) object);
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

}
