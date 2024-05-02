/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import communication.Communication;
import constants.ClientConstants;
import domain.Clan;
import domain.Zakazivanje;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class ModelTabeleZakazivanje extends AbstractTableModel {

    List<Zakazivanje> zakazivanja;

    public ModelTabeleZakazivanje(List<Zakazivanje> zakazivanja) {
        this.zakazivanja = zakazivanja;
    }

    @Override
    public int getRowCount() {
        if (zakazivanja == null) {
            return 0;
        }
        return zakazivanja.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakazivanje z = zakazivanja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ClientConstants.SDFDATUM.format(z.getTermin().getDatum());
            case 1:
               return z.getTermin().getVreme();
            case 2:
                return z.getGrupa();
            case 3:
                return z.getNapomena();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "datum";
            case 1:
                return "vreme";
            case 2:
                return "grupa";
            case 3:
                return "napomena";
            default:
                throw new AssertionError();
        }
    }
    
    public void add(Zakazivanje zakazivanje){
        zakazivanja.add(zakazivanje);
        fireTableDataChanged();
    }

    public List<Zakazivanje> getZakazivanja() {
        return zakazivanja;
    }
    
    public void obrisi(int red){
        zakazivanja.remove(red);
        fireTableDataChanged();
    }
    
    public void osveziTabelu(Clan clan) throws Exception{
        zakazivanja=Communication.getInstance().getZakazivanja(clan);
        fireTableDataChanged();
    }

    public boolean postoji(Zakazivanje zakazivanje) {
        if(zakazivanja.contains(zakazivanje))
            return true;
        return false;
    }

    public void obrisiListu() {
        zakazivanja=new ArrayList<>();
        fireTableDataChanged();
    }
    

}
