/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Clan;
import domain.Direktor;
import domain.Predavac;
import domain.Termin;
import forms.clan.ClanForm;
import forms.clan.PretraziClanaForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kristina
 */
public class Controller {
    private static Controller instance;
    private Direktor direktor;
    private Predavac predavac;
    private Termin termin;
    private Clan clan;
    private String imeClana;
    private List<String> vremeTermina;
    private List<Termin> termini;
    private ClanForm cf;
    private PretraziClanaForm pcf;

    private Controller() {
        vremeTermina=new ArrayList<>();
        termini=new ArrayList<>();
        vremeTermina.add("10:00");
        vremeTermina.add("12:00");
        vremeTermina.add("14:00");
        vremeTermina.add("16:00");
        vremeTermina.add("18:00");
        vremeTermina.add("20:00");
    }

    public static Controller getInstance() {
        if(instance==null)
            instance=new Controller();
        return instance;
    }

    public String getImeClana() {
        return imeClana;
    }

    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    public void setCf(ClanForm cf) {
        this.cf = cf;
    }

    public void setPcf(PretraziClanaForm pcf) {
        this.pcf = pcf;
    }

    public ClanForm getCf() {
        return cf;
    }

    public PretraziClanaForm getPcf() {
        return pcf;
    }
    
    

    public List<String> getVremeTermina() {
        return vremeTermina;
    }

    public void setVremeTermina(List<String> vremeTermina) {
        this.vremeTermina = vremeTermina;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }
    
    

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }
    

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }


    public Direktor getDirektor() {
        return direktor;
    }

    public void setDirektor(Direktor direktor) {
        this.direktor = direktor;
    }

    public void add(Termin termin) {
        termini.add(termin);
    }

    public void izbaciSveTermine(){
        for (int i = 0; i < termini.size(); i++) {
            termini.remove(i);
        }
    }

    public void remove(int red) {
        termini.remove(red);
    }
    
}
