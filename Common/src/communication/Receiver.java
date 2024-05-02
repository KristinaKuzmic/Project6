/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kristina
 */
public class Receiver implements Serializable{
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    public Object recieve(){
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (IOException ex) {
            //Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
