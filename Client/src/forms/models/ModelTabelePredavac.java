/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import communication.Communication;
import domain.Predavac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class ModelTabelePredavac extends AbstractTableModel{
    
    List<Predavac> predavaci;

    public ModelTabelePredavac(List<Predavac> predavaci) {
        this.predavaci = predavaci;
    }

    public List<Predavac> getPredavaci() {
        return predavaci;
    }
    
    
    
    
    
    @Override
    public int getRowCount() {
        if(predavaci==null)
            return 0;
        return predavaci.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predavac p=predavaci.get(rowIndex);
        switch (columnIndex) {
            case 0:return p.getIme();
            case 1:return p.getPrezime();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:return "ime";
            case 1:return "prezime";
            default:
                throw new AssertionError();
        }
    }

    public void osveziFormu(String ime) throws Exception {
        predavaci=Communication.getInstance().getPredavac(ime);
        fireTableDataChanged();
    }
    
}
