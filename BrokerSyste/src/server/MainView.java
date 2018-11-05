package server;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

   public class MainView extends Application
   {
      public void start(Stage stage) throws IOException
      {
         AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("server/publisher.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));                 
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.setTitle("Publisher");
          stage.setResizable(false);
          stage.show();
      }

    
      public static void main(String[] args)
      {

         launch(args);

      }

}
