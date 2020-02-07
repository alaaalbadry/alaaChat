/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import chatserver2.ChatServerInt;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelImpl;
import view.View;

/**
 *
 * @author ALaa
 */
public class Controller {
    ModelImpl m;
    public ChatServerInt server;
    View v;
   public  Controller()throws RemoteException {
      // m=new ModelImpl();
       //System.out.println("ModelObj created");
        Registry reg;
        try {
            reg = LocateRegistry.getRegistry("127.0.0.1");
            server = (ChatServerInt) reg.lookup("ChatService");
             System.out.println("7asal lookup");
           // server.register(m);
             System.out.println("7asal register");
        } catch (RemoteException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void displayMsg(String msg){
        v.display(msg);
    }
    public void sendMsg(String msg){
        try {
            m=new ModelImpl();
            server.register(m);
            server.tellOthers(msg);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
