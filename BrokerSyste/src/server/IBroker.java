package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Article;
import model.Subscriber;

public interface IBroker extends Remote
{
     public Article publishArticle(Article a) throws RemoteException;
     // This method should handle information from client
     public Subscriber subscribe(Subscriber s, String category) throws RemoteException;
    
}
