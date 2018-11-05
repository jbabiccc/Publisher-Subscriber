package server;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Article;

public class ControllerUI implements Initializable
{
   
   @FXML 
   private TextField titleField;
   @FXML
   private TextField categoryField;
   @FXML 
   private TextArea messageArea;
   @FXML
   private Button publishButton;
   
   private IBroker broker;
   
   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      try
      {
         broker = new BrokerService();
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
      catch (AlreadyBoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (NotBoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   @FXML
   public void publishButtonPressed(ActionEvent event) throws RemoteException
   {
      
      
      if(titleField.getText().equals("") || categoryField.getText().equals("") || messageArea.getText().equals("")) {
         
      } else
      {
         //create new article with fulfiled fields;
         Article a = new Article(titleField.getText(),messageArea.getText(),categoryField.getText());
         broker.publishArticle(a);
      }
   }
   
}
