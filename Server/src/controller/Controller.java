/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Clan;
import domain.Direktor;
import domain.Grupa;
import domain.Kurs;
import domain.Predavac;
import domain.Termin;
import domain.Zakazivanje;
import java.util.ArrayList;
import java.util.List;
import so.clan.AddClanSo;
import so.clan.DeleteClanSO;
import so.clan.GetClanSO;
import so.clan.UpdateClanSO;
import so.direktor.LoginSo;
import so.grupa.UcitajListuGrupaSO;
import so.kurs.AddKursSO;
import so.predavac.AddPredavacSO;
import so.predavac.DeletePredavacSO;
import so.predavac.GetPredavacSO;
import so.termin.AddTerminSO;
import so.termin.AddTermine;
import so.termin.GetTerminSO;
import so.termin.UpdateTerminSO;
import so.zakazivanje.AddZakazivanjeSO;
import so.zakazivanje.GetZakazivanjaSO;

/**
 *
 * @author Kristina
 */
public class Controller {

    private static Controller instance;
    private List<Direktor> direktori;

    private Controller() {
        direktori = new ArrayList<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<Direktor> getDirektori() {
        return direktori;
    }

    public void remove(Direktor d) {
        direktori.remove(d);
    }

    public void add(Direktor d) {
        System.out.println("dodat je diretor");
        direktori.add(d);
        System.out.println(direktori);
    }

    public boolean odjava(Direktor d) {
        for (Direktor direktor : direktori) {
            if (direktor.equals(d)) {
                direktori.remove(direktor);
                return true;
            }
        }
        return false;
    }

    public boolean prijava(Direktor direktor) {
        for (Direktor direktor1 : direktori) {
            if (direktor.equals(direktor1)) {
                return false;
            }
        }
        return true;

    }

    public Direktor login(Direktor direktor) throws Exception {
        LoginSo login = new LoginSo();
        System.out.println(direktor.toString());
        login.execute(direktor);
        System.out.println(direktor.toString());
        return login.getDirektor();
    }

    public List<Grupa> vratiGrupe() throws Exception {
        UcitajListuGrupaSO ucitajListuGrupaSO = new UcitajListuGrupaSO();
        ucitajListuGrupaSO.execute(new Grupa());
        return ucitajListuGrupaSO.getGrupe();
    }

    public void addClan(Clan clan) throws Exception {
        AddClanSo addClanSo = new AddClanSo();
        addClanSo.execute(clan);
    }

    public void updateClan(Clan clan) throws Exception {
        UpdateClanSO updateClanSO = new UpdateClanSO();
        updateClanSO.execute(clan);
    }

    public List<Clan> vratiClanove(String ime) throws Exception {
        GetClanSO getClanSO = new GetClanSO();
        getClanSO.execute(new Clan());
        return vratiClanove(getClanSO.getClanovi(), ime);
    }

    public List<Clan> vratiClanove(List<Clan> clanovi, String ime) {
        List<Clan> cc = new ArrayList<>();
        System.out.println(clanovi);
        System.out.println(ime);
        for (Clan clan : clanovi) {
            if (clan.getIme().equals(ime)) {
                cc.add(clan);
            }
        }
        return cc;
    }

    public void addPredavac(Predavac predavac) throws Exception {
        AddPredavacSO addPredavacSO = new AddPredavacSO();
        addPredavacSO.execute(predavac);
    }

    public void addKurs(Kurs kurs) throws Exception {
        AddKursSO addKursSO = new AddKursSO();
        addKursSO.execute(kurs);
    }

    public List<Predavac> vratiPredavace(String ime) throws Exception {
        GetPredavacSO getPredavacSO = new GetPredavacSO();
        getPredavacSO.execute(new Predavac());
        return vratiPredavace(getPredavacSO.getPredavci(), ime);
    }

    public List<Predavac> vratiPredavace(List<Predavac> predavaci, String ime) {
        List<Predavac> pp = new ArrayList<>();
        for (Predavac predavac : predavaci) {
            if (predavac.getIme().equals(ime)) {
                pp.add(predavac);
            }
        }
        return pp;
    }

    public List<Termin> addTermine(List<Termin> termini) throws Exception {
        AddTermine addTermine = new AddTermine();
        addTermine.execute(termini);
        return addTermine.getTermini();
    }

    public List<Termin> vratiTermine(Grupa grupa) throws Exception {
        GetTerminSO getTerminSO = new GetTerminSO();
        getTerminSO.execute(new Termin());
        return vratiTermine(getTerminSO.getTermini(), grupa);
    }

    public List<Termin> vratiTermine(List<Termin> termini, Grupa grupa) {
        List<Termin> tt = new ArrayList<>();
        for (Termin termin : termini) {
            if (termin.getGrupa().equals(grupa)) {
                tt.add(termin);
            }
        }
        return tt;
    }

    public List<Zakazivanje> vratiZakazivanja(Clan clan) throws Exception {
        GetZakazivanjaSO getZakazivanjaSO = new GetZakazivanjaSO();
        getZakazivanjaSO.execute(new Zakazivanje());
        return vratiZakazivanja(getZakazivanjaSO.getZakazivanja(), clan);
    }

    public List<Zakazivanje> vratiZakazivanja(List<Zakazivanje> zakazivanja, Clan clan) {
        List<Zakazivanje> zz = new ArrayList<>();
        for (Zakazivanje zakazivanje : zakazivanja) {
            if (zakazivanje.getClan().equals(clan)) {
                zz.add(zakazivanje);
            }
        }
        return zz;
    }

    public void addZakzivanja(List<Zakazivanje> zakazivanja) throws Exception {
        AddZakazivanjeSO addZakazivanjeSO = new AddZakazivanjeSO();
        addZakazivanjeSO.execute(zakazivanja);

    }

    public Long addTermin(Termin termin) throws Exception {
        AddTerminSO addTerminSO = new AddTerminSO();
        addTerminSO.execute(termin);
        return addTerminSO.getKljuc();
    }

    public void deleteClan(Clan clan) throws Exception {
        DeleteClanSO deleteClanSO=new DeleteClanSO();
        deleteClanSO.execute(clan);
    }

    public void deletePredavac(Predavac predavac) throws Exception {
        DeletePredavacSO deletePredavacSO=new DeletePredavacSO();
        deletePredavacSO.execute(predavac);
    }

    public void updateTermin(Termin termin) throws Exception {
        UpdateTerminSO updateTerminSO=new UpdateTerminSO();
        updateTerminSO.execute(termin);
    }

    public List<Termin> getTermine() throws Exception {
        GetTerminSO getTerminSO=new GetTerminSO();
        getTerminSO.execute(new Termin());
        return getTerminSO.getTermini();
    }

    public List<Clan> getClanovi() throws Exception {
        GetClanSO getClanSO=new GetClanSO();
        getClanSO.execute(new Clan());
        return getClanSO.getClanovi();
    }

    public List<Predavac> getPredavaci() throws Exception {
        GetPredavacSO getPredavacSO=new GetPredavacSO();
        getPredavacSO.execute(new Predavac());
        return getPredavacSO.getPredavci();
    }

    public List<Clan> getClanPoTerminu(Termin termin) throws Exception {
        System.out.println(termin);
        GetZakazivanjaSO getZakazivanjaSO=new GetZakazivanjaSO();
        System.out.println("exe");
        getZakazivanjaSO.execute(new Zakazivanje());
        return getClanPoTerminu(getZakazivanjaSO.getZakazivanja(),termin);
    }
    
    public List<Clan> getClanPoTerminu( List<Zakazivanje> za, Termin termin) {
        System.out.println(za);
        List<Clan> zz = new ArrayList<>();
        for (Zakazivanje c : za) {
            if (c.getTermin().getId().equals(termin.getId())) {
                System.out.println("u");
                zz.add(c.getClan());
                System.out.println(c.getClan());
            }
        }
        return zz;
    }
}
