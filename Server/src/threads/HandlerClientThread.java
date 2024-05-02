/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import communication.Status;
import contants.Operation;
import controller.Controller;
import domain.Clan;
import domain.Direktor;
import domain.Grupa;
import domain.Kurs;
import domain.Predavac;
import domain.Termin;
import domain.Zakazivanje;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Kristina
 */
public class HandlerClientThread extends Thread {
    
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    
    public HandlerClientThread(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    public Socket getSocket() {
        return socket;
    }
    
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Request request = (Request) receiver.recieve();
                Response response = handleRequest(request);
                sender.send(response);
            }
        } catch (Exception e) {
            System.out.println("/////");
        }
    }
    
    private Response handleRequest(Request request) {
        Response response = new Response(null, null, Status.SUCCESS);
        try {
            switch (request.getOperation()) {
                case Operation.PRIJAVA:
                    boolean prijava = Controller.getInstance().prijava((Direktor) request.getArgument());
                    Direktor d = (Direktor) request.getArgument();
                    if (prijava) {
                        Direktor direktor = (Direktor) Controller.getInstance().login(d);
                        response.setResponse(d);
                        response.setStatus(Status.SUCCESS);
                        
                    } else {
                        response.setResponse(null);
                        response.setStatus(Status.ERROR);
                        response.setException(new Exception("Korisnik je već ulogovan."));
                        
                    }
                    break;
                case Operation.VRATI_GRUPE:
                    List<Grupa> grupe = Controller.getInstance().vratiGrupe();
                    response.setResponse(grupe);
                    break;
                case Operation.KREIRAJ_CLANA:
                    Controller.getInstance().addClan((Clan) request.getArgument());
                    break;
                case Operation.UPDATE_CLAN:
                    Controller.getInstance().updateClan((Clan) request.getArgument());
                    break;
                case Operation.LOGOUT:
                    Controller.getInstance().odjava((Direktor) request.getArgument());
                    break;
                case Operation.VRATI_CLANOVE:
                    List<Clan> clanovi = Controller.getInstance().vratiClanove((String) request.getArgument());
                    response.setResponse(clanovi);
                    break;
                case Operation.ADD_PREDAVAC:
                    Controller.getInstance().addPredavac((Predavac) request.getArgument());
                    break;
                case Operation.ADD_KURS:
                    Controller.getInstance().addKurs((Kurs) request.getArgument());
                    break;
                case Operation.GET_PREDAVACE:
                    List<Predavac> predavaci = Controller.getInstance().vratiPredavace((String) request.getArgument());
                    response.setResponse(predavaci);
                    break;
                case Operation.ADD_TERMINE:
                    List<Termin> tt = Controller.getInstance().addTermine((List<Termin>) request.getArgument());
                    response.setResponse(tt);
                    break;
                case Operation.GET_TERMINE:
                    List<Termin> termini = Controller.getInstance().vratiTermine((Grupa) request.getArgument());
                    response.setResponse(termini);
                    break;
                case Operation.GET_ZAKAZIVANJA:
                    List<Zakazivanje> zakazivanja = Controller.getInstance().vratiZakazivanja((Clan) request.getArgument());
                    response.setResponse(zakazivanja);
                    break;
                case Operation.ADD_ZAKAZIVANJA:
                    Controller.getInstance().addZakzivanja((List<Zakazivanje>) request.getArgument());
                    break;
                case Operation.ADD_TERMIN:
                    Long kljuc = Controller.getInstance().addTermin((Termin) request.getArgument());
                    response.setResponse(kljuc);
                    break;
                case Operation.DELETE_CLAN:
                    Controller.getInstance().deleteClan((Clan) request.getArgument());
                    break;
                case Operation.DELETE_PREDAVAC:
                    Controller.getInstance().deletePredavac((Predavac)request.getArgument());
                    break;
                case Operation.UPDATE_TERMIN:
                    Controller.getInstance().updateTermin((Termin)request.getArgument());
                    break;
                case Operation.GET_SVE_TERMINE:
                    List<Termin> t=Controller.getInstance().getTermine();
                    response.setResponse(t);
                    break;
                case Operation.GET_SVE_CLANOVE:
                    List<Clan> c=Controller.getInstance().getClanovi();
                    response.setResponse(c);
                    break;
                case Operation.GET_SVE_PREDAVACE:
                    List<Predavac> pred=Controller.getInstance().getPredavaci();
                    response.setResponse(pred);
                    break;
                case Operation.GET_CLANOVE:
                    List<Clan> cccc=Controller.getInstance().getClanPoTerminu((Termin)request.getArgument());
                    System.out.println("vratio"
                            + "");
                    System.out.println(cccc);
                    response.setResponse(cccc);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setException(e);
            response.setStatus(Status.ERROR);
            
        }
        return response;
    }
    
}
