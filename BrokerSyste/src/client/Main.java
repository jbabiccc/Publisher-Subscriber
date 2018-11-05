package client;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{
   public void start(Stage stage) throws IOException
   {
      AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("client/subscriber.fxml"));

       Scene scene = new Scene(root);

       stage.setScene(scene);
       stage.setTitle("Subscriber");
       stage.setResizable(false);
       stage.show();
   }

   public static void main(String[] args)
   {

      launch(args);

   }
}
