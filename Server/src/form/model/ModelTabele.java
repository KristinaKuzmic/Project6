/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import controller.Controller;
import domain.Direktor;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class ModelTabele extends AbstractTableModel implements Runnable{

    private List<Direktor> direktori;

    public ModelTabele() {
        this.direktori = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (direktori == null) {
            return 0;
        }
        return direktori.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Direktor d = direktori.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getUsername();
            case 1:
                return d.getFirstName();
            case 2:
                return d.getLastName();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "username";
            case 1:
                return "ime";
            case 2:
                return "prezime";
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void run() {
        while (true) {
            direktori = Controller.getInstance().getDirektori();
            fireTableDataChanged();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ModelTabele.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
