package client;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Article;
import model.Subscriber;

public interface IRMI extends Remote 
{
    Subscriber subscribe(String category, Subscriber s) throws RemoteException;
    Article sendArticle(Article a) throws RemoteException, MalformedURLException, AlreadyBoundException, NotBoundException;
}
