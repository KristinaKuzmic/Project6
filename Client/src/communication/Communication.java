/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import contants.Operation;
import domain.Clan;
import domain.Direktor;
import domain.Grupa;
import domain.Kurs;
import domain.Predavac;
import domain.Termin;
import domain.Zakazivanje;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Kristina
 */
public class Communication {

    private static Communication instance;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private Communication() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\Kristina\\Documents\\NetBeansProjects\\Seminarski\\Server\\config/dbconfig.properties"));
        int port = Integer.parseInt(properties.getProperty("port"));
        socket = new Socket("127.0.0.1", port);
        sender = new Sender(socket);
        receiver = new Receiver(socket);

    }

    public static Communication getInstance() throws Exception {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Direktor login(Direktor direktor) throws Exception {
        Request request = new Request(direktor, Operation.PRIJAVA);
        sender.send(request);

        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (Direktor) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public Status kreirajClana(Clan clan) throws Exception {
        Request request = new Request(clan, Operation.KREIRAJ_CLANA);
        sender.send(request);

        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return response.getStatus();
        } else {
            throw response.getException();
        }
    }

    public List<Grupa> vratiGrupe() throws Exception {
        Request request = new Request(null, Operation.VRATI_GRUPE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Grupa>) response.getResponse();
        } else {
            throw response.getException();
        }

    }

    public Status updateClana(Clan clan) throws Exception {
        Request request = new Request(clan, Operation.UPDATE_CLAN);
        sender.send(request);

        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return response.getStatus();
        } else {
            throw response.getException();
        }

    }

    public Status logout(Direktor direktor) throws Exception {
        Request request = new Request(direktor, Operation.LOGOUT);
        sender.send(request);

        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return response.getStatus();
        } else {
            throw response.getException();
        }
    }

    public List<Clan> vratiClanove(String ime) throws Exception {
        Request request = new Request(ime, Operation.VRATI_CLANOVE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Clan>) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public void addPredavac(Predavac predavac) throws Exception {
        Request request = new Request(predavac, Operation.ADD_PREDAVAC);
        sender.send(request);

        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return;
        } else {
            throw response.getException();
        }
    }

    public void addKurs(Kurs kurs) throws Exception {
        Request request = new Request(kurs, Operation.ADD_KURS);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return;
        } else {
            throw response.getException();
        }
    }

    public List<Predavac> getPredavac(String ime) throws Exception {
        Request request = new Request(ime, Operation.GET_PREDAVACE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Predavac>) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public List<Termin> addTermine(List<Termin> termini) throws Exception {
        Request request = new Request(termini, Operation.ADD_TERMINE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Termin>) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public List<Termin> getTermini(Grupa grupa) throws Exception {
        Request request = new Request(grupa, Operation.GET_TERMINE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Termin>) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public List<Zakazivanje> getZakazivanja(Clan clan) throws Exception {
        Request request = new Request(clan, Operation.GET_ZAKAZIVANJA);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Zakazivanje>) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public void addZakazivanje(List<Zakazivanje> zakazivanja) throws Exception {
        Request request = new Request(zakazivanja, Operation.ADD_ZAKAZIVANJA);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return;
        } else {
            throw response.getException();
        }
    }

    public Long addTermin(Termin termin) throws Exception {
        Request request = new Request(termin, Operation.ADD_TERMIN);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (Long) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public void deleteClan(Clan clan) throws Exception {
        Request request = new Request(clan, Operation.DELETE_CLAN);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return;
        } else {
            throw response.getException();
        }
    }

    public void deletePredavac(Predavac predavac) throws Exception {
        Request request = new Request(predavac, Operation.DELETE_PREDAVAC);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return;
        } else {
            throw response.getException();
        }

    }

    public void updateTermin(Termin termin) throws Exception {
        Request request = new Request(termin, Operation.UPDATE_TERMIN);
        sender.send(request);

        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return;
        } else {
            throw response.getException();
        }

    }

    public List<Termin> getTermini() throws Exception {
        Request request = new Request(null, Operation.GET_SVE_TERMINE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Termin>) response.getResponse();
        } else {
            throw response.getException();
        }

    }

    public List<Clan> getClanovi() throws Exception {
        Request request = new Request(null, Operation.GET_SVE_CLANOVE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Clan>) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public List<Predavac> getPredavace() throws Exception {
        Request request = new Request(null, Operation.GET_SVE_PREDAVACE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Predavac>) response.getResponse();
        } else {
            throw response.getException();
        }
    }

    public List<Clan> vratiClanove1(Termin termin) throws Exception {
        System.out.println("posao zahtev");
        System.out.println(termin);
        Request request = new Request(termin, Operation.GET_CLANOVE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getStatus() == Status.SUCCESS) {
            return (List<Clan>) response.getResponse();
        } else {
            throw response.getException();
        }
    }
}
