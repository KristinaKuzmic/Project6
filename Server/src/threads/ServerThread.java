/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import controller.Controller;
import domain.Direktor;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Kristina
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private List<HandlerClientThread> clients;

    public ServerThread() {
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            Properties properties=new Properties();
            properties.load(new FileInputStream("config/dbconfig.properties"));
            int port = Integer.parseInt(properties.getProperty("port"));
            serverSocket = new ServerSocket(port);
            System.out.println("Server je pokrenut, čeka se klijent...");
            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent je povezan!");
                HandlerClientThread hct = new HandlerClientThread(socket);
                clients.add(hct);
                hct.start();
            }
        } catch (IOException ex) {
            System.out.println("Server je zaustavljen");
            //Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //stopAllThreads();
    }

    public void stopAllThreads() {
        for (HandlerClientThread client : clients) {
            try {
                if(client.getSocket()!=null && !client.getSocket().isClosed())
                client.getSocket().close();
            } catch (IOException ex) {
                System.out.println("Klijenti soketi su zatvoreni");
                //  Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
            List<Direktor> direktori = Controller.getInstance().getDirektori();
            for (int i = 0; i < direktori.size(); i++) {
                direktori.remove(i);
            }
            stopAllThreads();
        } catch (IOException ex) {
            System.out.println("Izbaceni su svi prijavljeni");
            //Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
