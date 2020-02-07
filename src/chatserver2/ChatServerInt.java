/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver2;
import java.rmi.Remote;
import java.rmi.RemoteException;
import model.ModelInt;

public interface ChatServerInt extends Remote {

   public  void tellOthers(String msg) throws RemoteException;

    public void register(ModelInt clientRef) throws RemoteException;

   public  void unRegister(ModelInt clientRef) throws RemoteException;
}
