/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms.zakazivanje;

import communication.Communication;
import constants.ClientConstants;
import controller.Controller;
import domain.Clan;
import domain.Grupa;
import domain.Termin;
import domain.Zakazivanje;
import forms.models.ModelTabeleZakazivanje;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kristina
 */
public class AddZakazivanjeForm extends javax.swing.JDialog {

    private ZakazivanjeForm zf;

    /**
     * Creates new form AddZakazivanjeForm
     */
    public AddZakazivanjeForm(java.awt.Frame parent, boolean modal, ZakazivanjeForm zf) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.zf = zf;
        popuniCombo();
        popuniFormu();
        popuniTabelu();

        //popuniTermine(Communication.getInstance());
        // popuniVreme();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbGrupe = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnZakazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cmbTermin = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtNapomena = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ime");

        jLabel2.setText("prezime");

        jLabel3.setText("grupa");

        cmbGrupe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGrupe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGrupeItemStateChanged(evt);
            }
        });

        jLabel4.setText("termin");

        btnZakazi.setText("zakazi");
        btnZakazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnSacuvaj.setText("sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jButton1.setText("obrisi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbTermin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("napomena");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnZakazi))
                                    .addComponent(txtIme)
                                    .addComponent(txtPrezime)
                                    .addComponent(cmbGrupe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbTermin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnSacuvaj)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNapomena)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTermin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZakazi)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSacuvaj)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            ModelTabeleZakazivanje mtz = (ModelTabeleZakazivanje) jTable1.getModel();
            List<Zakazivanje> zakazivanja = mtz.getZakazivanja();
            if (zakazivanja.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti zakazivanja","", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Communication.getInstance().addZakazivanje(zakazivanja);
            zf.osveziFormu(Controller.getInstance().getClan());
            JOptionPane.showMessageDialog(this, "Zakazivanja su uspesno sacuvana");
            int odgovor = JOptionPane.showConfirmDialog(this, "Da li zelite da uneste jos zakazivanja?",
                    "UNOS ZAKAZIVANJA", JOptionPane.YES_NO_OPTION);
            if (odgovor == JOptionPane.YES_OPTION) {
                cmbTermin.setSelectedIndex(-1);
                txtNapomena.setText("");
                mtz.obrisiListu();
            } else {
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(AddZakazivanjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnZakaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZakaziActionPerformed

        try {
            Zakazivanje zakazivanje = new Zakazivanje();
            Grupa grupa = (Grupa) cmbGrupe.getSelectedItem();
            Termin termin = (Termin) cmbTermin.getSelectedItem();
            String napomena = txtNapomena.getText().trim();
            if (napomena.isEmpty() || cmbGrupe.getSelectedItem() == null || cmbTermin.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Unesite sva potrebna polja","", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (napomena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite napomenu, ako nema napomene, unesite '/'","", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Controller.getInstance().getClan().setGrupa(grupa);
            zakazivanje.setNapomena(napomena);
            zakazivanje.setClan(Controller.getInstance().getClan());
            zakazivanje.setGrupa(grupa);
            zakazivanje.setTermin(termin);
            ModelTabeleZakazivanje mtz = (ModelTabeleZakazivanje) jTable1.getModel();
            if (!mtz.postoji(zakazivanje)) {
                mtz.add(zakazivanje);
            } else {
                JOptionPane.showMessageDialog(this, "Vec ste uneli ovo zakazivanje","", JOptionPane.ERROR_MESSAGE);
            }
            //cmbGrupe.setEnabled(false);
            //popuniTermine(Communication.getInstance().getTermini(grupa));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(AddZakazivanjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnZakaziActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int red = jTable1.getSelectedRow();
        if (red != -1) {
            ModelTabeleZakazivanje mtz = (ModelTabeleZakazivanje) jTable1.getModel();
            mtz.obrisi(red);
            //Controller.getInstance().remove(red);
            JOptionPane.showMessageDialog(this, "Uspesno obrisano");
        } else {
            JOptionPane.showMessageDialog(this, "Morate izabrati red","", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbGrupeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGrupeItemStateChanged
        try {
            // TODO add your handling code here:
            Grupa grupa = (Grupa) cmbGrupe.getSelectedItem();
            List<Termin> termini = Communication.getInstance().getTermini(grupa);
            popuniTermine(termini);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(AddZakazivanjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbGrupeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnZakazi;
    private javax.swing.JComboBox cmbGrupe;
    private javax.swing.JComboBox cmbTermin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtNapomena;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniCombo() {

        try {
            List<Grupa> grupe = Communication.getInstance().vratiGrupe();
            cmbGrupe.removeAllItems();
            for (Grupa grupa : grupe) {
                cmbGrupe.addItem(grupa);
            }
            cmbGrupe.setSelectedIndex(-1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(AddZakazivanjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniTermine(List<Termin> termini) {
        try {
            //List<Termin> termini = Communication.getInstance().getTermini();
            cmbTermin.removeAllItems();
            for (Termin termin : termini) {
                cmbTermin.addItem(termin);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(AddZakazivanjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void popuniFormu() throws Exception {
        Clan clan = Controller.getInstance().getClan();
        txtIme.setText(clan.getIme());
        txtPrezime.setText(clan.getPrezime());
        System.out.println(clan.getGrupa().getId());
        System.out.println(clan.getGrupa());
        Grupa grupa = clan.getGrupa();
        //if (!(grupa.equals(null)) && grupa.getNaziv() != null) {
        //  System.out.println("usao u if kako???");
        cmbGrupe.setSelectedItem(clan.getGrupa());
        cmbGrupe.setEnabled(false);

        List<Termin> termini = Communication.getInstance().getTermini(grupa);
        if (termini.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nazalost ne postoje uneti termini za ovu grupu..","", JOptionPane.ERROR_MESSAGE);
        }
        popuniTermine(termini);
        //} else {
        //popuniTermine(Communication.getInstance().getTermini());
        //}

        txtIme.setEnabled(false);
        txtPrezime.setEnabled(false);

    }

    private void popuniTabelu() {
        ModelTabeleZakazivanje mtz = new ModelTabeleZakazivanje(new ArrayList<>());
        jTable1.setModel(mtz);
    }

}
