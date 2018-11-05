package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import client.IRMI;
import model.Article;
import model.ArticleMap;
import model.Subscriber;

public class BrokerService implements IBroker
{
   private ArticleMap map;

   public BrokerService() throws RemoteException, MalformedURLException,
         AlreadyBoundException, NotBoundException
   {

      // Bind the remote object's stub in the registry
      //Registry registry = LocateRegistry.getRegistry(1099);
      Registry registry = LocateRegistry.createRegistry(1099);
      //rgsty.rebind("hello", hello);
      UnicastRemoteObject.exportObject(this, 0);
      Naming.rebind("rmi://localhost/Broker", this);
      System.out.println("server is working");

      map = new ArticleMap();
   }

   @Override
   public Article publishArticle(Article a) throws RemoteException
   {
      // get list of specific category subs (usernames)
      Subscriber[] list = map.getListOfPeople(a.getCategory())
            .getSubscribersList();

      Article art = null;
      IRMI sub = null;
      // For each subscriber on list (send the article)
      for (Subscriber s : list)
      {
         try
         {
            sub = (IRMI) Naming.lookup("rmi://localhost/" + s.getUsername());
            try
            {
               art = sub.sendArticle(a);
            }
            catch (AlreadyBoundException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

         }
         catch (MalformedURLException | NotBoundException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

      return art;

   }

   // assigns new Subscriber to a list
   @Override
   public Subscriber subscribe(Subscriber s, String category)
         throws RemoteException
   {
      return map.addSubscriberToList(s, category);
      
   }

}
