/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALaa
 */
public class ModelImpl extends UnicastRemoteObject implements ModelInt{
    Controller c;
   public ModelImpl()throws RemoteException{
       
    }

    @Override
    public void receive(String msg) throws RemoteException {
         try {  
            c=new Controller();
        } catch (RemoteException ex) {
            Logger.getLogger(ModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.displayMsg(msg);
    }
    
}
