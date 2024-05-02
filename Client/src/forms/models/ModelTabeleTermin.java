/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import communication.Communication;
import constants.ClientConstants;
import domain.Grupa;
import domain.Termin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class ModelTabeleTermin extends AbstractTableModel {

    List<Termin> termini;

    public ModelTabeleTermin(List<Termin> termini) {
        this.termini = termini;
    }

    @Override
    public int getRowCount() {
        if (termini == null) {
            return 0;
        }
        return termini.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Termin t = termini.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getGrupa();
            case 1:
                return ClientConstants.SDFDATUM.format(t.getDatum());
            case 2:
                return t.getVreme();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "grupa";
            case 1:
                return "datum";
            case 2:
                return "vreme";
            default:
                throw new AssertionError();
        }
    }

    public void add(Termin termin) {
        termini.add(termin);
        fireTableDataChanged();
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void osveziFormu(Grupa grupa) throws Exception {
        termini=Communication.getInstance().getTermini(grupa);
        fireTableDataChanged();
    }

    public void obrisiListu(){
        termini=new ArrayList<>();
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        termini.remove(red);
        fireTableDataChanged();
    }

    public boolean postoji(Termin termin) {
        if(termini.contains(termin))
            return true;
        return false;
    }
    
}
