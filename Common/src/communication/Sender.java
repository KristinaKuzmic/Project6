/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import exception.MyException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kristina
 */
public class Sender implements Serializable{
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }
    public void send(Object object) throws Exception{
        try {
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (IOException ex) {
            throw new MyException("Server je zatvoren!");
           // Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
