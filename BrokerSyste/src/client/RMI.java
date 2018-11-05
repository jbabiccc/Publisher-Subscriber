package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.Article;
import model.Subscriber;
import server.IBroker;
// SUBSCRIBER RMI CLASS
public class RMI implements IRMI
{
     private IBroker broker;
     //calling 
     private ControllerUI ui;
     

   public RMI(String username, ControllerUI ui) throws RemoteException, MalformedURLException, NotBoundException
   {
      UnicastRemoteObject.exportObject(this, 0);
      // we bind the username for each subsriber we make
      // so the server could find the specific subscriber afterwards
      Naming.rebind("rmi://localhost/"+username, this);
      broker = (IBroker) Naming.lookup("rmi://localhost:1099/Broker");
      this.ui = ui;
   }

   @Override
   public Subscriber subscribe(String category, Subscriber s) throws RemoteException
   {
      // hey yo broker i need your help
      return broker.subscribe(s, category);
   }

   @Override
   public Article sendArticle(Article a) throws RemoteException
   {
      return ui.displayTheMessage(a);
   }
   
}
