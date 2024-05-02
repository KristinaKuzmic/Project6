/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import communication.Communication;
import domain.Clan;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class ModelTabeleClan extends AbstractTableModel {

    private List<Clan> clanovi;

    public List<Clan> getClanovi() {
        return clanovi;
    }
    

    public ModelTabeleClan(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    @Override
    public int getRowCount() {
        if (clanovi == null) {
            return 0;
        }
        return clanovi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan c = clanovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getIme();
            case 1:
                return c.getPrezime();
            case 2:
                return c.getJMBG();
            case 3:
                return c.getGrupa();
            default:
                throw new AssertionError();
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ime";
            case 1:
                return "prezime";
            case 2:
                return "JMBG";
            case 3:
                return "grupa";
            default:
                throw new AssertionError();
        }
    }
    
    public void osvezi(String ime) throws Exception{
         clanovi = Communication.getInstance().vratiClanove(ime);
         fireTableDataChanged();
    }

}
