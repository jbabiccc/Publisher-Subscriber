package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Article;
import model.Subscriber;
import server.BrokerService;


public class ControllerUI implements Initializable
{
   @FXML
   private TextField usernameField;
   
   @FXML
   private TextField categoryField;
   
   @FXML
   private Button subscribeButton;
   
   @FXML
   private TextArea articleArea;
   
     private  RMI subRmi;
   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
     System.out.println("Write your username");
     Scanner input = new Scanner(System.in);
     String name = input.nextLine();
     try
   {
      subRmi = new RMI(name,this);
   }
   catch (RemoteException e)
   {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   catch (MalformedURLException e)
   {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   catch (NotBoundException e)
   {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
     usernameField.setText(name);
   }
   @FXML
   public void subscribeButtonPressed(ActionEvent event) throws RemoteException
   {
      
      
      if(usernameField.getText().equals("") || categoryField.getText().equals(""))
      {
         
      }
      else {
         
         Subscriber sub = new Subscriber(usernameField.getText());
         String category = categoryField.getText();
         Subscriber returnSub = subRmi.subscribe(category,sub);
         

      }
   }
   //return just what i got from RMI
   public Article displayTheMessage(Article a) throws RemoteException
   {
     articleArea.setText(a.getTitle()+"\n"+a.getBody());
    return a; 
   }
}
